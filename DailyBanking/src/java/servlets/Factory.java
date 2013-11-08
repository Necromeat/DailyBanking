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
        commands.put("showLogin", new TargetCommand("/login/login.jsp","Login Page",SecurityRole.All));
        
        Map<SecurityRole,String> rolePages = new HashMap<>();
        rolePages.put(SecurityRole.Customers, "/customer/customerIndex.jsp");
        rolePages.put(SecurityRole.BankTellers, "/bankTeller/bankTellerIndex.jsp");
        
        commands.put("login", new LoginCommand(rolePages,"/login/login.jsp"));
        
        

        //customer
        commands.put("customerIndex", new CustomerIndexCommand("/customer/customerIndex.jsp", "Customer Index",SecurityRole.Customers));

        //bankTeller
        commands.put("bankTellerIndex", new BankTellerIndexCommand("/bankTeller/bankTellerIndex.jsp", "BankTeller Index",SecurityRole.BankTellers));

        //all mobile
        commands.put("mobileMain", new TargetCommand("/all/mobile/mobileMain.jsp", "Main Page",SecurityRole.All));
        commands.put("mobileLogin", new TargetCommand("/login/mobile/mobileLogin.jsp", "loginMobile",SecurityRole.All));
    }

    public static Factory getInstance() {
        return instance;
    }

    public static BankDataController getBankController() {
        return null; //need to add controller here!!!!!!!1
    }

    public Command getCommand(String cmdStr, HttpServletRequest res) {
        if (cmdStr == null) {
            cmdStr = isMobileDevice(res) ? "mobileMain" : "main";
        }
        return commands.get(cmdStr);
    }

    public boolean isMobileDevice(HttpServletRequest res) {
        String userAgent = res.getHeader("User-Agent");
        String httpAccept = res.getHeader("Accept");
        UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);
        return detector.detectMobileQuick();
    }
}
