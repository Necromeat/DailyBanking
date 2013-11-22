package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew
 */
public class CustomerDTO implements Serializable {
  private long customerId;
  private String firstName;
  private String lastName;
  private String email;
  private List<AccountDTO> accounts = new ArrayList();
  
    public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

    
  public List<AccountDTO> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<AccountDTO> accounts) {
    this.accounts = accounts;
  }

  public CustomerDTO(long cusid,String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    customerId = cusid;
  }
  
  public void addAccount(AccountDTO account){
      account.setOwner(this);
      accounts.add(account);
    
  }
  
 
  
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", accounts=" + accounts + '}';
    }

   
  
  
  
}
