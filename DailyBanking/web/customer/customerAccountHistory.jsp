<%-- 
    Document   : customerAccountHistory
    Created on : Nov 12, 2013, 11:50:26 AM
    Author     : krismaini
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    <p id="username">${username} is currently logged in</p>

    <div id="basicPanel">
        <h3>Account History for: </h3>
        <h3>${account.accountType}&nbsp; - Account number: &nbsp;${account.accountId}</h3>
        <%--<h3>Account Owner:&nbsp${account.owner.firstName}&nbsp${account.owner.lastName}</h3>
        <a href="Controller?accountid=${account.accountId}&command=viewAccount">Account Details</a>--%> 
    </div>

    <div id="basicPanel">
        <table>
            <caption>${account.accountType}&nbsp;-&nbsp;${account.accountId}</caption>
            <thead>
                <tr><th>Date</th><th>Description</th><th>Amount</th><th>Balance</th></tr>
            </thead>


            <c:forEach var="item" items="${account.transactions}">
                <tr>
                    <td><f:formatDate type="date" value="${today}"/></td>
                    <td>${item.info}</td>
                    <td><div itemid="L1"><f:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${item.amount}"/></div></td>
                    <td><div itemid="L1"><f:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.balance}"/></div></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>

