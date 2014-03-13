package serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rent_result")
public class RentResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean allowUser = false;
		boolean allowBook = false;

		ArrayList<String> error_message = new ArrayList<String>();

		request.setCharacterEncoding("UTF-8");
		String userNo = request.getParameter("userNo");
		String bookNo = request.getParameter("bookNo");

		UserDB userdb = new UserDB();
		User user = userdb.getUserDetail(userNo);
		userdb.close();


		// 貸出し可能な利用者であることを確認。
		if( user != null ){

			// 貸出の冊数限度の確認
			if( user.getLimitFlag() != true  ){
				int uid = user.getUid();

				// 延滞リスト格納用のArrayLIstを作成
				ArrayList<Circulation> overDueList = new ArrayList<Circulation>();
				// 貸出しデータベースに接続
				CirculationDB circulationdb = new CirculationDB();
				// 延滞リストを取得
				overDueList = circulationdb.getOverDueList();
				circulationdb.close();

				try{
					for (Iterator<Circulation> itr = overDueList.iterator(); itr.hasNext();) {
						Circulation cir = (Circulation) itr.next();
						if ( cir.getUser().getUid() != uid ) { itr.remove(); }
					}
					if(  overDueList.size() != 0 ){
						request.setAttribute("overDueList", overDueList );
						error_message.add("延滞している本があります。返却処理を行ってください。");
					}else{
						allowUser = true;
					}
				}
				catch( Exception ex ){
					allowUser = true;
				}
			}else{
				error_message.add("すでに３冊貸し出し中です。返却処理を行ってください。");
			}
		}else{
			error_message.add("内部エラー。 不明な利用者Noが入力されました。");
		}



		// 図書館本データベースに接続
		LibraryBookDB libbookdb = new LibraryBookDB();
		// 貸し出す本のデータを取得
		LibraryBook libbook = libbookdb.getLibraryBookDetailByBookNo(bookNo);
		libbookdb.close();

		// 貸し出し可能な本であることを確認する。
		if( libbook != null ){

			// 貸出しデータベースに接続
			CirculationDB circulationdb = new CirculationDB();

			// 貸しだしされている本でないことを確認
			if( circulationdb.getCirculationOnIssueByBookNo(bookNo) == null ){
				allowBook = true;
			}else{
				error_message.add("すでに貸し出されている本です。返却処理を行ってください。");
			}
			circulationdb.close();

		}else{
			error_message.add("内部エラー。 不明な書籍Noが入力されました。");
		}

		// 利用者、書籍とも貸し出し可能であれば、貸出し手続きの実行
		if( allowUser && allowBook ){
			// 貸出しデータベースに接続
			CirculationDB circulationdb = new CirculationDB();
			if( circulationdb.insert( user.getUid(), libbook.getLbid() ) != 1 ){
				// 貸出し処理のエラー（insertエラー）
				error_message.add("内部エラー。 貸出し処理に失敗しました。");
			}else{
				Circulation circulation = circulationdb.getLatestCirculation();
				request.setAttribute("circulation", circulation );
				// 3冊目ならフラグ立てる
				if ( circulationdb.getCirculationsOnIssueByUid( user.getUid() ).size() >= 3 ) {
					UserDB userdb_tmp = new UserDB();
					userdb_tmp.setLimitFlag( user.getUid(), true );
					userdb_tmp.close();
				}
			}
			circulationdb.close();
		}

		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("rent_result.jsp");
		dispatch.forward(request, response);
	}
}

