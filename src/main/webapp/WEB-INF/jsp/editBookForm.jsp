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
        <form:form method="post" modelAttribute="book">
            Tytul: <form:input path="title" /><br>
            Autorzy: <form:checkboxes path="authors" items="${authors}" itemValue="id" itemLabel="fullName"/><br>
            Rating: <form:input path="rating" /><br>
            Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><br>
            Description: <form:textarea path="description" rows="4" cols="15"/><br>
            Pages: <form:input path="pages"/><br>
            <input type="submit" value="save">
        </form:form>

</body>
</html>
