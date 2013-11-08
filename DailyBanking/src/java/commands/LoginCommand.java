
package commands;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class LoginCommand implements Command {

    private final Map<SecurityRole, String> roleToTarget;
    private final String loginFailed;

    public LoginCommand(Map<SecurityRole, String> targetRoles, String logInFailedPage) {
        
        this.roleToTarget = targetRoles;
        this.loginFailed = logInFailedPage;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        
        String nextPage = loginFailed;
        try {
            //This performs a programatic login
            request.login(username, password);
            //Set next page depending on the users role
            for (SecurityRole role : roleToTarget.keySet()) {
                if (request.isUserInRole(role.toString())) {
                    nextPage = roleToTarget.get(role);
                    break;
                }
            }
        } catch (ServletException ex) {
            request.setAttribute("loginerror", "You failed to login");
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextPage;
    }
    
}
