package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Aaron, Kris, Lars, Timea,
 * @08/11/2013
 */
public class TargetCommand implements Command {

    private final String target;
    private final String title;
    private final SecurityRole role;
    private String username =  null;

    public TargetCommand(String target, String title, SecurityRole role) {
        this.target = target;
        this.title = title;
        this.role = role;
    }

    @Override
    public String execute(HttpServletRequest request) {
        username = request.getParameter("username");
        request.setAttribute("username", username);
        request.setAttribute("title", title);
        request.setAttribute("navigation", setNav(title));
        return target;
    }

    public SecurityRole getRole() {
        return role;
    }

    public String setNav(String tiltle) {
        String nav = null;

        switch (title) {
            case "Main Page":
                nav = "<a id=\"activetab\">Main Page</a>";
                break;
            case "Login Page":
                nav = "<a id=\"activetab\">Login</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>";
                break;
            case "Add Customer":
                nav = "<a href=\"Controller?command=bankTellerIndex&username="+username+"\">Menu</a>\n <a href=\"Controller?command=listCustomers\">Customer List</a>\n <a id=\"activetab\">Add Customer</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>";
                break;
            case "BankTeller Index":
                nav = "<a id=\"activetab\">Menu</a>\n <a href=\"Controller?lastName=&firstName=&email=&command=addCustomer\">Add Customer</a>\n <a href=\"Controller?command=listCustomers\">Customers List</a>\n <a href=\"Controller?command=listAccounts\">Accounts List</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>";
                break;
        }
        return nav;
    }
}
