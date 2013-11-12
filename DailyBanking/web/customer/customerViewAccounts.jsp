<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">

    <p id="username">${username} is currently logged in</p>

    <div id="basicPanel">
        <c:forEach var="custAccount" items="${custAccounts}">
            <table>
                <tr>
                    <th>Account ID</th>
                    <th>Account Type</th>
                    <th>Account Balance</th>
                </tr>
                <tr>
                    <td>${custAccount.accountId}</td>
                    <td>${custAccount.accountType}</td>
                    <td>${custAccount.balance}</td>
                    <td><a href="Controller?accountid=${custAccount.accountId}&command=customerAccountHistory&username=${username}&userid=${userid}">Account history</a></td>
                </tr>
            </table>
        </c:forEach>
    </div>

    <div id="basicPanel">
        <%--<a href="Controller?accountid=${account.accountId}&username=${username}&userid=${userid}&command=customerAccountHistory">View Transaction's</a>--%>

        <a href="Controller?accountid=${account.accountId}&username=${username}&userid=${userid}&command=customerCreateTransfer">Make Transfer</a>
    </div>

</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>