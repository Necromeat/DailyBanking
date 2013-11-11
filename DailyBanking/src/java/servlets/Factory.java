package servlets;

import commands.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import shared.BankDataController;
import utils.UAgentInfo;

/**
 *
 * @author Aaron, Kris, Lars, Timea,
 * @08/11/2013
 */
public class Factory {

    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();

    private Factory() {
        //all
        commands.put("main", new TargetCommand("/all/main.jsp", "Main Page",SecurityRole.All));

        //login
        commands.put("showLogin", new ShowLoginCommand("/login/login.jsp","Login Page",SecurityRole.All));
        
        Map<SecurityRole,String> rolePages = new HashMap<>();
        rolePages.put(SecurityRole.Customers, "/customer/customerIndex.jsp");
        rolePages.put(SecurityRole.BankTellers, "/bankTeller/bankTellerIndex.jsp");
        
        commands.put("login", new LoginCommand(rolePages,"/login/login.jsp"));
        
        //logout
        commands.put("logout", new LogoutCommand("/all/main.jsp","Main Page", SecurityRole.All));
        
        //customer
        commands.put("customerIndex", new CustomerIndexCommand("/customer/customerIndex.jsp", "Customer Index",SecurityRole.Customers));

        //bankTeller
        commands.put("bankTellerIndex", new BankTellerIndexCommand("/bankTeller/bankTellerIndex.jsp", "BankTeller Index",SecurityRole.BankTellers));
        commands.put("addCustomer",new AddCustomerCommand("/bankTeller/addCustomer.jsp","Add Customer",SecurityRole.BankTellers));
        commands.put("listCustomers", new ListAllBankCustomersCommand("/allowed/BankTeller/listCustomers.jsp","Customers List",SecurityRole.BankTellers));        
        commands.put("listAccounts", new ListAllBankAccountsCommand("/allowed/BankTeller/listAccounts.jsp","Accounts List",SecurityRole.BankTellers));           
        commands.put("editCustomer", new EditCustomerCommand("/allowed/BankTeller/editCustomer.jsp", "Edit Customer",SecurityRole.BankTellers));     
        commands.put("comitEditCustomer", new CommitEditCustomerCommand("/allowed/BankTeller/editCustomer.jsp", "Edit Customer",SecurityRole.BankTellers));
        commands.put("createAccount", new AddAccountCommand("/allowed/BankTeller/addAccount.jsp","Create Account",SecurityRole.BankTellers));

        
        //all mobile
        commands.put("mobileMain", new TargetCommand("/all/mobile/mobileMain.jsp", "Main Page",SecurityRole.All));
        commands.put("mobileLogin", new TargetCommand("/login/mobile/mobileLogin.jsp", "loginMobile",SecurityRole.All));
    }

    public static Factory getInstance() {
        return instance;
    }

    public static BankDataController getBankController() {
        return DummyBankController.getInstance(); 
    }

    public Command getCommand(String cmdStr, HttpServletRequest request) {
        if (cmdStr == null) {
            cmdStr = isMobileDevice(request) ? "mobileMain" : "main";
        }
//        return commands.get(cmdStr);
     Command cmd = commands.get(cmdStr);

    //This is the most important place in terms of security
    //If you fail here your security is broken
    if (cmd instanceof TargetCommand) {
      SecurityRole requiredRole = ((TargetCommand) cmd).getRole();
      if (requiredRole != SecurityRole.All
              && !request.isUserInRole(requiredRole.toString())) {
        {
          throw new SecurityException("You don't have the necessary rights for this operation");
        }
      }
    }
    return cmd;
    }

    public boolean isMobileDevice(HttpServletRequest res) {
        String userAgent = res.getHeader("User-Agent");
        String httpAccept = res.getHeader("Accept");
        UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);
        return detector.detectMobileQuick();
    }
}
