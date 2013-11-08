package commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class LogoutCommand extends TargetCommand{

    public LogoutCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

  @Override
  public String execute(HttpServletRequest request) {
    try {
      request.logout();
    } catch (ServletException ex) {
      Logger.getLogger(LogoutCommand.class.getName()).log(Level.SEVERE, null, ex);
    }
    return super.execute(request); 
  }
}
