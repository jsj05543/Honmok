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
 * Servlet implementation class SearchResultController
 */
@WebServlet("/search_book_result")
public class SearchBookResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> error_message = new ArrayList<String>();
		ArrayList<LibraryBook> libbooks = new ArrayList<LibraryBook>();
		ArrayList<String> clist = new ArrayList<String>();
		request.setCharacterEncoding("UTF-8");

		String bookNo = request.getParameter("search_bookNo");
		String bookName = request.getParameter("search_bookName");

		if(  bookNo != null && bookNo.length() != 0  ){
			LibraryBookDB librarybookdb = new LibraryBookDB();
			LibraryBook libbook = librarybookdb.getLibraryBookDetailByBookNo(bookNo);
			if( libbook != null ){
				libbooks.add( libbook );
			}
			librarybookdb.close();
		}else if(  bookName!= null && bookName.length() != 0 ){
			LibraryBookDB librarybookdb = new LibraryBookDB();
			libbooks = librarybookdb.getLibraryBookDetailByBname(bookName);
			librarybookdb.close();
		}else{
			error_message.add("検索条件を入力してください。");
		}

		CirculationDB circulationdb = new CirculationDB();
		for( int i=0; i<libbooks.size(); i++ ){
			Circulation tmpc = circulationdb.getCirculationOnIssueByBookNo(libbooks.get(i).getBookNo() );

			if( tmpc != null ){
				String tmpstr = "貸出し中（" + tmpc.getUser().getUserNo() + "）";
				clist.add( tmpstr );
			}else{
				clist.add("貸出し可");
			}
			circulationdb.close();
		}


		request.setAttribute("clist", clist);
		request.setAttribute("libbooks", libbooks);
		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("show_book.jsp");
		dispatch.forward(request, response);
	}

}
