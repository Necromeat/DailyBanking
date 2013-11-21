/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.Transaction;
import DTO.UserDTO;
import contract.BankDataInterface;
import entities.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
/**
 *
 * @author Andrew
 */
@Stateless
@Remote
public class BusinessDataBean implements BankDataInterface {
    @PersistenceContext(unitName = "DailyBankingBusinessDataBasePU")
    private EntityManager em;
    @Override
    
    public void addCustomer(CustomerDTO customer) {

          
    
    }

    

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        UserDetail tempUser = em.find(UserDetail.class, email);
        CustomerDetail tempCustomer;
        CustomerDTO temp2 = new CustomerDTO(tempUser.getUserId().getUserId(),tempUser.getFname(),tempUser.getLname(),tempUser.getEmail());
        temp2.addAccount(new AccountDTO(temp2.getCustomerId(),"Cock",2));
        return temp2;
    }

    @Override
    public AccountDTO getAccount(long id) {
    AccountDetail tempAccountDetail;
   tempAccountDetail  = em.find(AccountDetail.class, id);
    AccountType  tempAccountType;
    tempAccountType = em.find(AccountType.class, id);
    CustomerDetail tempCustomer = em.find(CustomerDetail.class, tempAccountDetail.getCustomerId());
    UserDetail tempUserDetail =em.find(UserDetail.class, tempCustomer.getUserId().getUserId());
    CustomerDTO tempCustomerDTO = new CustomerDTO(tempUserDetail.getUserId().getUserId(),tempUserDetail.getFname(),tempUserDetail.getLname(),tempUserDetail.getEmail());
    AccountDTO temp = new AccountDTO(tempAccountDetail.getAccountId(),tempAccountType.getAccountType(),tempAccountDetail.getBalance());
    temp.setOwner(tempCustomerDTO);
    
    return temp;
    }

    @Override
    public Collection<AccountDTO> getAccounts() {
    Collection<AccountDetail> tempDetails;
    Collection<AccountTransaction> tempTrans;
    
    Query queryAccountTans = em.createNamedQuery("AccountTransaction.findAll");
    tempTrans=queryAccountTans.getResultList();
    Collection<AccountDTO> outDTO = null;
    
    Query query = em.createNamedQuery("AccountDetail.findAll");
    tempDetails = query.getResultList();
    
        for (AccountDetail ad: tempDetails) {
            AccountDTO tempAccountDTO = new AccountDTO(ad.getAccountId(),getAccount(ad.getAccountId()).getAccountType(),ad.getBalance());
             
            CustomerDetail tempCustomer = em.find(CustomerDetail.class, ad.getCustomerId());
             UserDetail tempUserDetail =em.find(UserDetail.class, tempCustomer.getUserId().getUserId());
             CustomerDTO tempCustomerDTO = new CustomerDTO(tempUserDetail.getUserId().getUserId(),tempUserDetail.getFname(),tempUserDetail.getLname(),tempUserDetail.getEmail());
   
            tempAccountDTO.setOwner(tempCustomerDTO);
            
            List<Transaction> transaction = null;
            
            for (AccountTransaction at:tempTrans) {
                if(at.getAccountId().getAccountId() == tempAccountDTO.getAccountId()){
                    Transaction tempa = new Transaction(at.getAmount(),at.getTypeOf()+" "+at.getMessage());
                    transaction.add(tempa);
                }
            }
        
            tempAccountDTO.setTransactions(transaction);
            outDTO.add(tempAccountDTO);
        }
    
        return outDTO;
    }

    @Override
    public Collection<CustomerDTO> getCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAccount(Long custID, AccountDTO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newTransfer(long custID, long fromID, long toID, double amount, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveEditedCustomer(CustomerDTO cust, CustomerDTO temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDTO getUser(String email) {
        UserDetail tempUser = em.find(UserDetail.class, email);
        UserDTO temp = new UserDTO();
        temp.setUserFname(tempUser.getFname());
        temp.setUserLname(tempUser.getLname());
        temp.setEmail(tempUser.getEmail());
        return temp;
        
        
    }

    @Override
    public CustomerDTO businessMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
