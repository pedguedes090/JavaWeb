<%--
  Created by IntelliJ IDEA.
  User: anlinh
  Date: 6/4/26
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<body>

<h2>Dang nhap</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red"><c:out value="${errorMessage}"/></p>
</c:if>

<form method="post" action="<c:url value='/login'/>">
    Username: <input name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    <button type="submit">Login</button>
</form>

</body>
</html>