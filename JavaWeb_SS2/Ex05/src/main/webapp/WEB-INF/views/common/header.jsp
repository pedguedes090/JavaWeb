<%--
  Created by IntelliJ IDEA.
  User: anlinh
  Date: 6/4/26
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div>
    <a href="<c:url value='/employees'/>">Danh sách NV</a>

    <span> | Xin chào, <c:out value="${sessionScope.loggedUser}"/></span>

    <c:if test="${sessionScope.role == 'hr_manager'}">
        <span> (Manager)</span>
    </c:if>

    <a href="<c:url value='/logout'/>">Đăng xuất</a>
</div>
<hr/>