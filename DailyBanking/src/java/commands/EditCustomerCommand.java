
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import shared.Customer;

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
        Customer cust = servlets.Factory.getBankController().getCustomer(id);
        request.setAttribute("customer", cust);
        
        return super.execute(request);
    }
}
        