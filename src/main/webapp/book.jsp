<%@page import="jdbc_liabrary_management_system.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="addbook.jsp" title="addbook"><button>AddBook</button></a>
	<a href="findbook.jsp" title="findbook"><button>FindBook</button></a>
	<a href="login.jsp" title="logout"><button>Exit</button></a>

	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
		out.print("<h1>" + message + "</h1>");
	}
	%>

	<%List<Book> list = (List) request.getAttribute("list");%>
	<table border="2px solid" cellpadding="20px" cellspacing="5px">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>author</th>
        <th>genre</th>
    </tr>
    <% for (Book book : list) { %>
        <tr>
            <td><%=book.getId()%></td>
            <td><%=book.getName()%></td>
            <td><%=book.getAuthor()%></td>
            <td><%=book.getGenre()%></td>
   
            <td><a href="delete?id=<%= book.getId() %>"><button title="delete">DELETE</button> </a></td>
            <td><a href="update?id=<%= book.getId() %>"><button title="update">UPDATE</button> </a></td>
        </tr>
    <% } %>
    </table>
</body>
</html>