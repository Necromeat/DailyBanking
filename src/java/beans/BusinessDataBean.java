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
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.UnsupportedEncodingException;
import java.security.Identity;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
/**
 *
 * @author Andrew
 */


@Stateless
@Remote


@DeclareRoles({"Customers","BankTellers"})

public class BusinessDataBean implements BankDataInterface {
    @PersistenceContext(unitName = "DailyBankingBusinessDataBasePU")
    private EntityManager em;
    
@Resource
SessionContext ctx;
    @Override
    
    public void addCustomer(CustomerDTO customer) {
    CustomerDetail customerTemp = new CustomerDetail();
    Query query = em.createNamedQuery("Users.findByUserEmail");
    query.setParameter("userEmail", customer.getEmail());
    Users user = (Users)query.getSingleResult();    
    UserGroupsPK userPK = new UserGroupsPK();
    
    customerTemp.setFname(customer.getFirstName());
    customerTemp.setLname(customer.getLastName());
    customerTemp.setUserEmail(customer.getEmail());
    customerTemp.setUserId(user.getUserId());
    customerTemp.setUsers(user);    
    
    userPK.setUserEmail(customer.getEmail());
    userPK.setUserRoll("Customer");
    UserGroups ug = new UserGroups();
    ug.setUserGroupsPK(userPK);
    
     em.persist(ug);
     em.persist(customerTemp);
   
    }

    @Override
    public boolean checkUserEmail(String email){
        boolean result =true;
        try{
            Query query = em.createNamedQuery("Users.findByUserEmail");
            query.setParameter("userEmail", email);
            Users temp =(Users)query.getSingleResult();
            if(temp.getUserEmail().equals(email)){                
            result = false;
            }
        }catch(Exception e){
        
        }
        return result;
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
        
        for (AccountDetail f:tempAccounts) {
           AccountDTO tempDTOAccount = new AccountDTO(f.getAccountDetailPK().getAccountId(),f.getAccountType().getAccountType(),f.getBalance());
           tempDTOAccount.setOwner(temp2);    
           tempDTOAccount.setTransactions(getTransactions(f.getAccountDetailPK().getAccountId()));
           tempAccountDTO.add(tempDTOAccount);
           
        }        
        
        temp2.setAccounts(tempAccountDTO);
        return temp2;
    }

    
    
    @Override
    public AccountDTO getAccount(long id) {
        Query query = em.createNamedQuery("AccountDetail.findByAccountId");
        query.setParameter("accountId", id);
        AccountDetail accounttemp= (AccountDetail)query.getSingleResult();
        
        AccountDetailPK accounttype = new AccountDetailPK();
        accounttype.setAccountId(accounttemp.getAccountDetailPK().getAccountId());
        accounttype.setUserId(accounttemp.getAccountDetailPK().getAccountId());
        AccountDTO tempAccountDTO = new AccountDTO(accounttype.getAccountId(),accounttemp.getAccountType().getAccountType(),accounttemp.getBalance());
        tempAccountDTO.setTransactions(getTransactions(accounttype.getAccountId()));
        Query customerQ = em.createNamedQuery("findByUserId");
        customerQ.setParameter("userId", accounttype.getUserId());
        CustomerDetail customerTemp = (CustomerDetail)customerQ.getSingleResult();
        CustomerDTO tempCustomer = new CustomerDTO(customerTemp.getUserId(),customerTemp.getFname(),customerTemp.getLname(),customerTemp.getUserEmail());
        tempAccountDTO.setOwner(tempCustomer);
        
          return tempAccountDTO;
    }

    
    
    
    @Override
    public Collection<AccountDTO> getAccounts() {

    Collection<AccountDTO> accountDTOOut = new ArrayList();
    
    
    Query queryDetails = em.createNamedQuery("AccountDetail.findAll");
    Query quertCustomerDetail =  em.createNamedQuery("CustomerDetail.findAll");
    
    Collection<AccountDetail> tempDetails =queryDetails .getResultList();
    Collection<CustomerDetail> tempCustomer=quertCustomerDetail.getResultList();
    
    
    for (AccountDetail f:tempDetails) {
           AccountDTO tempDTOAccount = new AccountDTO(f.getAccountDetailPK().getAccountId(),f.getAccountType().getAccountType(),f.getBalance());
           tempDTOAccount.setTransactions(getTransactions(f.getAccountDetailPK().getAccountId()));
        
           for (CustomerDetail cd :tempCustomer){
               if(f.getAccountDetailPK().getUserId() == cd.getUserId()){
                CustomerDTO tempCustomerDTO = new CustomerDTO(cd.getUserId(),cd.getFname(),cd.getLname(),cd.getUserEmail());
                tempDTOAccount.setOwner(tempCustomerDTO);
               }
         }  
           
            accountDTOOut.add(tempDTOAccount);
             }
    return accountDTOOut;
    }

    @Override
    public Collection<CustomerDTO> getCustomers() {
    Query query = em.createNamedQuery("CustomerDetail.findAll");
    Collection<CustomerDetail> tempDetail = query.getResultList();
    Collection<CustomerDTO> tempDTO = new ArrayList();
    
        for (CustomerDetail d: tempDetail) {
            CustomerDTO temp = new CustomerDTO(d.getUserId(),d.getFname(),d.getLname(),d.getUserEmail());
            tempDTO.add(temp);
        }
        return tempDTO;
    }

    @Override
    public void addAccount(Long custID, AccountDTO account) {
        AccountType tempType = new AccountType();
        AccountDetail tempDetail = new AccountDetail();
        AccountDetailPK detailPk = new AccountDetailPK();
        tempType.setAccountType(account.getAccountType());
        detailPk.setUserId(custID);
        
        em.persist(tempType);
        
        tempDetail.setBalance(account.getBalance());
    }

    @Override
    public void newTransfer(long custID, long fromID, long toID, double amount, String message) {

       AccountTransaction from = new AccountTransaction(); 
       AccountTransaction to  = new AccountTransaction(); 
       AccountTransactionPK apk = new AccountTransactionPK();
        AccountDTO accountFrom = getAccount(fromID);
            accountFrom.createTransaction(custID, toID, -amount, message);
        AccountDTO accountTo = getAccount(toID);
            accountTo.createTransaction(custID, toID, amount, message);
           
       from.setAmount(accountFrom.getBalance());
       apk.setAccountId(accountFrom.getAccountId());
       from.setAccountTransactionPK(apk);
       from.setTypeOf("Fudge");
       from.setMessage(message);
       em.persist(from);       
       to.setAmount(accountTo.getBalance());
       apk.setAccountId(accountTo.getAccountId());
       to.setAccountTransactionPK(apk);
       to.setTypeOf("Fudge");
       to.setMessage(message);
       em.persist(to);
    }

    @Override
    public void saveEditedCustomer(CustomerDTO cust, CustomerDTO temp) {
    CustomerDetail tempDetail = em.find(CustomerDetail.class, cust.getCustomerId());
    tempDetail.setFname(temp.getFirstName());
    tempDetail.setLname(temp.getLastName());
    tempDetail.setUserEmail(temp.getEmail());
    em.persist(tempDetail);
    
    }

    @Override
    public UserDTO getUser(String email) {
        Query query = em.createNamedQuery("Users.findByUserEmail");
        query.setParameter("userEmail", email);
        Users tempUser = (Users)query.getSingleResult();
        UserDTO temp = new UserDTO();
        temp.setEmail(email);
        temp.setId(tempUser.getUserId());
        temp.setPw(tempUser.getUserPw());
        
        return temp;
        
        
    }

       
    private List<Transaction> getTransactions(long accountid){
       List<AccountTransaction> tempTrans = null;
       List<Transaction> Trans = new ArrayList();
        Query query = em.createNamedQuery("AccountTransaction.findByAccountId"); 
        query.setParameter("accountId", accountid);
        tempTrans = query.getResultList();
        
        
        for (AccountTransaction d: tempTrans) {
            Trans.add(new Transaction(d.getAccountTransactionPK().getAccountId(),d.getAccountTransactionPK().getTransactionId(),d.getAmount(),d.getMessage()));
            
        }
        
        
        
        return Trans;
    }

    @Override
    public void addUser(String pw, String Email){
        Users user = new Users();
        try {
            user.setUserPw(Utils.PasswordDigestGenerator.getEncoded(pw));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BusinessDataBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BusinessDataBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setUserEmail(Email);
        
        em.persist(user);
        
    }

    @Override
    public CustomerDTO getCustomer() {
    CustomerDTO temp = null;
        Principal callerPrincipal1 = ctx.getCallerPrincipal();
        temp = getCustomerByEmail(""+callerPrincipal1);
       return temp;
    }

    @Override
    public int countCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
