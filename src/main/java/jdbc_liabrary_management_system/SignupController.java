package jdbc_liabrary_management_system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);

		UserCRUD crud = new UserCRUD();
		try {
			int result = crud.signUpUser(user);
			if (result != 0) {
				req.setAttribute("message", "SignUP Successful !!!!");

				//RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				//dispatcher.forward(req, resp);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
