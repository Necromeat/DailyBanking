
package commands;

import DTO.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class ViewCustomerCommand extends TargetCommand {

    public ViewCustomerCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        
        String idAsstr= request.getParameter("custemail");
        CustomerDTO cust = Factory.getInstance().getBankController().getCustomerByEmail(idAsstr);
        request.setAttribute("customer", cust);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
