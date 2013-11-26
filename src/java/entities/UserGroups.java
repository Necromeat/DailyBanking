/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "UserGroups.findByUserEmail", query = "SELECT u FROM UserGroups u WHERE u.userGroupsPK.userEmail = :userEmail"),
    @NamedQuery(name = "UserGroups.findByUserRoll", query = "SELECT u FROM UserGroups u WHERE u.userGroupsPK.userRoll = :userRoll")})
public class UserGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserGroupsPK userGroupsPK;

    public UserGroups() {
    }

    public UserGroups(UserGroupsPK userGroupsPK) {
        this.userGroupsPK = userGroupsPK;
    }

    public UserGroups(String userEmail, String userRoll) {
        this.userGroupsPK = new UserGroupsPK(userEmail, userRoll);
    }

    public UserGroupsPK getUserGroupsPK() {
        return userGroupsPK;
    }

    public void setUserGroupsPK(UserGroupsPK userGroupsPK) {
        this.userGroupsPK = userGroupsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupsPK != null ? userGroupsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroups)) {
            return false;
        }
        UserGroups other = (UserGroups) object;
        if ((this.userGroupsPK == null && other.userGroupsPK != null) || (this.userGroupsPK != null && !this.userGroupsPK.equals(other.userGroupsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroups[ userGroupsPK=" + userGroupsPK + " ]";
    }
    
}
