package serv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user_info")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDB userdb = new UserDB();
//		User user = new User();

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");

	    try {
	    	int uid = Integer.parseInt( request.getParameter("uid") );
	    	User user = userdb.getUserDetail(uid);
			if( user == null ){
				request.setAttribute("error_message", "該当するIDの利用者はいません");
			} else {
				request.setAttribute("users", user );
			}
	    } catch (NumberFormatException ex) {
			request.setAttribute("error_message", "該当するIDの利用者はいません");
	    }
		RequestDispatcher dispatch = request.getRequestDispatcher("user_info.jsp");
		dispatch.forward(request, response);
	}

}
