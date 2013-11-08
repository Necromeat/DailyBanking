
package shared;

import java.util.Date;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class TimeDepositAccount extends Account{
     private String accounType;
    private double balance;
    private static double minBalance;
    private Customer owner;
    private Date startDate;
    private Date endDate;
    private boolean openForBusiness = false;

    public TimeDepositAccount(String accountType, double balance) {
        super(accountType, balance);
    }
    
    
    
     public void setStartDate(Date startDate){
         this.startDate = startDate;
     }
    
     public void setFinishDate(Date endDate){
        this.endDate = endDate;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getFinishDate(){
        return endDate;
    }
    
    public void open(Date date){
        if(date.after(getFinishDate())){
            this.openForBusiness=true;
        }
        
    }
    
    
    public double timeDepositWithdrawAmount(long customerID,int accountid,double amount){
        
       this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID && openForBusiness ){
          this.balance=getBalance()-amount;          
          setBalance(balance);          
           createTransaction(balance,"Account: "+accountid+"Amount:"+amount+" withdrawn"+new Date());
          return amount;
      }else{
          return -1212121212;/*This needs to be changed*/
      }
    }
    
    public double timeDepositAmount(long customerID,int accountid,double amount){
        this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID && !openForBusiness){
          this.balance=getBalance()+amount;          
          setBalance(balance);          
          createTransaction(balance,"Account: "+accountid+"Amount:"+amount+" Deposited"+new Date());
          return amount;
      }else{
          return -1212121212;/*This needs to be changed*/
      }
    }
    
    public void timeDepositAddIntrest(long customerID,int accountid,double intrest){
        this.owner = getOwner();
       
      if(owner.getCustomerId()==customerID && !openForBusiness){
          this.balance=getBalance()*intrest;          
           setBalance(balance);          
          createTransaction(balance,"Account: "+accountid+"intreseted added:"+intrest+" "+new Date());
      }
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
