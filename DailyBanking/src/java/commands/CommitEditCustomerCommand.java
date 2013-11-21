
package commands;

import DTO.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import shared.Customer;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class CommitEditCustomerCommand extends TargetCommand {

    public CommitEditCustomerCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

   

    @Override
    public String execute(HttpServletRequest request) {
        String idAsString = request.getParameter("custemail");
        CustomerDTO cust = servlets.Factory.getInstance().getBankController().getCustomerByEmail(idAsString);
        request.setAttribute("customer", cust);
        
        String custFName = request.getParameter("newFirstName");
        String custLName = request.getParameter("newLastName");
        String custEmail = request.getParameter("newEmail");
        CustomerDTO temp = new CustomerDTO(0,custFName, custLName, custEmail);
        
        servlets.Factory.getInstance().getBankController().saveEditedCustomer(cust, temp);
        
        cust = servlets.Factory.getInstance().getBankController().getCustomerByEmail(custEmail);
        request.setAttribute("customer", cust);
        
        return super.execute(request); 
    }
    
}
