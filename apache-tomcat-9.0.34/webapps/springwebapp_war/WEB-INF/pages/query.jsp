<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
    <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"
            charset=ISO-8859-1">
    <title>Query</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="res/css/global.css" type="text/css" rel="stylesheet">
</head>

<body class="bg">

<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 col-sm-8 col-xs-12">
            <form:form id="queryform" class="query-container" modelAttribute="query" action="queryprocess" method="post">
                <div class="form-group">
                    <label for="query" class="font">Query</label>
                    <input type="text" class="form-control" id="query" name="query" path="query" placeholder="Enter query">
                </div>
                <button type="submit" class="btn btn-success btn-block" id="execute" name="execute">Execute</button>
                <c:choose>
                    <c:when test="${condition=='rooster'}">
                        <table class="table-bordered font border" align="center">
                            <thead>
                                <tr>
                                    <th>Nickname</th>
                                    <th>First Name</th>
                                    <th>Surname</th>
                                    <th>Position</th>
                                    <th>Birthday</th>
                                    <th>Weight</th>
                                    <th>Height</th>
                                    <th>Birthstate</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${resultset}" var="row">
                                    <tr>
                                        <th>${row.nickname}</th>
                                        <th>${row.firstname}</th>
                                        <th>${row.surname}</th>
                                        <th>${row.position}</th>
                                        <th>${row.birthday}</th>
                                        <th>${row.weight}</th>
                                        <th>${row.height}</th>
                                        <th>${row.birthstate}</th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:when test="${condition=='stafflist'}">
                        <table class="table-bordered font border" align="center">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Contract from</th>
                                    <th>Contract to</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${resultset}" var="row">
                                    <tr>
                                        <th>${row.name}</th>
                                        <th>${row.position}</th>
                                        <th>${row.contractFrom}</th>
                                        <th>${row.contractTo}</th>
                                        <th>${row.email}</th>
                                        <th>${row.phone}</th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:when test="${condition=='string'}">
                        <p class="alert alert-danger">${resultset.get(0)}</p>
                    </c:when>
                </c:choose>
            </form:form>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-12">
            <form:form id="logsform" class="query-container" modelAttribute="query" action="logs" method="post">
                <button type="submit" class="btn btn-primary btn-block" id="scantables" name="scantables" align="center">Show logs</button>
                <table class="table-bordered border" align="center">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Query</th>
                            <th>Result</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${logs}" var="log">
                            <tr>
                                <th>${log.id}</th>
                                <th>${log.query}</th>
                                <th>${log.result}</th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form:form>
            <form:form id="scanform" class="query-container" modelAttribute="query" action="scan" method="post">
                <button type="submit" class="btn btn-primary btn-block" id="scantables" name="scantables" align="center">Available tables</button>
                <table class="table-bordered border" align="center">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Fields</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tables}" var="table">
                        <tr>
                            <th>${table.title}</th>
                            <th>
                                <c:forEach items="${table.data}" var="field">
                                    <p>${field}</p>
                                </c:forEach>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form:form>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>