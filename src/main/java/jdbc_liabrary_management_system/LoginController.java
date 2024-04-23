package jdbc_liabrary_management_system;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserCRUD crud = new UserCRUD();
		try {
			String dbpassword = crud.loginUser(email);
			if (dbpassword != null) {
				if (dbpassword.equals(password)) {
					req.setAttribute("message", "Login SuccessFul!!!");
					resp.sendRedirect("book.jsp");
					RequestDispatcher dispatcher = req.getRequestDispatcher("book.jsp");
					dispatcher.include(req, resp);

				} else {
					req.setAttribute("message", "Invalid Password!!!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
				}
			} else {
				req.setAttribute("message", "User Not Resgistered!! Please Register!!!");
				resp.sendRedirect("signup.jsp");
				RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
				dispatcher.include(req, resp);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
