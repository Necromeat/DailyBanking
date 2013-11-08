

package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Account;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class CreateTransferCommand extends TargetCommand{

    public CreateTransferCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        String idAsstr= request.getParameter("accountid");
        long id = Long.parseLong(idAsstr);
        Account account = Factory.getBankController().getAccount(id);
        request.setAttribute("account", account);
        return super.execute(request);
    }
    
}
