<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">

<table>
    <tr>
        <th>Account ID</th>
        <th>Account Type</th>
        <th>Account Owner</th>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <td>${account.accountId}</td>
            <td>${account.accountType}</td>
            <td>${account.owner.firstName} ${account.owner.lastName}</td>
            <td><a href="Controller?accountid=${account.accountId}&command=viewAccount">Account details</a></td>
        </tr>
    </c:forEach>
</table>

</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
