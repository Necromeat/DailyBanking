
package commands;

import DTO.UserDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class BankTellerIndexCommand extends TargetCommand {

    public BankTellerIndexCommand(String target, String title,SecurityRole role) {
        super(target, title, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
         String idAsstr= request.getParameter("custemail");
        UserDTO user = Factory.getInstance().getBankController().getUser(idAsstr);
        request.setAttribute("user", user);   
        
        
        return super.execute(request);
    }
    
}
