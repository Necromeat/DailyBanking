
package commands;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import shared.Account;
import shared.Customer;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class CommitAddAccountCommand extends TargetCommand{

    public CommitAddAccountCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    
    @Override
    public String execute(HttpServletRequest request){
        String custID = request.getParameter("custid");
        if(!custID.isEmpty()){
            Long id = Long.parseLong(custID);
            CustomerDTO cust = servlets.Factory.getInstance().getBankController().getCustomer(id);
            String accountType = request.getParameter("account");
            AccountDTO newAccount = new AccountDTO(null,accountType, 0.0);
            servlets.Factory.getInstance().getBankController().addAccount(cust.getCustomerId(),newAccount);
            request.setAttribute("customer", cust);
        }
        return super.execute(request);
    }
}
