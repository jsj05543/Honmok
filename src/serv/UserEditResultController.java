package serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/user_edit_result")
public class UserEditResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditResultController() {
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

		try {
			int uid        = Integer.parseInt( request.getParameter("uid") );
	    	String delete  = request.getParameter("delete");
	    	String update  = request.getParameter("update");
	    	if ( delete != null ) {
	    		// 削除モード
		    	if ( userdb.delete(uid) > 0 ) {
	    			request.setAttribute("message", "削除しました");
	    		} else {
			    	error_message.add("削除できませんでした(内部エラー)");
	    		}
	    	} else if ( update != null ) {
	    		// 変更モード
				String uname   = request.getParameter("uname");
		    	String address = request.getParameter("address");
		    	String tel     = request.getParameter("tel");
		    	if ( StringUtils.isBlank(uname) ||
		    			StringUtils.isBlank(address) ||
		    			StringUtils.isBlank(tel) ) {
		    		error_message.add("空文字は入れないでください");
		    	} else if ( userdb.update(uid, uname, address, tel) > 0 ) {
	    			request.setAttribute("message", "変更しました");
	    		} else {
			    	error_message.add("変更できませんでした(内部エラー)");
	    		}
	    	} else {
		    	error_message.add("変更/削除できませんでした(POSTパラメータエラー)");
	    	}
	    } catch (Exception ex) {
	    	error_message.add("変更/削除できませんでした(例外発生)");
	    }
		userdb.close();
		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("user_edit_result.jsp");
		dispatch.forward(request, response);
	}
}
