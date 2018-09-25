<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Index</title>
</head>
<body>
    <c:forEach items="${books}" var="book">
        Tytul: ${book.getTitle()},
        Autorzy: <c:forEach items="${book.getAuthors()}" var="author">
         ${author.getFullName()},
        </c:forEach>
        Rating: ${book.getRating()},
        Publisher: ${book.getPublisher().getName()},
        Description: ${book.getDescription()},
        Pages: ${book.getPages()}
        <a href="/editBook/${book.getId()}">Edit</a>
        <a href="/delateBook/${book.getId()}">Delate</a>
        <br>
    </c:forEach>
        <a href="/addBook">Dodaj nowa ksiazke</a><br/>
        <a href="/">Index</a>
</body>
</html>