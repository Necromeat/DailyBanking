<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id="main">
    
    <div id="basicPanel">
        <h4>Customer Name: ${customer.firstName} ${customer.lastName}</h4>
        <h4>Customer Number: ${customer.customerId}</h4>
        <h4>Customer Email: ${customer.email}</h4><br>
        <a href="Controller?custid=${customer.customerId}&command=viewCustomer">Customer Profile</a>
    </div>
    
    <div id="basicPanel">
        <form method="get" action="Controller?command=addAccount" enctype=text/plain>
            
            <input type="radio" name="account" value="Checking Account">Checking Account<br>
            <input type="radio" name="account" value="Money Market Account">Money Market Account<br>
            <input type="radio" name="account" value="Time Deposit Account">Time Deposit Account<br><br>
            
            <label for="custid">Check box to confirm</label>
            <input type="checkbox" name="custid" value=${customer.customerId}><br>
            <input type="submit" value="Submit">
            <input type="hidden" name="command" value="commitAddAccount">
        </form>
        
        
    </div>
        
</div>
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
