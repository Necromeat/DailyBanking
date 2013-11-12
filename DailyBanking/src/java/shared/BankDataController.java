
package shared;

import java.util.Collection;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public interface BankDataController {
    
    void addCustomer(Customer customer);
    Customer getCustomer(long id);
    Customer getCustomerByEmail(String email);
    Account getAccount(long id);
    Collection<Account> getAccounts();
    Collection<Customer> getCustomers();
    void addAccount(Long custID, Account account);
    void newTransfer(long custID, long fromID, long toID, double amount, String message);
    void saveEditedCustomer(Customer cust, Customer temp);
    

}
