<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="employees" type="java.util.List" scope="request"/>
<tag:sharedTag>
<form class="container form-group" action="employee">
    <label for="lastName">Фамилия сотрудника</label>
    <input class="form-control" type="text" id="lastName" name="lastName">
    <br/>
    <button class="btn btn-primary" type="submit">Поиск</button>
</form>
    <c:if test="${employees.size() > 0}">
<table class="container table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Должность</td>
        <td>Номер телефона</td>
    </tr>
    </thead>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.designation}</td>
            <td>${employee.phoneNumber}</td>
        </tr>

    </c:forEach>
</table>
    </c:if>
    <c:if test="${employees.size() == 0}">
        <p>Ничего не найдено</p>
    </c:if>
    <br/>
    <div class="container">
    <a href="${pageContext.request.contextPath}/addEmployee">
        <button class="btn btn-primary">Добавить сотрудника</button>
    </a>
    </div>>
</tag:sharedTag>
