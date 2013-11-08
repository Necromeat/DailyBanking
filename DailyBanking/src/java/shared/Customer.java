package shared;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class Customer {
  private long customerId;
  private String firstName;
  private String lastName;
  private String email;
  private List<Account> accounts = new ArrayList();
  private static int nextid = 1000;
  
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

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public Customer(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    customerId = nextid++;
  }
  
  public void addAccount(Account account){
    accounts.add(account);
    account.setOwner(this);
  }
  
}
