<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <a href="home" class="btn btn-primary" role="button">Home</a>
        <a href="view" class="btn btn-primary" role="button">View</a>

        <div class="center">
            <h2>Load page</h2>


        <form method="post" action="load" enctype="multipart/form-data">
            <div class="form-group" style="alignment: center">
                <input type="file" accept=".txt" name="file" class="form-control-file" id="file">
            </div>
            <button type="submit" class="btn btn-primary">Load</button>
        </form>

        <h3 class="error">${error}</h3>
        <h2>${message}</h2>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
