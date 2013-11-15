/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.UserDTO;
import contract.BankDataInterface;
import entities.Account;
import entities.CustomerDetails;
import entities.Users;
import entities.UsersDetails;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;

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
        em.persist(customer);
    }

    @Override
    public CustomerDTO getCustomer(long id) {
        Query query = em.createNamedQuery("CustomerDetails.findById");
        query.setParameter("id", id);
        CustomerDetails c = (CustomerDetails)query.getSingleResult();
        CustomerDTO temp = new CustomerDTO(c.getId(),c.getFirstName(),c.getLastName(),c.getEmail());        
        return temp;
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        Query query = em.createNamedQuery("CustomerDetails.findByEmail");
        query.setParameter("email", email);
        CustomerDetails c = (CustomerDetails)query.getSingleResult();
        CustomerDTO temp = new CustomerDTO(c.getId(),c.getFirstName(),c.getLastName(),c.getEmail());        
        return temp;
    }

    @Override
    public AccountDTO getAccount(long id) {
        Account a = em.find(Account.class, id);
        AccountDTO temp = new AccountDTO(a.getAccountId(),a.getAccountType(),a.getBalance());
        return temp;
        
    }

    @Override
    public Collection<AccountDTO> getAccounts() {
     Query query =em.createNamedQuery("Account.findAll");
    
        Collection<Account> a = query.getResultList();
        
        Collection<AccountDTO> ad = new ArrayList<>();
       
        for (Account t: a) {
            AccountDTO temp = new AccountDTO(t.getAccountId(),t.getAccountType(),t.getBalance());       
            temp.setOwner(getCustomer(t.getOwner().getId()));
            ad.add(temp);
        }
        
        return ad;
    }

    @Override
    public Collection<CustomerDTO> getCustomers() {
    Query query =em.createNamedQuery("CustomerDetail.findAll");
    
        Collection<CustomerDetails> cs = query.getResultList();
        
        Collection<CustomerDTO> cd = new ArrayList<>();
       
        for (CustomerDetails t: cs) {
            CustomerDTO temp = new CustomerDTO(t.getId(),t.getFirstName(),t.getLastName(),t.getEmail());
           
          
            cd.add(temp);
        }
        
        return cd;
    
    }

    @Override
    public void addAccount(Long custID, AccountDTO account) {
        CustomerDetails c = em.find(CustomerDetails.class, custID);
        CustomerDTO temp = new CustomerDTO(c.getId(),c.getFirstName(),c.getLastName(),c.getEmail());
        temp.addAccount(account);
        em.persist(temp);
        
    }

    @Override
    public void newTransfer(long custID, long fromID, long toID, double amount, String message) {
        Account aFrom = em.find(Account.class, fromID);
        Account aTo = em.find(Account.class, toID);
        CustomerDetails customer = em.find(CustomerDetails.class, custID);
        
        CustomerDTO temp= new CustomerDTO(customer.getId(),customer.getFirstName(),customer.getLastName(),customer.getEmail());
        AccountDTO tempFrom = new AccountDTO(aFrom.getAccountId(), aFrom.getAccountType(),aFrom.getBalance());
        AccountDTO tempTO = new AccountDTO(aTo.getAccountId(),aTo.getAccountType(),aTo.getBalance());
        
        tempFrom.createTransaction(amount, message);
        tempTO.createTransaction(amount, message+"From: "+temp.getCustomerId());
        
        em.persist(tempFrom);
        em.persist(tempTO);     
        
        
        
    }

    @Override
    public void saveEditedCustomer(CustomerDTO cust, CustomerDTO temp) {
    em.persist(temp);
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public UserDTO getUser(String email) {
    
     Query query =em.createNamedQuery("UsersDetails.findByEmail");
     query.setParameter("email", email);
     UsersDetails u = (UsersDetails) query.getSingleResult();
     UserDTO temp = new UserDTO(u.getFirstName(),u.getLastName(),u.getEmail(),u.getId());
     
     return temp;
    
    
    }

    

}
