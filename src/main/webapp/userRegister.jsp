<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
<body>

<div class="container">
    <h1 class="text-center">Employee Register Form</h1>
    <form action="${pageContext.request.contextPath}/register" method="GET">
        <div class="form-group row">
            <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="firstName" id="firstName" value="${firstName}">
            </div>
        </div>
        <p class="text-center"> ${errorName} </p>
        <div class="form-group row">
            <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="lastName" id="lastName" value="${lastName}">
            </div>
        </div>
        <p class="text-center"> ${errorSurname} </p>
        <div class="form-group row">
            <label for="login" class="col-sm-2 col-form-label">Login</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="login" id="login" value="${login}">

            </div>
        </div>

        <p class="text-center"> ${errorLogin} </p>

        <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" id="password"  value="${password}">
            </div>
        </div>
        <p class="text-center"> ${errorPassword} </p>
        <div class="form-group row">
            <div class="col-sm-12 text-center">
                <button type="submit" class="btn btn-primary">Create user</button>
            </div>
        </div>

    </form>
</div>

<!-- Підключення файлів скриптів Bootstrap та jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
