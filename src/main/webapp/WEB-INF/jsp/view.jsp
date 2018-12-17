<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script src="resources/js/tablestat.js"></script>
<jsp:include page="fragments/bodyHeader.jsp"/>


<div class="jumbotron">
    <div class="container">
        <a href="home" class="btn btn-primary" role="button">Home</a>
        <a href="load" class="btn btn-primary" role="button">Load</a>

        <div class="center">
            <h3>Table of statistic</h3>
        </div>
            <table id="customerTable" style="width: 100%" class="table table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Full file name and path</th>
                    <th>Number Of String</th>
                    <th>Average Number Word Of String</th>
                    <th>Max Length Of Word</th>
                    <th>Min Length Of Word</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
    </div>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

