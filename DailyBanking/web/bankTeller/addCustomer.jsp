<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">

<div id="addcustpanel">
    <form action='Controller'>
        <label>First Name:</label><br>
        <input type="text" name="firstName" id="firstName"><br>
        <label>Last Name:</label><br>
        <input type="text" name="lastName" id="lastName"><br>
        <label>Email:</label><br>
        <input type="text" name="email" id="email"><br>
        <button name="submit">Submit</button>
        <input type="hidden" name="command" value="addCustomer">
    </form>
</div>
    
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
