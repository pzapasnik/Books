<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author add</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form method="post" modelAttribute="author">
        Imie: <form:input path="firstName"/><br>
        <form:errors path="firstName"
                     cssClass="error" /></br>
        Nazwisko: <form:input path="lastName"/><br>
        <form:errors path="lastName"
                     cssClass="error" /></br>
        Książki:  <form:select path="books" items="${books}" itemValue="id" itemLabel="title" multiple="true"/> <br>
        <form:errors path="books"
                     cssClass="error" /></br>
        PESEL: <form:input path="pesel"/><br>
        <form:errors path="pesel"
                     cssClass="error" /></br>
        Email: <form:input path="email"/><br>
        <form:errors path="email"
                     cssClass="error" /></br>
        Year Of Birth: <form:input path="yearOfBirth"/><br>
        <form:errors path="yearOfBirth"
                     cssClass="error" /></br>
        <input type="submit" value="save">
    </form:form>
</body>
</html>
