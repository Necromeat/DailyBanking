/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author krismaini
 */
@WebServlet(name = "CheckEmailServlet", urlPatterns = {"/CheckEmailServlet"})
public class CheckEmailCommand extends HttpServlet{
        
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
        
        String idAsstr= request.getParameter("email");
        boolean result = Factory.getInstance().getBankController().checkUserEmail(idAsstr);
        System.out.println("check email result = "+result);
        PrintWriter out = response.getWriter();
        out.print(result);
        
    }
}
