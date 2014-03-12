package serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user_list")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> error_message = new ArrayList<String>();

		UserDB userdb = new UserDB();

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");

    	String search_id   = request.getParameter("search_id");
    	String search_name = request.getParameter("search_name");
    	// とりあえずあとで作るから、まずは全部取得する
    	ArrayList<User> allUsers = userdb.getUsers();
    	if ( allUsers != null ) {
    		request.setAttribute("list", allUsers);
    	} else {
    		error_message.add("DBアクセスエラーが発生しました");
    	}
		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("user_list.jsp");
		dispatch.forward(request, response);
	}

}
