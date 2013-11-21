<%-- 
    Document   : customerIndex
    Created on : 08-Nov-2013, 10:28:39
    Author     : Aaron, Kris, Lars, Timea
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    <p id="username">${customer.firstName} ${customer.lastName} is currently logged in</p>
    <a href="Controller?custemail=${customer.email}&username=${username}&command=customerViewDetails">Your Bank Profile</a>
        
    <div id='basicPanel'>
        <h3>News Section</h3>
    </div>
    <div id='basicPanel'>
        <h3>Information</h3>
    </div>
</div>
    

<%@include file="../WEB-INF/jspf/footer.jspf" %>
