<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">

    <div id="basicPanel">
        <h1>Customer Profile:</h1><br>
        <h4>Customer Name: ${customer.firstName} ${customer.lastName}</h4>
        <h4>Customer Number: ${customer.customerId}</h4>
        <h4>Customer Email: ${customer.email}</h4><br>
        <a href="Controller?custid=${customer.customerId}&command=editCustomer">Edit Customer</a>
        <a href="Controller?custid=${customer.customerId}&command=addAccount">Add New Account</a>
    </div>

    <div id="basicPanel">
        <h1>Customer accounts:</h1><br>
        <table>
            <tr>
                <th>Account ID</th>
                <th>Account Type</th>
            </tr>
            <c:forEach var="item" items="${customer.accounts}">
                <tr><td>${item.accountId}</td>
                    <td>${item.accountType}</td>
                    <td><a href="Controller?accountid=${item.accountId}&command=viewAccount">Account Details</a></td>                            
                </tr>
            </c:forEach>
        </table>
    </div>
    
</div>



<%@include file="../WEB-INF/jspf/footer.jspf" %>
