/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.MessageDTO;
import DTO.Transaction;
import contract.BusinessInterface;
import entities.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrew
 */
@Stateless
@Remote
public class BussinesBean implements BusinessInterface {
    @PersistenceContext(unitName = "DailyBankingBusinessDataBasePU")
    private EntityManager em;

    public BussinesBean() {
    }
    
     
     
     
     @Override
    public void AddIntrest(double intrest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction createTransaction(double amount, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getAccountId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAccountType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO getOwner(Long id) {
       Customer c = em.find(Customer.class, id);  
       CustomerDTO customerDTOtemp = new CustomerDTO(c.getCfirstname(),c.getClastname(),c.getCemail());
       return null;
    
    }

    @Override
    public Collection<MessageDTO> getStatements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccountId(long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccountType(String accountType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBalance(double balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOwner(CustomerDTO owner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStatement(String account, Object info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTransactions(List<Transaction> transactions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDTO getCheckingAccount(long customerID, String accounttype, AccountDTO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double checkingAccountWithdrawAmount(long customerID, int accountid, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double checkingAccountDepositAmount(long customerID, int accountid, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkMinBalance(double customerbalance, double minbalance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStartDate(Date startDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFinishDate(Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getStartDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getFinishDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Open(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStatment(Date date, String Statment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void addAccount(AccountDTO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<AccountDTO> getAccounts(Long customerid) {
       Customer c;
        Collection<AccountDTO>accountDTOs = new ArrayList<>();
        Collection<Account>accounts;
       c = em.find(Customer.class, customerid);       
       accounts = c.getAccountCollection();
        for (Account a: accounts) {
            AccountDTO adt = new AccountDTO(a.getAccountId(), a.getAccountType(), a.getBalance());
            CustomerDTO cdt = new CustomerDTO(a.getOwner().getCfirstname(), a.getOwner().getClastname(), a.getOwner().getCemail());
            adt.setOwner(cdt);
            accountDTOs.add(adt);
            
        }
       
       return accountDTOs;
        
    }

    @Override
    public long getCustomerId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFirstName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccounts(List<AccountDTO> accounts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCustomerId(long customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastName(String lastName) {
        
        
        
    }
    
   

    public String sayHallo(){
        return "hallo";
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String toString() {
            return "BussinesBean{ works" + '}';
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
