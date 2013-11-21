package commands;


import DTO.AccountDTO;
import DTO.CustomerDTO;
import commands.TargetCommand;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Account;
import shared.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krismaini
 */
public class ViewCustomerAccountsCommand extends TargetCommand{

    public ViewCustomerAccountsCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }
    @Override
    public String execute(HttpServletRequest request) {
        String idAsstr= request.getParameter("custemail");
        CustomerDTO cust = Factory.getInstance().getBankController().getCustomerByEmail(idAsstr);
        request.setAttribute("customer", cust);
        Collection<AccountDTO> custAccounts = cust.getAccounts();
        request.setAttribute("custAccounts", custAccounts);
        return super.execute(request);
    }
}
