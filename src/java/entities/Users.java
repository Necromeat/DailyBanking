/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.findByUserPw", query = "SELECT u FROM Users u WHERE u.userPw = :userPw")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    
    @SequenceGenerator(name="seq1",sequenceName= "seq_customer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq1")    
    @Column(name = "USER_ID")
    private long userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Size(max = 100)
    @Column(name = "USER_PW")
    private String userPw;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private CustomerDetail customerDetail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<AccountDetail> accountDetailCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private EmployeeDetail employeeDetail;

    public Users() {
    }

    public Users(long userId) {
        this.userId = userId;
    }

    public Users(long userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    @XmlTransient
    public Collection<AccountDetail> getAccountDetailCollection() {
        return accountDetailCollection;
    }

    public void setAccountDetailCollection(Collection<AccountDetail> accountDetailCollection) {
        this.accountDetailCollection = accountDetailCollection;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (userId != null ? userId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Users)) {
//            return false;
//        }
//        Users other = (Users) object;
//        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entities.Users[ userId=" + userId + " ]";
    }
    
}
