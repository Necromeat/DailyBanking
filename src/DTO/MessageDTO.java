/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Andrew
 */
public class MessageDTO implements Serializable {
    private int nextid=1;
    private int statementid;
    private Collection<MessageDTO> statements = new ArrayList();
    private Date date;
    private String statment;

    public MessageDTO() {
    }
    
    
    
   private MessageDTO(int statementid,Date date, String statment){
        this.date = date;
        this.statment= statment;
        this.statementid =statementid;
        
        
    }
    
    public void setStatment(Date date, String statment){ 
        this.statementid = nextid++;
        statements.add(new MessageDTO(statementid,date,statment));
    }
        
   public Collection<MessageDTO> getStatments(){
        return statements;
    }

    
    public int getStatementid() {
        return statementid;
    }
    
    
    @Override
    public String toString() {
        return "Statement{" + "statementid=" + statementid + ", statements=" + statements + ", date=" + date + ", statment=" + statment + '}';
    }
    
    
    
}
