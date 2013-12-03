/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.*;

/**
 *
 * @author Andrew
 */
public class DBConnection {
    private Connection con;
    private static DBConnection instance;

    private DBConnection() {
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", "cphkm9", "cphkm9");
        }
        catch (Exception e) {
            System.out.println("error in Connection");
            System.out.println(e);
        }
        
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection getCurrentConnection() {
        if (getInstance() != null) {
            return con;
        }
        else {
            return null;
        }
    }
    
    public void closeConnection(){
        DBConnection.getInstance().closeConnection();
    }
    
}
