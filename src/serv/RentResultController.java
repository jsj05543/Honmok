package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

		boolean flag = true;
		ArrayList<String> error_message = new ArrayList<String>();

		request.setCharacterEncoding("UTF-8");
		String userNo = request.getParameter("userNo");
		String bookNo = request.getParameter("bookNo");

		UserDB userdb = new UserDB();
		User user = userdb.getUserDetail(userNo);
		userdb.close();

		LibraryBookDB libbookdb = new LibraryBookDB();
		LibraryBook libbook = libbookdb.getLibraryBookDetailByBookNo(bookNo);
		libbookdb.close();

		if( user != null ){
			request.setAttribute("user", user);
		}else{
			error_message.add("内部エラーが発生しました。 不明な利用者ID");
			flag = false;
		}

		if( libbook != null ){
			request.setAttribute("libbook", libbook);
		}else{
			error_message.add("内部エラーが発生しました。 不明な書籍ID");
			flag = false;
		}


	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

//		貸出の冊数限度チェック（未実装）
//	    out.println( user.getLimitFlag() );
//		if( user.getLimitFlag() != null  ){
//			error_message.add("すでに３冊貸し出し中です。返却処理を行ってください。");
//			flag = false;
//		}


		CirculationDB circulationdb = new CirculationDB();
		circulationdb.close();


		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("rent_result.jsp");
		dispatch.forward(request, response);
	}

}
