
package commands;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class CustomerIndexCommand extends TargetCommand {

    public CustomerIndexCommand(String target, String title,SecurityRole role) {
        super(target, title, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
       String idAsstr= request.getParameter("custemail");
       CustomerDTO customer = Factory.getInstance().getBankController().getCustomerByEmail(idAsstr);
        request.setAttribute("customer", customer);
        
        
        return super.execute(request); 
    }

    
    
}
