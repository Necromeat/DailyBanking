<%@include file="../WEB-INF/jspf/header.jspf" %>


<div id="main">

    <table>
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Customer Email</th>
            <th></th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.firstName} ${customer.lastName}</td>
                <td>${customer.email}</td>
                <td><a href="Controller?custid=${customer.customerId}&command=viewCustomer">Customer Profile</a></td>
            </tr>
        </c:forEach>
    </table> 

</div>


<%@include file="../WEB-INF/jspf/footer.jspf" %>
