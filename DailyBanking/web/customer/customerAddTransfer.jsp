<%-- 
    Document   : customerAddTransfer
    Created on : Nov 12, 2013, 11:50:40 AM
    Author     : krismaini
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<div id="main">
    <p id="username">${username} is currently logged in</p>
        
    <div id="basicPanel">
    
    <h1>Transfer between accounts</h1><br><br>
    
    <form>
        <label>To account:  </label>
        <input type="text" name="toAccount" id="toAccount"><br>
        <label>Amount:    </label>
        <input type="text" name="amount" id="amount"><br>
        <label>Message:  </label>
        <input type="text" name="message" id="message"><br>
        <input type="submit" value="Submit">
        <input type="hidden" name="command" value="addTransfer">
        <input type="hidden" name="accountid" value="${account.accountId}">
        
    </form>
    </div>
    
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>

