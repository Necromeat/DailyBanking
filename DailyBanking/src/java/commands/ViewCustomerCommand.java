
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Customer;

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
        
        String idAsstr= request.getParameter("custid");
        long id = Long.parseLong(idAsstr);
        Customer cust = Factory.getBankController().getCustomer(id);
        request.setAttribute("customer", cust);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
