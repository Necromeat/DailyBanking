/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "CUSTOMER_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDetail.findAll", query = "SELECT c FROM CustomerDetail c"),
    @NamedQuery(name = "CustomerDetail.findByUserId", query = "SELECT c FROM CustomerDetail c WHERE c.userId = :userId"),
    @NamedQuery(name = "CustomerDetail.findByFname", query = "SELECT c FROM CustomerDetail c WHERE c.fname = :fname"),
    @NamedQuery(name = "CustomerDetail.findByLname", query = "SELECT c FROM CustomerDetail c WHERE c.lname = :lname"),
    @NamedQuery(name = "CustomerDetail.findByUserEmail", query = "SELECT c FROM CustomerDetail c WHERE c.userEmail = :userEmail")})
public class CustomerDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Size(max = 50)
    @Column(name = "FNAME")
    private String fname;
    @Size(max = 50)
    @Column(name = "LNAME")
    private String lname;
    @Size(max = 50)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public CustomerDetail() {
    }

    public CustomerDetail(long userId) {
        this.userId = BigInteger.valueOf(userId);
    }

    public long getUserId() {
        String temp = ""+userId;
        return Long.parseLong(temp);
    }

    public void setUserId(long userId) {
        this.userId = BigInteger.valueOf(userId);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDetail)) {
            return false;
        }
        CustomerDetail other = (CustomerDetail) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerDetail[ userId=" + userId + " ]";
    }
    
}
