<%--
  Created by IntelliJ IDEA.
  User: anlinh
  Date: 6/4/26
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<body>
<h2>Loii</h2>
<p><c:out value="${errorMessage}"/></p>
<a href="<c:url value='/employees'/>">Quay lai</a>
</body>
</html>