/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Andrew
 */
public class TimeDepositAccount extends AccountDTO{
    
    private Date startDate;
    private Date endDate;
    private boolean openForBusiness = false;

    public TimeDepositAccount(Long accountid, String accountType, double balance) {
        super(accountid, accountType, balance);
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
    
    public boolean open(Date date){
        if(date.after(getFinishDate())){
            this.openForBusiness=true;
        }
        return openForBusiness;
    }
    
    
    
}
