<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.userList.dataDefinition.FieldName" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="text-center align-middle">User List</h2>
    <div class="d-flex justify-content-between mb-2">

        <form action="${pageContext.request.contextPath}/change" method="GET">
            <input type="hidden" name="userId" value="${user.id}"/>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>

        <form action="${pageContext.request.contextPath}/change" method="post">
            <div class="input-group mb-2">
                <input type="text" name="searchText" placeholder="Enter Data" aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <input type="hidden" name="action" value="search"/>
                    <button type="submit" class="btn btn-outline-secondary">Search</button>
                </div>
            </div>
        </form>

    </div>

    <table class="table table-bordered table-striped">
        <tr>
            <th class="text-center">

                <div class="d-flex align-items-center justify-content-between">
                    <p class="m-0">Name</p>

                    <form action="${pageContext.request.contextPath}/usersList" method="post">
                        <input type="hidden" name="${FieldName.SORT_COLUMN}" value="first_name"/>
                        <input type="hidden" name="${FieldName.SORT_ORDER}" value="ASC"/>
                        <button type="submit"
                                class="btn btn-link" ${isSortOrderAscending ? 'style="display: none;"' : ''}>&#9650;
                        </button>
                    </form>

                    <form action="${pageContext.request.contextPath}/usersList" method="post">
                        <input type="hidden" name="${FieldName.SORT_COLUMN}" value="first_name"/>
                        <input type="hidden" name="${FieldName.SORT_ORDER}" value="DESC"/>
                        <button type="submit"
                                class="btn btn-link" ${isSortOrderAscending ? '' : 'style="display: none;"'}>&#9660;
                        </button>
                    </form>

                </div>
            </th>
            <th class="text-center">

                <div class="d-flex align-items-center justify-content-between">
                    <p class="m-0">Surname</p>
                    <form action="${pageContext.request.contextPath}/usersList" method="post">
                        <input type="hidden" name="${FieldName.SORT_COLUMN}" value="last_name"/>
                        <input type="hidden" name="${FieldName.SORT_ORDER}" value="ASC"/>
                        <button type="submit"
                                class="btn btn-link" ${isSortOrderAscending ? 'style="display: none;"' : ''}>&#9650;
                        </button>
                    </form>

                    <form action="${pageContext.request.contextPath}/usersList" method="post">
                        <input type="hidden" name="${FieldName.SORT_COLUMN}" value="last_name"/>
                        <input type="hidden" name="${FieldName.SORT_ORDER}" value="DESC"/>
                        <button type="submit"
                                class="btn btn-link" ${isSortOrderAscending ? '' : 'style="display: none;"'}>&#9660;
                        </button>
                    </form>
                </div>
            </th>
            <th class="text-center">

                <div class="d-flex align-items-center justify-content-between">
                    <p class="m-0">Login</p>
                    <form action="${pageContext.request.contextPath}/usersList" method="post">
                        <input type="hidden" name="${FieldName.SORT_COLUMN}" value="login"/>
                        <input type="hidden" name="${FieldName.SORT_ORDER}" value="ASC"/>
                        <button type="submit"
                                class="btn btn-link" ${isSortOrderAscending ? 'style="display: none;"' : ''}>&#9650;
                        </button>
                    </form>
                    <form action="${pageContext.request.contextPath}/usersList" method="post">
                        <input type="hidden" name="${FieldName.SORT_COLUMN}" value="login"/>
                        <input type="hidden" name="${FieldName.SORT_ORDER}" value="DESC"/>
                        <button type="submit"
                                class="btn btn-link" ${isSortOrderAscending ? '' : 'style="display: none;"'}>&#9660;
                        </button>
                    </form>
                </div>
            </th>

            <th class="text-center align-middle">Edit</th>
            <th class="text-center align-middle">Delete</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.login}</td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/change" method="POST">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="update"/>
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </form>
                </td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/change" method="POST">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2 class="text-center"> ${hint} </h2>
</div>
<div class="container d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/usersList?page=${currentPage - 1}">Previous</a>
            </li>
            <c:forEach var="pageNum" begin="1" end="${pageCount}">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/usersList?page=${pageNum}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == pageCount ? 'disabled' : ''}">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/usersList?page=${currentPage + 1}">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>