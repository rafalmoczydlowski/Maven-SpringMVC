<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Zawodnicy Barcelony</title>
</head>
<body>
<c:forEach items="${playerList}" var="player" >
<li id="player <c:out value="player.name"/>">
    <div class="playerSurname">
        <c:out value="${player.surname}"/>
    </div>
    <div>
        <span class="playerClub">
            <c:out value="${player.club}"/>
        </span>
        <span class="playerPosition">
            <c:out value="${player.position}"/>
        </span>
    </div>
</li>
</c:forEach>
</body>
</html>