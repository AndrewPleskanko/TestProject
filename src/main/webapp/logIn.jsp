<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="d-flex justify-content-center align-items-center" style="height: 100vh;">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h1 class="text-center">Registration Page</h1>
            <form action="${pageContext.request.contextPath}/logIn" method="GET">
                <div class="form-group">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" name="login" id="login" value="${login}">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" value="${password}">
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary">Log In</button>
                </div>
                <p class="text-center">${errorLoginOrPassword}</p>
            </form>
            <hr>
            <form action="${pageContext.request.contextPath}/userRegister.jsp" method="GET">
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-secondary">Registration</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
