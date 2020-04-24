<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Query</title>
</head>

<body>
<form:form id="queryForm" modelAttribute="query" action="queryprocess" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="query">Query:</form:label>
            </td>
            <td>
                <form:input path="query" name="query" id="query" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                <form:button id="execute" name="execute">Execute</form:button>
            </td>
        </tr>
        <tr></tr>
        <c:choose>
            <c:when test="${condition=='rooster'}">
                <table border="1" align="center">
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
                </table>
            </c:when>
            <c:when test="${condition=='stafflist'}">
                <table border="1" align="center">
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
                </table>
            </c:when>
            <c:when test="${condition=='string'}">
                <table align="center">
                    <tr>
                        <td>${resultset.get(0)}</td>
                    </tr>
                </table>
            </c:when>
        </c:choose>
    </table>
</form:form>

<form:form id="scanForm" modelAttribute="query" action="scan" method="post">
    <table align="center">
        <tr>
            <td></td>
            <td align="left">
                <form:button id="scantables" name="scantables">Available tables</form:button>
            </td>
        </tr>
        <tr></tr>
        <table border="1" align="center">
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
        </table
    </table>
</form:form>

<form:form id="scanForm" modelAttribute="query" action="logs" method="post">
    <table align="center">
        <tr>
            <td></td>
            <td align="left">
                <form:button id="showlogs" name="showlogs">Show logs</form:button>
            </td>
        </tr>
        <tr></tr>
        <table border="1" align="center">
            <c:forEach items="${logs}" var="log">
                <tr>
                    <th>${log.id}</th>
                    <th>${log.query}</th>
                    <th>${log.result}</th>
                </tr>
            </c:forEach>
        </table>
        <tr>
            <td><a href="home">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>