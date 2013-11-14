/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Andrew
 */
public class UserDTO implements Serializable {
    private String fname;
    private String lname;
    private String email;
    private long id;

    public UserDTO(String fname, String lname, String email, long id) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.id = id;
    }

    public UserDTO() {
    }

    public String getUserFname() {
        return fname;
    }

    public void setUserFname(String fname) {
        this.fname = fname;
    }

    public String getUserLname() {
        return lname;
    }

    public void setUserLname(String lname) {
        this.lname = lname;
    }

    public String getUserEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    
    
    
    
    
    
}
