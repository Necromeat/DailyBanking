<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">
    
    <div id="basicPanel">
        <h4>Customer Name: ${customer.firstName} ${customer.lastName}</h4>
        <h4>Customer Number: ${customer.customerId}</h4>
        <h4>Customer Email: ${customer.email}</h4><br>
    </div>
    <div id="basicPanel">   
        <h1>Customer Profile:</h1><br><br>
        <form action='Controller'>
            <label>First Name:</label><br>
            <input type="text" name="newFirstName" id="newFirstName" value="${customer.firstName}"><br>
            <label>Last Name:</label><br>
            <input type="text" name="newLastName" id="newLastName" value="${customer.lastName}"><br>
            <label>Email:</label><br>
            <input type="text" name="newEmail" id="newEmail" value="${customer.email}"><br>
            <input type="submit" name="submit">
            <input type="hidden" name="custid" value="${customer.customerId}">
            <input type="hidden" name="command" value="comitEditCustomer">
        </form>
    </div>
            
</div> 

            <%@include file="../WEB-INF/jspf/footer.jspf" %>
