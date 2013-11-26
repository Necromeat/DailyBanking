package commands;

import DTO.CustomerDTO;
import DTO.UserDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import shared.Customer;

/**
 *
 * @author Aaron, Kris, Lars, Timea,
 * @08/11/2013
 */
public class AddCustomerCommand extends TargetCommand {

    public AddCustomerCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (!firstName.equals("")) {
            UserDTO user = new UserDTO(email, 0, password);
            servlets.Factory.getInstance().getBankController().addUser(user.getPw(), user.getEmail());
            CustomerDTO cust = new CustomerDTO(0, firstName, lastName, email);
            servlets.Factory.getInstance().getBankController().addCustomer(cust);
            return super.execute(request);
        } else {
            return super.execute(request); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
