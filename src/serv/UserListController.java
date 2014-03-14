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
    	if ( search_id != null ) {
    		// 利用者番号検索モード
        	ArrayList<User> userList = new ArrayList<User>();
        	User user = userdb.getUserDetail(search_id);
        	if ( user != null ) {
            	userList.add( user );
        		request.setAttribute("list", userList);
        	} else {
        		error_message.add("一致する利用者はいませんでした");
        	}
    	} else if ( search_name != null ) {
        	// 利用者名検索モード
        	ArrayList<User> userList = userdb.getUserDetailByUname(search_name);
        	if ( userList != null ) {
        		request.setAttribute("list", userList);
        	} else {
        		error_message.add("一致する利用者はいませんでした");
        	}
    	} else {
	    	error_message.add("不正な呼び出しです(POSTパラメータエラー)");
    	}
    	userdb.close();
		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("user_list.jsp");
		dispatch.forward(request, response);
	}

}
