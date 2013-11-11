<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">
    
    <p id="username">${username} is currently logged in</p>
    
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
        <a href="Controller?accountid=${account.accountId}&command=customerAccountHistory">View Transaction's</a>
        
        <a href="Controller?accountid=${account.accountId}&command=customerCreateTransfer">Make Transfer</a>
    </div>
    
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>