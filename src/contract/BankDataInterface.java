/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.UserDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author Andrew
 */
@Remote
public interface BankDataInterface {
   
    void addCustomer(CustomerDTO customer);
    CustomerDTO getCustomer(long id);
    CustomerDTO getCustomerByEmail(String email);
    AccountDTO getAccount(long id);
    Collection<AccountDTO> getAccounts();
    Collection<CustomerDTO> getCustomers();
    void addAccount(Long custID, AccountDTO account);
    void newTransfer(long custID, long fromID, long toID, double amount, String message);
    void saveEditedCustomer(CustomerDTO cust, CustomerDTO temp);
    
    //BankTellers
     UserDTO getUser(String email);

    CustomerDTO businessMethod();
     
    
    
}
