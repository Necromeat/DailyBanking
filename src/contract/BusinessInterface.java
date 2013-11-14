/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import DTO.*;
import javax.ejb.Remote;

/**
 *
 * @author Andrew
 */

@Remote
public interface BusinessInterface {
    //Account 
    void AddIntrest(double intrest);
    Transaction createTransaction(double amount, String message);
    long getAccountId();
    String getAccountType();
    double getBalance();
    CustomerDTO getOwner(Long id);
    Collection<MessageDTO> getStatements();
    List<Transaction> getTransactions();
    void setAccountId(long accountId);
    void setAccountType(String accountType);
    void setBalance(double balance);
    void setOwner(CustomerDTO owner);
    void setStatement(String account, Object info);
    void setTransactions(List<Transaction> transactions);
  
    
    /*Time Deposit Account*/
    AccountDTO getCheckingAccount(long customerID,String accounttype, AccountDTO account);
    double checkingAccountWithdrawAmount(long customerID,int accountid,double amount);
    double checkingAccountDepositAmount(long customerID,int accountid,double amount);
    
    
    /*Money Market Account**/
    boolean checkMinBalance(double customerbalance,double minbalance);
    
    /*Time Deposit Account*/
    void setStartDate(Date startDate);
    void setFinishDate(Date endDate);
    Date getStartDate();
    Date getFinishDate();
    boolean Open(Date date);
    
    /*Statement*/
    void setStatment(Date date, String Statment);
    
    /*Customer*/
    CustomerDTO getCustomer(Long id);
    void addAccount(AccountDTO account);
    Collection<AccountDTO> getAccounts(Long customerid);
    long getCustomerId();
    String getEmail();
    String getFirstName();
    String getLastName();
    void setAccounts(List<AccountDTO> accounts);
    void setCustomerId(long customerId);
    void setEmail(String email);
    void setFirstName(String firstName);
    void setLastName(String lastName);    
  
    
    /*All*/
    @Override
    String toString();  
}
