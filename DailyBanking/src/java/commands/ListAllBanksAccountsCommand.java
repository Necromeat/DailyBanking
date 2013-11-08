
package commands;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Account;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class ListAllBanksAccountsCommand extends TargetCommand {

    public ListAllBanksAccountsCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        Collection<Account> accounts = Factory.getBankController().getAccounts();
        request.setAttribute("accounts", accounts);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
