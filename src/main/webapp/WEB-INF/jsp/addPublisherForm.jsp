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
<form:form method="post" modelAttribute="publisher">
    Nazwa: <form:input path="name" /><br>
    <form:errors path="name"
                 cssClass="error" /></br>
    NIP: <form:input path="nip"/><br>
    <form:errors path="nip"
                 cssClass="error" /></br>
    REGON: <form:input path="regon"/><br>
    <form:errors path="regon"
                 cssClass="error" /></br>
    <input type="submit" value="save"/>
</form:form>
</body>
</html>
