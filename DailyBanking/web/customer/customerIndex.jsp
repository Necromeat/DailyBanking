<%-- 
    Document   : customerIndex
    Created on : 08-Nov-2013, 10:28:39
    Author     : Aaron, Kris, Lars, Timea
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    <p id="username">${username} is currently logged in</p>
    <a href="Controller?userid=${userid}&username=${username}&command=customerViewDetails">Your Bank Profile</a>
        
    </div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
