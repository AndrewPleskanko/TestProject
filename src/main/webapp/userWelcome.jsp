<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <!-- Підключення файлів стилів Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            height: 100vh; /* Робимо тіло документа на весь екран */
            display: flex; /* Встановлюємо flex для роботи з позиціонуванням */
            justify-content: center; /* Центруємо контент по горизонталі */
            align-items: center; /* Центруємо контент по вертикалі */
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Welcome, ${firstName} ${lastName}!</h2>
    <p class="text-center">Thank you for registering with email: ${login}.</p>
    <div class="text-center">
        <form action="${pageContext.request.contextPath}/usersList">
            <button type="submit" class="btn btn-primary">Click button for check user list</button>
        </form>
    </div>
</div>

<!-- Підключення файлів скриптів Bootstrap та jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
