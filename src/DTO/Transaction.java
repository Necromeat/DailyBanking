package DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lars Mortensen
 */
public class Transaction implements Serializable {
  private long transactionId;
  private long userid;
  private Date timestamp;
  private double amount;
  private double balance;
  private String info;

  public Transaction(long userid,long transactionid,double amount, String info) {
    this.timestamp = new Date();
    this.amount = amount;
    this.info = info;
    this.userid = userid;
    this.transactionId = transactionid;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

    public long getUserid() {
        return userid;
    }
  
  

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", timestamp=" + timestamp + ", amount=" + amount + ", balance=" + balance + ", info=" + info + '}';
    }
  
}
