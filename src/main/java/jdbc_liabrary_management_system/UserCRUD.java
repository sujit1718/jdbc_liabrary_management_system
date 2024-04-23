package jdbc_liabrary_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD {
	

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrarydb","root","root");
		return connection;
	}
	
	public int signUpUser(User user) throws Exception
	{
		String sql = "insert into user values(?,?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, user.getId());
	    preparedStatement.setString(2, user.getName());
	    preparedStatement.setLong(3, user.getPhone());
	    preparedStatement.setString(4, user.getEmail());
	    preparedStatement.setString(5, user.getPassword());
	    
	    int result = preparedStatement.executeUpdate();
	    connection.close();
	    return result;
	}
	
	 public String loginUser(String email) throws Exception
	 {
		String sql = "select password from user where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet  = preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		return password;
	}
	 public int addBook(Book book) throws Exception {
		 String sql = "insert into book values(?,?,?,?)";
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(1, book.getId());
		    preparedStatement.setString(2, book.getName());
		    preparedStatement.setString(3, book.getAuthor());
		    preparedStatement.setString(4, book.getGenre());
		    
		    int result = preparedStatement.executeUpdate();
		    connection.close();
		    return result;
	 }
	 public List<Book> displayBook() throws Exception {
		 String sql = "select * from book";
		 Connection connection = getConnection();
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 ResultSet resultSet = preparedStatement.executeQuery();
		 List<Book> list = new ArrayList<>();
		 while(resultSet.next()) {
			 Book book = new Book();
			 book.setId(resultSet.getInt("id"));
			 book.setName(resultSet.getString("name"));
			 book.setAuthor(resultSet.getString("author"));
			 book.setGenre(resultSet.getString("genre"));
			
			 list.add(book);
		 }
		 connection.close();
		 return list;
	 } 

}
