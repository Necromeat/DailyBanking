package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Date;

public class AccountDTO  implements Serializable {
  private long accountId;
  private String accountType;
  private double balance;
  private CustomerDTO owner;
  private MessageDTO statement = new MessageDTO();
  private List<Transaction> transactions = new ArrayList();  

  public AccountDTO(Long accountid, String accountType, double balance) {
    this.accountType = accountType;
    this.balance = balance;
    this.accountId = accountid;
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
      if(balance<0){
          setStatement(accountType,"Is overdrawnen");
      }
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  public Transaction createTransaction(long useridtemp, long transactionId, double amount, String message){
    Transaction t = new Transaction(useridtemp,transactionId,amount,message);
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

  public void setOwner(CustomerDTO owner) {
    this.owner = owner;
  }

  public CustomerDTO getOwner() {
    return owner;
  }
  
    public void AddIntrest(double intrest){          
          double intrestVar= getBalance()*(1+(intrest/100));
          setBalance(intrestVar);  
          setStatement(accountType, intrest+" Intrest added");
          
    }

    public Collection<MessageDTO> getStatements() {
        return statement.getStatments();
     }
    
    @Override
    public String toString() {
        return "Account" + "accountId=" + accountId;
    }
  
    public void setStatement(String account, Object info){
        statement.setStatment(new Date(),account+" "+ info);
    }
  
}
