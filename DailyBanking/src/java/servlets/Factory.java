package servlets;

import commands.*;
import contract.BankDataInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import utils.UAgentInfo;

/**
 *
 * @author Aaron, Kris, Lars, Timea,
 * @08/11/2013
 */
public class Factory {
    BankDataInterface bankDataBean = lookupBusinessDataBeanRemote();
//    BankDataInterface bankDataBean = lookupBankDataBeanRemote();
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
        commands.put("customerViewDetails", new ViewCustomerCommand("/customer/customerViewDetails.jsp","Your Details",SecurityRole.Customers));
        commands.put("customerViewAccounts", new ViewCustomerAccountsCommand("/customer/customerViewAccounts.jsp","Your Accounts",SecurityRole.Customers));
        commands.put("customerAccountHistory", new ShowAccountHistoryCommand("/customer/customerAccountHistory.jsp","Your Account History",SecurityRole.Customers));
        commands.put("customerAddTransfer", new CreateTransferCommand("/customer/customerAddTransfer.jsp","Customer Transaction",SecurityRole.Customers));
        commands.put("customerCommitTransfer", new CommitTransferCommand("/customer/customerAccountHistory.jsp","Your Account",SecurityRole.Customers));
        
        //bankTeller
        commands.put("bankTellerIndex", new BankTellerIndexCommand("/bankTeller/bankTellerIndex.jsp", "BankTeller Index",SecurityRole.BankTellers));
        commands.put("addCustomer",new AddCustomerCommand("/bankTeller/addCustomer.jsp","Add Customer",SecurityRole.BankTellers));
        commands.put("listCustomers", new ListAllBankCustomersCommand("/bankTeller/listCustomers.jsp","Customers List",SecurityRole.BankTellers));        
        commands.put("listAccounts", new ListAllBankAccountsCommand("/bankTeller/listAccounts.jsp","Accounts List",SecurityRole.BankTellers));           
        commands.put("editCustomer", new EditCustomerCommand("/bankTeller/editCustomer.jsp", "Edit Customer",SecurityRole.BankTellers));     
        commands.put("comitEditCustomer", new CommitEditCustomerCommand("/bankTeller/editCustomer.jsp", "Edit Customer",SecurityRole.BankTellers));
        commands.put("addAccount", new AddAccountCommand("/bankTeller/addAccount.jsp","Create Account",SecurityRole.BankTellers));
        commands.put("viewCustomer", new ViewCustomerCommand("/bankTeller/viewCustomer.jsp","View Customer",SecurityRole.BankTellers));                
        commands.put("viewAccount", new ViewAccountCommand("/bankTeller/viewAccount.jsp","Account View",SecurityRole.BankTellers));
        commands.put("accountHistory", new ShowAccountHistoryCommand("/bankTeller/accountHistory.jsp","Account History",SecurityRole.BankTellers));
        commands.put("commitAddAccount", new CommitAddAccountCommand("/bankTeller/viewCustomer.jsp","View Customer",SecurityRole.BankTellers));
        commands.put("createTransfer", new CreateTransferCommand("/bankTeller/addTransfer.jsp","Create Transfer",SecurityRole.BankTellers));
        commands.put("commitTransfer", new CommitTransferCommand("/bankTeller/viewAccount.jsp","Account View",SecurityRole.BankTellers));
        
        //all mobile
        commands.put("mobileMain", new TargetCommand("/all/mobile/mobileMain.jsp", "Main Page",SecurityRole.All));
        commands.put("mobileShowLogin", new TargetCommand("/login/mobile/mobileLogin.jsp","Login Page",SecurityRole.All));
        Map<SecurityRole,String> rolePages2 = new HashMap<>();
        rolePages2.put(SecurityRole.Customers, "/customer/mobile/mobileCustomerIndex.jsp");
        commands.put("mobileLogin", new LoginCommand(rolePages2,"/login/mobile/mobileLogin.jsp"));
        commands.put("mobileLogout", new LogoutCommand("/all/mobile/mobileMain.jsp","Main Page", SecurityRole.All));
        commands.put("mobileViewDetails", new ViewCustomerCommand("/customer/mobile/mobileViewDetails.jsp","Your Details",SecurityRole.Customers));
        commands.put("mobileViewAccounts", new ViewCustomerAccountsCommand("/customer/mobile/mobileViewAccounts.jsp","Your Accounts",SecurityRole.Customers));
        commands.put("mobileAccountHistory", new ShowAccountHistoryCommand("/customer/mobile/mobileAccountHistory.jsp","Your Account History",SecurityRole.Customers));
    }

    public static Factory getInstance() {
        return instance;
    }

    public  BankDataInterface getBankController() {
        return  bankDataBean; 
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

//    private BankDataInterface lookupBankDataBeanRemote() {
//        try {
//            Context c = new InitialContext();
//            return (BankDataInterface) c.lookup("java:global/DailyBankingBusinessDataBase/BankDataBean!contract.BankDataInterface");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }

    private BankDataInterface lookupBusinessDataBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BankDataInterface) c.lookup("java:global/DailyBankingBusinessDataBase/BusinessDataBean!contract.BankDataInterface");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
   
}
