<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="container">
        <h2 class="text-center">Users not found</h2>
        <div class="text-center">
            <form action="${pageContext.request.contextPath}/usersList" method="GET">
                <button type="submit" class="btn btn-primary">Click button for check user list</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
