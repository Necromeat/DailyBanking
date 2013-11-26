/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "USER_GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroups.findAll", query = "SELECT u FROM UserGroups u"),
    @NamedQuery(name = "UserGroups.findByUserEmail", query = "SELECT u FROM UserGroups u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "UserGroups.findByUserRoll", query = "SELECT u FROM UserGroups u WHERE u.userRoll = :userRoll")})
public class UserGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_ROLL")
    private String userRoll;

    public UserGroups() {
    }

    public UserGroups(String userRoll) {
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
        hash += (userRoll != null ? userRoll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroups)) {
            return false;
        }
        UserGroups other = (UserGroups) object;
        if ((this.userRoll == null && other.userRoll != null) || (this.userRoll != null && !this.userRoll.equals(other.userRoll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroups[ userRoll=" + userRoll + " ]";
    }
    
}
