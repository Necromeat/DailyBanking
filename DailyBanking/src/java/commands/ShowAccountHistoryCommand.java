
package commands;


import DTO.AccountDTO;
import DTO.CustomerDTO;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class ShowAccountHistoryCommand extends TargetCommand{

    public ShowAccountHistoryCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        String idAsstr= request.getParameter("custemail");
        CustomerDTO cust = Factory.getInstance().getBankController().getCustomerByEmail(idAsstr);
        request.setAttribute("customer", cust);
        
        String accountid= request.getParameter("accountid");
        long id = Long.parseLong(accountid);
        
        Collection<AccountDTO> temp = cust.getAccounts();
        
        for (AccountDTO f:temp) {
            if(f.getAccountId() == id ){
                
                 request.setAttribute("account", f);
            }
        }
        
        
        
        Date date = new Date();
        request.setAttribute("today", date);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
