package serv;

import java.io.IOException;
import java.io.PrintWriter;

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

		UserDB userdb = new UserDB();
		User user = new User();

		request.setCharacterEncoding("UTF-8");
		String uid = request.getParameter("uid");
		String bid = request.getParameter("bid");

	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();


		user = userdb.getUserDetail(uid);

		if( user == null ){
			out.println("");
		}else{
			out.println(user.getUname());
		}



		//
		// ここに実裁��
		//

		RequestDispatcher dispatch = request.getRequestDispatcher("return_result.jsp");
		dispatch.forward(request, response);
	}

}
