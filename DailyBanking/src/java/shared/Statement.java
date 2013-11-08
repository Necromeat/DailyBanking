
package shared;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class Statement {
    private int statementid=0;
    private Map<Integer,Statement> statements = new HashMap();
    private Date date;
    private String statment;
    public Statement(Date date, String statment){
        this.date = date;
        this.statment= statment;
    }
    
    public void setStatment(Date date, String statment){
        statements.put(statementid,new Statement(date,statment));
    }
    public Statement getStatment(int statementid){
        
        return statements.get(statementid);
    }
    
    Map<Integer,Statement> getStatments(){
        return statements;
    }
    
}
