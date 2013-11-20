/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.MessageDTO;
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
import javax.transaction.UserTransaction;
/**
 *
 * @author Andrew
 */
@Stateless
@Remote
public class BusinessDataBean implements BankDataInterface {
    @PersistenceContext(unitName = "DailyBankingBusinessDataBasePU")
    private EntityManager em;
    @Resource
    private UserTransaction utx;
    @Override
    
    public void addCustomer(CustomerDTO customer) {
        try {
            utx.begin();
            
        } catch (NotSupportedException ex) {
            Logger.getLogger(BusinessDataBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BusinessDataBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }

    @Override
    public CustomerDTO getCustomer(long id) { 
    
              
        UserDetail tempUser = em.find(UserDetail.class, id);
        UserType tem = tempUser.getUserId();
        CustomerDTO temp2 = new CustomerDTO(tem.getUserId(),tempUser.getFname(),tempUser.getLname(),tempUser.getEmail());
       Query query = em.createNamedQuery("AccountDetail.findByCustomerId");
       query.setParameter("customerId", id);
        List<AccountDetail> accountDetailTemp = query.getResultList();
        List<AccountDTO>accountstemp = new ArrayList();
        for (AccountDetail f:accountDetailTemp) {
            accountstemp.add(getAccount(f.getAccountId()));
        }
        
        temp2.setAccounts(accountstemp);
        
       return temp2;
        
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
     UserDetail tempUser = em.find(UserDetail.class, email);
        UserType tem = tempUser.getUserId();
        CustomerDTO temp2 = new CustomerDTO(tem.getUserId(),tempUser.getFname(),tempUser.getLname(),tempUser.getEmail());
       Query query = em.createNamedQuery("AccountDetail.findByCustomerId");
       query.setParameter("customerId", temp2.getCustomerId());
        List<AccountDetail> accountDetailTemp = query.getResultList();
        List<AccountDTO>accountstemp = new ArrayList();
        for (AccountDetail f:accountDetailTemp) {
            accountstemp.add(getAccount(f.getAccountId()));
        }
        
        temp2.setAccounts(accountstemp);
        
       return temp2;
    }

    @Override
    public AccountDTO getAccount(long id) {
    AccountDetail tempAccountDetail = em.find(AccountDetail.class, id);
    AccountType tempAccountType = em.find(AccountType.class, id);
    CustomerDTO tempCustomer = getCustomer(tempAccountDetail.getCustomerId());
    AccountDTO temp = new AccountDTO(tempAccountDetail.getAccountId(),tempAccountType.getAccountType(),tempAccountDetail.getBalance());
    temp.setOwner(tempCustomer);
    
    return temp;
    }

    @Override
    public Collection<AccountDTO> getAccounts() {
    Query query = em.createNamedQuery("AccountDetail.findAll");
    Collection<AccountDetail> tempDetails;
    Query queryAccountTans = em.createNamedQuery("AccountTransaction.findAll");
    Collection<AccountTransaction> tempTrans;
    tempTrans=queryAccountTans.getResultList();
    Collection<AccountDTO> outDTO = new ArrayList();
    
    tempDetails = query.getResultList();
        for (AccountDetail ad: tempDetails) {
            AccountDTO tempAccountDTO = new AccountDTO(ad.getAccountId(),getAccount(ad.getAccountId()).getAccountType(),ad.getBalance());
            tempAccountDTO.setOwner(getCustomer(ad.getCustomerId()));
            List<Transaction> transaction = new ArrayList();
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO businessMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
