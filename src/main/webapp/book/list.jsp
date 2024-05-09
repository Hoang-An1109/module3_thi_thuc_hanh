<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2024
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Management Application</title>
</head>
<body>
<h1 class="text-center mt-5">Book Management</h1>

<div class="table-responsive">
    <caption><h2>List of Books</h2></caption>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Description</th>
            <th>Quanlity</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.description}"/></td>
                <td><c:out value="${book.quanlity}"/></td>
                <td>
                    <a href="borrowCard?action=create&id=${book.id}" class="btn btn-info">Muon</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
