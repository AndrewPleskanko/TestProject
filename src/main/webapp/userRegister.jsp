<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Register Form</title>
    <!-- Підключення файлів стилів Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center">Employee Register Form</h1>
    <form action="${pageContext.request.contextPath}/register" method="GET" class="mt-4">
        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" name="firstName" id="firstName" value="${firstName}">
            <p class="text-danger">${errorName}</p>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" name="lastName" id="lastName" value="${lastName}">
            <p class="text-danger">${errorSurname}</p>
        </div>
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text" class="form-control" name="login" id="login" value="${login}">
            <p class="text-danger">${errorLogin}</p>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" id="password" value="${password}">
            <p class="text-danger">${errorPassword}</p>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Create user</button>
    </form>
    <form action="${pageContext.request.contextPath}/logIn" method="GET" class="mt-4">
    <input type="hidden" name="logIN" value="logIN">
    <button type="submit" class="btn btn-secondary btn-block">Log in</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
