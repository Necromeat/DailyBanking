/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import contract.BankDataInterface;
import java.util.Collection;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Andrew
 */
@Stateless
@Remote
public class BusinessDataBean implements BankDataInterface {

    @Override
    public void addCustomer(CustomerDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO getCustomer(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDTO getAccount(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<AccountDTO> getAccounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
