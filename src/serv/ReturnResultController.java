package serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RentResult
 */
@WebServlet("/return_result")
public class ReturnResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnResultController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Boolean allowReturn = false;
		ArrayList<String> error_message = new ArrayList<String>();

		request.setCharacterEncoding("UTF-8");
		String bookNo = request.getParameter("bookNo");

		LibraryBookDB librarybookdb = new LibraryBookDB();
		LibraryBook libbook = librarybookdb.getLibraryBookDetailByBookNo(bookNo);

		if( libbook != null ){
			CirculationDB circulationdb = new CirculationDB();
			Circulation circulation = circulationdb.getCirculationOnIssueByBookNo(bookNo);
			circulationdb.close();

			if( circulation != null ){
				allowReturn = true;
			}else{
				error_message.add("この書籍は貸し出されていないため返却できません。");
			}
		}else{
			error_message.add("内部エラー。 不明な書籍Noが入力されました。");
		}

		if( allowReturn ){
			// 貸出しデータベースに接続
			CirculationDB circulationdb = new CirculationDB();
			Circulation circulation = circulationdb.getCirculationOnIssueByBookNo(bookNo);

			if( circulationdb.update( circulation.getLibraryBook().getLbid()  ) != 1 ){
				// 貸出し処理のエラー（insertエラー）
				error_message.add("内部エラー。 返却処理に失敗しました。");
			}else{
				// Circulation circulation = Insertした貸出し情報を取得
				request.setAttribute("circulation", circulation );
			}
		}

		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("return_result.jsp");
		dispatch.forward(request, response);
	}

}
