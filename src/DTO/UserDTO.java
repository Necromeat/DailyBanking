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
    private String pw;
    private String email;
    private long id;

    public UserDTO(String email, long id,String pw) {
        this.email = email;
        this.id = id;
        this.pw = pw;
    }

    public UserDTO() {
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
    
    
    
    
}
