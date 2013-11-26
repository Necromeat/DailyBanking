/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import DTO.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.Factory;

/**
 *
 * @author Aaron
 */
@WebServlet(name = "ViewAllAccountsServlet", urlPatterns = {"/ViewAllAccountsServlet"})
public class ViewAllAccountsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Collection<AccountDTO> accounts = Factory.getInstance().getBankController().getAccounts();
            
            out.println("<tr><th>Account ID</th><th>Account Type</th><th>Account Owner</th></tr>");
            
            for(AccountDTO a : accounts){
                out.println("<td>"+a.getAccountId()+"</td>");
                out.println("<td>"+a.getAccountType()+"</td>");
                out.println("<td>"+"-"+a.getOwner().getFirstName()+" "+a.getOwner().getLastName()+"</td>");
                out.println("<td><a href=\"Controller?accountid="+a.getAccountId()+"&command=viewAccount\">"+"Account details"+"</a></td>");
            }
              out.println("</tr>\n</c:forEach>\n</table>");  
           
        } finally {
            out.close();
        }
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
