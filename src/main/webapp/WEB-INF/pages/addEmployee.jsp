<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:sharedTag>
    <form class="container form-group" action="addEmployee" method="post">
        <label for="lastName">Фамилия сотрудника</label>
        <input type="text" class="form-control" id="lastName" name="lastName">
        <br/>
        <label for="firstName">Имя сотрудника</label>
        <input type="text" class="form-control" id="firstName" name="firstName">
        <br/>
        <label for="designation">Должность</label>
        <input type="text" class="form-control" id="designation" name="designation">
        <br/>
        <label for="phoneNumber">Номер телефона</label>
        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
        <br/>
        <input type="submit" class="btn btn-primary" value="Добавить">
    </form>
</tag:sharedTag>
