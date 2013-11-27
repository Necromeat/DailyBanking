<%@include file="../WEB-INF/jspf/header.jspf" %>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
    $(document).ready(function() {
        $("#btn").click(function() {
            $.ajax({
                url: "ViewAllAccountsServlet",
                cache: false,
                dataType: "text",
                success: dateReady
            });
        });
    });

    function dateReady(data) {
        $("#accountview").html(data);
    }
</script>

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
                <td>${account.owner.email}</td>
                <td><a href="Controller?accountid=${account.accountId}&command=viewAccount">Account details</a></td>
            </tr>
        </c:forEach>
    </table>

    <button id="btn">Get Accounts Through Ajax</button>

            <table id ="accountview">

            </table>
            

    </div>

    <%@include file="../WEB-INF/jspf/footer.jspf" %>
