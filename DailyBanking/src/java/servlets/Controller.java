package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import commands.Command;
import commands.LogoutCommand;
import commands.ShowLoginCommand;

/**
 *
 * @author Aaron, Kris, Lars, Timea,
 * @08/11/2013
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private int PORT_NON_SSL;
    private int PORT_SSL;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String commandString = request.getParameter("command");
        request.setAttribute("title", "Main Page");

        Command command = Factory.getInstance().getCommand(commandString, request);
        String path = command.execute(request);
        
         if (command instanceof ShowLoginCommand && !request.isSecure() ) {
      String SSL = "https://" + request.getServerName() + ":" + PORT_SSL + request.getRequestURI()+"?command=showLogin";
      response.sendRedirect(SSL);
    } 
    else if(command instanceof LogoutCommand) {
      String nonSSL = "http://" + request.getServerName() + ":" + PORT_NON_SSL + request.getRequestURI();
      response.sendRedirect(nonSSL);
    }
    else {
      request.getRequestDispatcher(path).forward(request, response);
    }
  }

  @Override
  public void init() throws ServletException {
    PORT_NON_SSL = Integer.parseInt(getServletContext().getInitParameter("portNonSSL"));
    PORT_SSL = Integer.parseInt(getServletContext().getInitParameter("portSSL"));

//        RequestDispatcher requestDispatcher =
//                request.getRequestDispatcher(path);
//        requestDispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
