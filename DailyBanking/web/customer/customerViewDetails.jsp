<%-- 
    Document   : listCustAccounts
    Created on : Nov 11, 2013, 2:18:18 PM
    Author     : krismaini
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    <p id="username">${username} is currently logged in</p>
    
    <div id="basicPanel">
        <h1>Your profile:</h1><br>
        <h4>Name: ${customer.firstName} ${customer.lastName}</h4>
        <h4>Number: ${customer.customerId}</h4>
        <h4>Email: ${customer.email}</h4><br>
    </div>

</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
