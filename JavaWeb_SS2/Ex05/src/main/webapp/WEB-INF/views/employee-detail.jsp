<%--
  Created by IntelliJ IDEA.
  User: anlinh
  Date: 6/4/26
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/header.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<h3>Chi tiết nhân viên</h3>

<p>Mã: <c:out value="${emp.code}"/></p>
<p>Tên: <c:out value="${emp.name}"/></p>
<p>Phòng: <c:out value="${emp.department}"/></p>

<p>Lương:
    <c:choose>
        <c:when test="${sessionScope.role == 'hr_manager'}">
            <fmt:formatNumber value="${emp.salary}" type="number"/>
        </c:when>
        <c:otherwise>***</c:otherwise>
    </c:choose>
</p>

<p>Ngày vào:
    <fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/>
</p>

<a href="<c:url value='/employees'/>">Quay lại</a>

<%@ include file="common/footer.jsp" %>Ï