package serv;

import java.io.IOException;
import java.io.PrintWriter;

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


		UserDB userdb;
		User user;

		request.setCharacterEncoding("UTF-8");
		String uid = request.getParameter("uid");
		String bid = request.getParameter("bid");

	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();


		user = userdb.getUserDetail(uid);

		//
		// ここに実装する
		//

		RequestDispatcher dispatch = request.getRequestDispatcher("rent_result.jsp");
		dispatch.forward(request, response);
	}

}
