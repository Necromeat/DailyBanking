
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class TargetCommand implements Command {
    private final String target;
    private final String title;
    private final SecurityRole role;
    private String nav;

    public TargetCommand(String target, String title, SecurityRole role) {
        this.target = target;
        this.title = title;
        this.role = role;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("title", title);
        request.setAttribute("navigation", setNav());
        return target;
    }
    
    public SecurityRole getRole(){
        return role;
    }

    public String setNav(){
        if(title.equals("Main Page")){
        return "<a id=\"activetab\">Main Page</a>";
        }
         if(title.equals("Login Page")){
        return "<a id=\"activetab\">Login</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>";
        }
         return null;
    }
    
    
    
    

}
