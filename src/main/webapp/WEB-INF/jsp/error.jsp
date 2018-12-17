<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container"></div>
    <a href="home" class="btn btn-primary" role="button">Home</a>
    <a href="load" class="btn btn-primary" role="button">Load</a>
    <a href="view" class="btn btn-primary" role="button">View</a>
    <div class="center">

        <h2>ERROR PAGE</h2>

        <h3> Maybe something went wrong</h3>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>
