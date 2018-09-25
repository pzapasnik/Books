<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author Index</title>
</head>
<body>
    <c:forEach items="${authors}" var="author">
        Imie i Nazwisko: ${author.getFullName()}, Ksiazki:
        <c:forEach items="${author.getBooks()}" var="book">
            ${book.getTitle()},
        </c:forEach>
        PESEL: ${author.getPesel()},
        Email: ${author.getEmail()},
        Year Of Birth: ${author.getYearOfBirth()},
        <a href="/editAuthor/${author.getId()}"> Edytuj</a>
        <a href="/delateAuthor/${author.getId()}">Usun</a>
        <br>
    </c:forEach>
    <a href="/addAuthor">Dodaj nowego Autora</a><br/>
    <a href="/">Index</a>
</body>
</html>