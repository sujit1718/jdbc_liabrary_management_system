package jdbc_liabrary_management_system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addbook")
public class AddBookController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("bookname");
		String author = req.getParameter("author");
		String genre = req.getParameter("genre");

		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setGenre(genre);

		UserCRUD crud = new UserCRUD();
		try {
			int result = crud.addBook(book);
			if (result != 0) {
				req.setAttribute("message", "Book Added Successfully!!!!");

				 RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				 dispatcher.forward(req, resp);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
