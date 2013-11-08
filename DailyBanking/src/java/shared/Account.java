package shared;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */

public class Account {
  private static long nextId = 5000;
  private long accountId;
  private String accountType;
  private double balance;
  private Customer owner;
  private List<Transaction> transactions = new ArrayList();

  public Account(String accountType, double balance) {
    this.accountType = accountType;
    this.balance = balance;
    accountId = nextId++;
  }

  public long getAccountId() {
    return accountId;
  }

  public void setAccountId(long accountId) {
    this.accountId = accountId;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
  public Transaction createTransaction(double amount, String message){
    Transaction t = new Transaction(amount,message);
    transactions.add(t);
    balance += amount;
    t.setBalance(balance);
    return t;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  void setOwner(Customer owner) {
    this.owner = owner;
  }

  public Customer getOwner() {
    return owner;
  }
  
  
}
