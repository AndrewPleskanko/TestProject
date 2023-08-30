<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UPDATE Result</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        th {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mt-3 text-center">Enter new Data</h2>
        <div class="container d-flex justify-content-center align-items-center vh-80">
            <form class="mt-3" action="${pageContext.request.contextPath}/update" method="GET">
                <div class="row">
                    <div class="col-md-12">
                        <label class="col-form-label">First Name</label>
                        <input type="text" name="first_name" class="form-control" value="${user.first_name}"/>
                    </div>
                    <p class="col-md-12 offset-md-3"> ${errorName} </p>
                    <div class="col-md-12">
                        <label class="col-form-label">Last Name</label>
                        <input type="text" name="last_name" class="form-control" value="${user.last_name}"/>
                    </div>
                    <p class="col-md-12 offset-md-3"> ${errorSurname} </p>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <label class="col-form-label">Login</label>
                        <input type="text" name="login" class="form-control" value="${user.login}"/>
                    </div>
                    <p class="col-md-12 offset-md-3"> ${errorLogin} </p>
                    <div class="col-md-12">
                        <label class="col-form-label">Password</label>
                        <input type="password" name="password" class="form-control" value="${user.password}"/>
                    </div>
                    <p class="col-md-12 offset-md-3"> ${errorPassword} </p>
                </div>
                <input type="hidden" name="userId" value="${user.id}"/>
                <input type="submit" class="btn btn-primary mt-3" value="Update user"/>
            </form>
        </div>
    </div>
</body>
</html>