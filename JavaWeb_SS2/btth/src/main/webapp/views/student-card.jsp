<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2026
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Thẻ sinh viên</title>
</head>
<body>

<h2>Tra cứu sinh viên</h2>

<form action="${pageContext.request.contextPath}/student-card" method="get">
    <input type="text" name="msv" placeholder="Nhập mã SV..."/>
    <button type="submit">Tra cứu</button>
</form>

<hr>

<!-- Lỗi -->
<c:if test="${not empty errorMessage}">
    <div style="color:red;">
        <c:out value="${errorMessage}"/>
    </div>
</c:if>

<!-- Hiển thị -->
<c:if test="${not empty student}">
    <div style="border:1px solid black; padding:10px; width:300px;">
        <h3>THẺ SINH VIÊN</h3>

        <p>Mã SV: <c:out value="${student.msv}"/></p>
        <p>Họ tên: <c:out value="${student.name}"/></p>
        <p>Khoa: <c:out value="${student.faculty}"/></p>
        <p>Năm học: <c:out value="${student.year}"/></p>
        <p>GPA: <c:out value="${student.gpa}"/></p>

        <p>Xếp loại:
            <c:choose>
                <c:when test="${student.gpa >= 8}">
                    <span style="color:green;">Giỏi</span>
                </c:when>
                <c:when test="${student.gpa >= 6.5}">
                    <span style="color:blue;">Khá</span>
                </c:when>
                <c:when test="${student.gpa >= 5}">
                    <span style="color:orange;">Trung bình</span>
                </c:when>
                <c:otherwise>
                    <span style="color:red; font-weight:bold;">
                        Cảnh báo học vụ
                    </span>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
</c:if>

<br>

<a href="${pageContext.request.contextPath}/student-card">
    Tra cứu sinh viên khác
</a>

</body>
</html>
