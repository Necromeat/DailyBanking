<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">

    <div id="basicPanel">
            <h3>Account Owner: ${account.owner.firstName} ${account.owner.lastName}</h3>
            <a href="Controller?custid=${account.owner.customerId}&command=viewCustomer">View Customer</a>
    </div>

    <div id="basicPanel">
        <table>
            <tr>
                <th>Account ID</th>
                <th>Account Type</th>
                <th>Account Balance</th>
            </tr>
            <tr>
                <td>${account.accountId}</td>
                <td>${account.accountType}</td>
                <td>${account.balance}</td>
            </tr>
        </table>
    </div>

    <div id="basicPanel">
        <a href="Controller?accountid=${account.accountId}&command=accountHistory">View Transaction's</a>
        
        <a href="Controller?accountid=${account.accountId}&command=createTransfer">Make Transfer</a>
    </div>

</div>   

        <%@include file="../WEB-INF/jspf/footer.jspf" %>
