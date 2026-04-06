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

<table border="1">
    <tr>
        <th>#</th><th>Mã</th><th>Tên</th><th>Phòng</th>
        <th>Lương</th><th>Ngày</th><th>Trạng thái</th><th></th>
    </tr>

    <c:forEach var="e" items="${employees}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><c:out value="${e.code}"/></td>
            <td><c:out value="${e.name}"/></td>
            <td><c:out value="${e.department}"/></td>

            <td><fmt:formatNumber value="${e.salary}" type="number"/></td>
            <td><fmt:formatDate value="${e.joinDate}" pattern="dd/MM/yyyy"/></td>

            <td>
                <c:choose>
                    <c:when test="${e.status == 'Đang làm'}">
                        <span style="color:green">Đang làm</span>
                    </c:when>
                    <c:when test="${e.status == 'Nghỉ phép'}">
                        <span style="color:orange">Nghỉ phép</span>
                    </c:when>
                    <c:otherwise>
                        <span style="color:blue">Thử việc</span>
                    </c:otherwise>
                </c:choose>
            </td>

            <td>
                <a href="<c:url value='/employees/${e.code}'/>">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>

<p>Tổng lương phòng Kỹ thuật:
    <fmt:formatNumber value="${techTotal}" type="number"/>
</p>

<%@ include file="common/footer.jsp" %>ƒÏ