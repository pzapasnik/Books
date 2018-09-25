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
<c:forEach items="${allPublishers}" var="publisher">
    Nazwa: ${publisher.getName()},
    NIP: ${publisher.getNip()},
    REGON: ${publisher.getRegon()}
    <a href="/editPublisher/${publisher.getId()}">Edit</a>
    <a href="/delatePublisher/${publisher.getId()}">Delate</a>
    <br>
</c:forEach>
<a href="/addPublisher">Dodaj Nowego Wydawce</a><br/>
<a href="/">Index</a>
</body>
</html>