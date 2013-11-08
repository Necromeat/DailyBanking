
package shared;

import java.util.Date;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class MoneyMarketAccount extends Account{
    private String accounType;
    private double balance;
    private static double minBalance;
    private Customer owner;

    public MoneyMarketAccount(String accountType, double balance) {
        super(accountType, balance);
        this.balance=balance;
    }

    public String getAccounType() {
        return accounType;
    }

    public double getMoneyMarketBalance(){
        return balance;
    }
    
    public Account getMoneyMarketAccount(long customerID,int accountid){
         this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID){
          return owner.getAccounts().get(accountid);
      }else{
          return null;
      }
    }
    
    public boolean checkMinBalance(double customerbalance,double minbalance){
        minBalance= minbalance;
        
        if(customerbalance >= minBalance){
            return true;
        }
        
        return false;
    }
   
     public double moneyMarketWithdrawAmount(long customerID,int accountid,double amount){
        
       this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID && getBalance()>=getMinBalance() ){
          this.balance=getBalance()-amount;          
          setBalance(balance);          
           createTransaction(balance,"Account: "+accountid+"Amount:"+amount+" withdrawn"+new Date());
          return amount;
      }else{
          return -1212121212;/*This needs to be changed*/
      }
    }
    
    public double moneyMarketDepositAmount(long customerID,int accountid,double amount){
        this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID){
          this.balance=getBalance()+amount;          
          setBalance(balance);          
          createTransaction(balance,"Account: "+accountid+"Amount:"+amount+" Deposited"+new Date());
          return amount;
      }else{
          return -1212121212;/*This needs to be changed*/
      }
    }
    
    public void moneyMarketAddIntrest(long customerID,int accountid,double intrest){
        this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID){
          this.balance=getBalance()*intrest;          
           setBalance(balance);          
          createTransaction(balance,"Account: "+accountid+"intreseted added:"+intrest+" "+new Date());
      }
    }

    public double getMinBalance(){
     
        return minBalance;
    }
    
    //account actions
    @Override
    public double getBalance() {
        return super.getBalance(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction createTransaction(double amount, String message) {
        return super.createTransaction(amount, message); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public Customer getOwner() {
        return super.getOwner(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
