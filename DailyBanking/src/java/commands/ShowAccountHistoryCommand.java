
package commands;


import DTO.AccountDTO;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Account;

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
        String idAsstr= request.getParameter("accountid");
        long id = Long.parseLong(idAsstr);
        AccountDTO account = Factory.getInstance().getBankController().getAccount(id);
        request.setAttribute("account", account);
        Date date = new Date();
        request.setAttribute("today", date);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
