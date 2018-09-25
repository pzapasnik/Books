<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="Form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form method="post" modelAttribute="book">
        Tytul: <form:input path="title" /><br>
        <form:errors path="title"
                     cssClass="error" /></br>
        Autor: <Form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" multiple="true"/><br>
        <form:errors path="authors"
                     cssClass="error" /></br>
        Rating: <form:input path="rating" /><br>
        <form:errors path="rating"
                     cssClass="error" /></br>
        Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><br>
        <form:errors path="publisher"
                     cssClass="error" /></br>
        Description: <form:textarea path="description" rows="4" cols="15"/><br>
        <form:errors path="description"
                     cssClass="error" /></br>
        Pages: <form:input path="pages"/><br>
        <form:errors path="pages"
                     cssClass="error" /></br>
        <input type="submit" value="save"/>
    </form:form>
</body>
</html>
