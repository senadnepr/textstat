<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="resources/js/viewcom.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<h3>Load</h3>

<form method="post" action="load" enctype="multipart/form-data">
    <div class="form-group">
        <label for="file">Example file input</label>
        <input type="file" name="file" class="form-control-file" id="file">
    </div>
    <button type="submit">Load</button>



</form>

<h3>${error}</h3>

<div id="div1"><h2>${message}</h2></div>
<a href="view">view</a>



</body>
</html>
