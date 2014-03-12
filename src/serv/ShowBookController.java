package serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show_book")
public class ShowBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> error_message = new ArrayList<String>();

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");

	    String search_id = request.getParameter("search_id");
	    String search_name = request.getParameter("search_name");

	    LibraryBookDB db = new LibraryBookDB();

	    // DB検索処理
	    ArrayList<LibraryBook> list = null;
	    if ( search_id != null ){
		    // 書籍番号で検索
	    	list = db.getLibraryBookDetailByBookNo(search_id);
	    }
	    else if( search_name != null ){
	    	// 書籍名で検索
	    	list = db.getLibraryBookDetailByBname(search_name);
	    }
	    db.close();

	    // 検索結果の判定
	    if ( list != null && ! list.isEmpty() ){
	    	request.setAttribute("bookInfo", list );
	    }else{
	    	error_message.add("該当する書籍は見つかりませんでした。");
	    	request.setAttribute("error_message", error_message);
	    }

	    RequestDispatcher dispatch = request.getRequestDispatcher("show_book.jsp");
		dispatch.forward(request, response);
	}

}
