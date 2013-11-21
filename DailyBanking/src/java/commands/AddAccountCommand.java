/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import DTO.CustomerDTO;

/**
 *
 * @author krismaini
 */
public class AddAccountCommand extends TargetCommand{

    public AddAccountCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    
    
    @Override
    public String execute(HttpServletRequest request){
        String idAsString = request.getParameter("custemail");
        CustomerDTO cust = servlets.Factory.getInstance().getBankController().getCustomerByEmail(idAsString);
        request.setAttribute("customer", cust);
        return super.execute(request);
    }
}
