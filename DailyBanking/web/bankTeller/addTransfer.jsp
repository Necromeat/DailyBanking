<%@include file="../WEB-INF/jspf/header.jspf" %>

<div id='main'>
    
    <div id="basicPanel">
        <h3>Account Owner:&nbsp${account.owner.firstName}&nbsp${account.owner.lastName}</h3>
        <h3>Account Balance:&nbsp${account.balance}</h3>
        <a href="Controller?accountid=${account.accountId}&command=viewAccount">Account Details</a> 
    </div>
    
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
        <input type="hidden" name="command" value="commitTransfer">
        <input type="hidden" name="accountid" value="${account.accountId}">
        
    </form>
    </div>
     
</div>
            
<%@include file="../WEB-INF/jspf/footer.jspf" %>
