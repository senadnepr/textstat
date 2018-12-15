<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>View</h3>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Number Of String</th>
        <th>Average Number Word Of String</th>
        <th>Max Length Of Word</th>
        <th>Min Length Of Word</th>
    </tr>
    </thead>
    <c:forEach items="${textFiles}" var="textFiles">
        <jsp:useBean id="textFiles" scope="page" type="ua.senadnepr.textstat.model.TextFile"/>
        <tr>

            <td>${textFiles.name}</td>
            <td>${textFiles.numberOfString}</td>
            <td>${textFiles.averageNumber}</td>
            <td>${textFiles.maxWord}</td>
            <td>${textFiles.minWord}</td>

        </tr>
    </c:forEach>
</table>
<a href="load">another load?</a>
<a href="home">home</a>

</body>
</html>
