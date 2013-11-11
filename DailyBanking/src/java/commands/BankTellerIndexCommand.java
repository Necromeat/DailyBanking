
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class BankTellerIndexCommand extends TargetCommand {

    public BankTellerIndexCommand(String target, String title,SecurityRole role) {
        super(target, title, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        return super.execute(request);
    }
    
}
