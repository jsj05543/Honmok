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

@WebServlet("/register_result")
public class RegisterResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterResultController() {
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

	    // admin表示切り替え制御
		String admin = request.getParameter("admin");
		if (admin != null) {
			request.setAttribute("admin", admin );
		}

		try {
	    	String uname   = request.getParameter("uname");
	    	String address = request.getParameter("address");
	    	String tel     = request.getParameter("tel");
	    	String userNo;

	    	if ( userdb.insert(null, uname, address, tel) == -1 ) {
				error_message.add("同じ氏名・住所・TELが登録されています。");
			} else {
				// これはかっこわるい
				for (int i = 100000; i < 1000000; i++) {
					userNo = Integer.toString(i);
					if ( userdb.usedUserNo(userNo) ) {
						// error_message.add("その利用者番号はすでに使われてます");
					} else {
				    	if ( StringUtils.isBlank(uname) ||
				    			StringUtils.isBlank(address) ||
				    			StringUtils.isBlank(tel) ) {
				    		error_message.add("空文字は入れないでください");
				    	} else {
				    		int ret = userdb.insert(userNo, uname, address, tel);
				    		if ( ret == -1 ) {
				    			error_message.add("同じ氏名・住所・TELが登録されています。");
				    		} else if ( ret == 0 ) {
						    	error_message.add("内部エラーです");
				    		} else {
				    			request.setAttribute("userNo", userNo);
				    		}
				    	}
				    	break;
		    		}
				}
			}
	    } catch (Exception ex) {
			error_message.add("内部エラーが発生しました");
	    }
		request.setAttribute("error_message", error_message);
		RequestDispatcher dispatch = request.getRequestDispatcher("register_result.jsp");
		dispatch.forward(request, response);
	}

}
