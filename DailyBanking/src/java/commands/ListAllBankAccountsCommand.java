
package commands;

import DTO.AccountDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Account;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class ListAllBankAccountsCommand extends TargetCommand {

    public ListAllBankAccountsCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        Collection<AccountDTO> accounts = Factory.getInstance().getBankController().getAccounts();
        request.setAttribute("accounts", accounts);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
