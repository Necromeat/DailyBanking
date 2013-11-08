<%-- 
    Document   : login, Created: 08-Nov-2013, 11:47:00
    Author     : Aaron, Kris, Lars, Timea
--%>
<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    
<div id="loginpanel">
    <h1>Login:</h1><br>
<form action="Controller">
            <input type="hidden" name="command" value="login"/>
            <p>Username: <input type="text" name="username"/></p>
            <p>Password: <input type="password" name="password"/></p>
            <p><input type="submit" value="login"/></p>
            <p>${error}</p>
            <p>username = aaron : password = aaron</p>
</form>
</div>
    
<div id="newspanel">
<h1>News:</h1><br>
<h2>The web site is currently under maintenance so things may not work as desired. Thank you for your patients</h2>     
</div>
    
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
