
package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public interface Command {

    String execute(HttpServletRequest request);
    
}
