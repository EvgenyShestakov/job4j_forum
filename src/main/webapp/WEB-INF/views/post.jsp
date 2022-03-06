<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html  lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Accident</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <h4>Форум job4j</h4>
    </div>
    <div class="row">
        <a class="nav-link" href='<c:url value="/index"/>'>Главная</a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">Дата создания</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><c:out value="${post.name}"/></td>
                <td><c:out value="${post.created}"/></td>
            </tr>
            </tbody>
        </table>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Сообщения</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <ul>
                        <c:forEach items="${post.messages}" var="message">
                            <li>${message.message}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
        <form action="<c:url value='/post?id=${post.id}'/>" method='POST'>
            <table>
                <tr>
                    <td>Сообщение:</td>
                    <td><input type='text' name='message'></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>