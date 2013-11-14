/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Andrew
 */
public class MoneyMarketAccount extends AccountDTO{
    private double minBalance;

    public MoneyMarketAccount(Long accountid, String accountType, double balance) {
        super(accountid, accountType, balance);
    }
    
    

  
    public boolean checkMinBalance(double customerbalance){       
        
        if(customerbalance >= minBalance){
            return true;
        }
        
        return false;
    }
   
      

      public void setMinBalance(double minBalance){
          this.minBalance = minBalance;
      }
    
}
