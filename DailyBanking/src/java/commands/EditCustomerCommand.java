
package commands;

import DTO.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class EditCustomerCommand extends TargetCommand {

    public EditCustomerCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        String idAsString = request.getParameter("custid");
        long id = Long.parseLong(idAsString);
        CustomerDTO cust = servlets.Factory.getInstance().getBankController().getCustomer(id);
        request.setAttribute("customer", cust);
        
        return super.execute(request);
    }
}
        