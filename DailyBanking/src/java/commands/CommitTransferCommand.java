package commands;

import DTO.AccountDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Account;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class CommitTransferCommand extends TargetCommand {

    public CommitTransferCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {   
        String idAsstr= request.getParameter("accountid");
        long accountid = Long.parseLong(idAsstr);
        AccountDTO account = Factory.getInstance().getBankController().getAccount(accountid);
        request.setAttribute("account", account);
        
        String toAccount = request.getParameter("toAccount");
        String amount = request.getParameter("amount");
        String message = request.getParameter("message");

        if (account != null && toAccount != null && amount != null && message != null) {
            
            System.out.println("Transfer variables successfully input.");
            
            long toId = Long.parseLong(toAccount);
            double transfer = Double.parseDouble(amount);

            if (!request.getParameter("amount").isEmpty()) {
            Factory.getInstance().getBankController().newTransfer(accountid,accountid, toId, transfer, message);
            }
        }
        
         
        
        return super.execute(request);
    }
}
