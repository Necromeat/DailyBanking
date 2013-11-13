<%@include file="../WEB-INF/jspf/header.jspf" %>

<script type="text/javascript">
    $(document).ready(function() {
        //var selectedAccount;
        $("#account-select").on('change', function(event) {
             var selectedAccount = $("#account-select").find('option:selected').text();
            //alert("account: " + selection);                                                            $(this).text()
            $('#transfer-container').html('<a href="Controller?command=customerAddTransfer&accountid=' + selectedAccount + '&username=${username}&userid=${userid}">Start new transfer</a>');
        });
    });
</script>

<div id="main">

    <p id="username">${username} is currently logged in</p>

    <div id="basicPanel">
        <h3>Your accounts</h3>
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
        <h3>Choose an account to start a transaction</h3>
        <form id="accounts">
            <select id='account-select'>
                <option value="">Select</option>
                <c:forEach var="custAccount" items="${custAccounts}">
                    <option value=${custAccount}>${custAccount.accountId}</option>
                </c:forEach>
            </select>
        </form>
        <div id="transfer-container">

        </div>
        <%--<a href="Controller?command=customerAddTransfer&accountid=${selectedAccount}&username=${username}&userid=${userid}">Make Transfer</a>--%>
    </div>


</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>