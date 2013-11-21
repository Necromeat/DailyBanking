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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        Query query = em.createNamedQuery("CustomerDetail.findByUserEmail");
        query.setParameter("userEmail", email);        
        CustomerDetail tempUser=(CustomerDetail)query.getSingleResult();
        CustomerDTO temp2 = new CustomerDTO(tempUser.getUserId(),tempUser.getFname(),tempUser.getLname(),tempUser.getUserEmail());
        Query queryAccounts = em.createNamedQuery("AccountDetail.findAll");
        Collection<AccountDetail> tempAccounts= queryAccounts.getResultList();
        List<AccountDTO> tempAccountDTO = new ArrayList();
        List<Transaction> tempTransaction = getTransactions();
        List<Transaction> tempUseTransaction= new ArrayList();
        for (AccountDetail f:tempAccounts) {
           AccountDTO tempDTOAccount = new AccountDTO(f.getAccountDetailPK().getAccountId(),f.getAccountType().getAccountType(),f.getBalance());
           tempDTOAccount.setOwner(temp2);    
            for (Transaction df:tempTransaction) {
                if(df.getUserid()==tempDTOAccount.getAccountId()){
                    tempUseTransaction.add(df);
                }
            }
           tempDTOAccount.setTransactions(tempTransaction);
           tempAccountDTO.add(tempDTOAccount);
           
        }
        
  
        
        
        
        
        temp2.setAccounts(tempAccountDTO);
        return temp2;
    }

    
    
    @Override
    public AccountDTO getAccount(long id) {
        
        AccountDetail accounttemp= em.find(AccountDetail.class, id);
        AccountDetailPK accounttype = em.find(AccountDetailPK.class, accounttemp.getUsers().getUserId());
        AccountDTO tempAccountDTO = new AccountDTO(accounttype.getAccountId(),accounttemp.getAccountType().getAccountType(),accounttemp.getBalance());
        
        
    return tempAccountDTO;
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
            AccountDTO tempAccountDTO = new AccountDTO(ad.getAccountType().getAccountId(),getAccount(ad.getAccountType().getAccountId()).getAccountType(),ad.getBalance());
             
           Query queryCustomer = em.createNamedQuery("CustomerDetail.findByUserId");
            queryCustomer.setParameter("userId", ad.getUsers().getUserId());
                CustomerDetail tempCustomer = (CustomerDetail)query.getSingleResult();
             CustomerDTO tempCustomerDTO = new CustomerDTO(tempCustomer.getUserId(),tempCustomer.getFname(),tempCustomer.getLname(),tempCustomer.getUserEmail());
   
            tempAccountDTO.setOwner(tempCustomerDTO);
            
            List<Transaction> transaction=new ArrayList();
            
            
        
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
        Users tempUser = em.find(Users.class, email);
        UserDTO temp = new UserDTO();
        temp.setEmail(email);
        return temp;
        
        
    }

       
    private List<Transaction> getTransactions(){
       List<AccountTransaction> tempTrans;
       List<Transaction> Trans = new ArrayList();
        Query query = em.createNamedQuery("AccountTransaction.findAll");        
        tempTrans = query.getResultList();
        
        for (AccountTransaction d: tempTrans) {
            Trans.add(new Transaction(d.getAccountId().getAccountId(),d.getTransactionId(),d.getAmount(),d.getMessage()));
        }
        
        
        
        return Trans;
    }

    
}
