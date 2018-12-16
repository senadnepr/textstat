<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>

<html>
<head>
    <title>Text Files Statistic</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="resources/js/tablestat.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<body>
<div class="container">
    <h1>Customer Table</h1>
    <div class="row col-md-7 table-responsive">
        <table id="customerTable" class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>Name</th>
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

<a href="home">home</a>
<a href ="load">another load?</a>

</body>
</html>

