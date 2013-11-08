
package shared;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public interface BusinessController{
    
    /*Time Deposit Account*/
    Account getCheckingAccount(long customerID,String accounttype, Account account);
    double checkingAccountWithdrawAmount(long customerID,int accountid,double amount);
    double checkingAccountDepositAmount(long customerID,int accountid,double amount);
    void checkingAccountAddIntrest(long customerID,int accountid,double intrest);
    
    
    /*Money Market Account*/
    Account getMoneyMarketAccount(long customerID,int accountid);   
    boolean checkMinBalance(double customerbalance,double minbalance);
    double moneyMarketAccountWithdrawAmount(long customerID,int accountid,double amount);
    double moneyMarketAccountDepositAmount(long customerID,int accountid,double amount);
    void moneyMarketAccountAddIntrest(long customerID,int accountid,double intrest);
    
    /*Time Deposit Account*/
    Account getTimeDepositAccount(long customerID,int accountid);
    void setStartDate(Date startDate);
    void setFinishDate(Date endDate);
    Date getStartDate();
    Date getFinishDate();
    boolean Open(Date date);
    double timeDepositAccountWithdrawAmount(long customerID,int accountid,double amount);
    double timeDepositAccountDepositAmount(long customerID,int accountid,double amount);
    double timeDepositAccountAddIntrest(long customerID,int accountid,double intrest);
    
    /*Statement*/
    void setStatment(Date date, String Statment);
    Statement getStatment(int statementid);
    Map<Integer,Statement> getStatements();
    
    
}
