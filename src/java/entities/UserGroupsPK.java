/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andrew
 */
@Embeddable
public class UserGroupsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_ROLL")
    private String userRoll;

    public UserGroupsPK() {
    }

    public UserGroupsPK(String userEmail, String userRoll) {
        this.userEmail = userEmail;
        this.userRoll = userRoll;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRoll() {
        return userRoll;
    }

    public void setUserRoll(String userRoll) {
        this.userRoll = userRoll;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userEmail != null ? userEmail.hashCode() : 0);
        hash += (userRoll != null ? userRoll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroupsPK)) {
            return false;
        }
        UserGroupsPK other = (UserGroupsPK) object;
        if ((this.userEmail == null && other.userEmail != null) || (this.userEmail != null && !this.userEmail.equals(other.userEmail))) {
            return false;
        }
        if ((this.userRoll == null && other.userRoll != null) || (this.userRoll != null && !this.userRoll.equals(other.userRoll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroupsPK[ userEmail=" + userEmail + ", userRoll=" + userRoll + " ]";
    }
    
}
