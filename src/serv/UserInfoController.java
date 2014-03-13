package serv;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<String> error_message = new ArrayList<String>();

		UserDB userdb = new UserDB();
		CirculationDB cirdb = new CirculationDB();

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");

	    try {
	    	int uid = Integer.parseInt( request.getParameter("uid") );
	    	User user = userdb.getUserDetail(uid);
			if( user != null ){
				request.setAttribute("users", user );
				ArrayList<Circulation> list = cirdb.getCirculationsOnIssueByUid(uid);
				request.setAttribute("list", list );
			} else {
				error_message.add("該当するIDの利用者はいません。");
			}
	    } catch (NumberFormatException ex) {
			error_message.add("数字以外が入力されました。");
			error_message.add("該当するIDの利用者はいません。");
	    }
		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("user_info.jsp");
		dispatch.forward(request, response);
	}

}
