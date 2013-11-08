<%-- 
    Document   : main
    Created on : 08-Nov-2013, 10:05:48
    Author     : Aaron, Kris, Lars, Timea
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    
<div id="loginpanel">
    <p><a href="Controller?command=showLogin">Login Here</a></p>

</div>
    
<div id="newspanel">
<h1>News:</h1><br>
<h2>The web site is currently under maintenance so things may not work as desired. Thank you for your patients</h2>     
</div>
    <a href="Controller?command=customerIndex">Customer Index</a>
    <a href="Controller?command=bankTellerIndex">BankTeller Index</a>
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
