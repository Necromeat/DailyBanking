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
import Utils.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    userPK.setUserRoll("Customers");
    UserGroups ug = new UserGroups();
    ug.setUserGroupsPK(userPK);
    
     em.persist(ug);
     em.persist(customerTemp);
   
    }

    @Override
    public String checkUserEmail(String email){
        System.out.println("CheckUSerEmail method working");
        String result;
        try{
            Query query = em.createNamedQuery("CustomerDetail.findByUserEmail");
            query.setParameter("userEmail", email);  
            CustomerDetail tempUser = (CustomerDetail)query.getSingleResult();
            System.out.println("successfull try! should return false!");
            result = "false";
        }catch(Exception e){
            System.out.println(e);
            System.out.println("exception caught! should return true!");
            result = "true";
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
           tempDTOAccount.setTransactions(tempUseTransaction);
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

    List<Transaction> tempTransaction = getTransactions();
    Collection<AccountDTO> accountDTOOut = new ArrayList();
    
    
    Query queryDetails = em.createNamedQuery("AccountDetail.findAll");
    Query quertCustomerDetail =  em.createNamedQuery("CustomerDetail.findAll");
    
    Collection<AccountDetail> tempDetails =queryDetails .getResultList();
    Collection<CustomerDetail> tempCustomer=quertCustomerDetail.getResultList();
    
    
    for (AccountDetail f:tempDetails) {
           AccountDTO tempDTOAccount = new AccountDTO(f.getAccountDetailPK().getAccountId(),f.getAccountType().getAccountType(),f.getBalance());
           List<Transaction>temp = new ArrayList();
           for (Transaction at:tempTransaction) {
             if(f.getAccountDetailPK().getAccountId() == at.getUserid()){
              temp.add(at);
             }
             
           }
        tempDTOAccount.setTransactions(temp);
        
           for (CustomerDetail cd :tempCustomer){
               if(f.getAccountDetailPK().getAccountId() == cd.getUserId()){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveEditedCustomer(CustomerDTO cust, CustomerDTO temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

       
    private List<Transaction> getTransactions(){
       List<AccountTransaction> tempTrans;
       List<Transaction> Trans = new ArrayList();
        Query query = em.createNamedQuery("AccountTransaction.findAll");        
        tempTrans = query.getResultList();
        
        for (AccountTransaction d: tempTrans) {
            long temp =d.getAccountId().getAccountId();
            Trans.add(new Transaction(temp,d.getTransactionId(),d.getAmount(),d.getMessage()));
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
    
   public CustomerDTO getCustomerByPrincipal(){
       
       return null;
   }
    
}
