/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "USER_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
    @NamedQuery(name = "UserType.findByUserId", query = "SELECT u FROM UserType u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserType.findByUserType", query = "SELECT u FROM UserType u WHERE u.userType = :userType")})
public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private long userId;
    @Size(max = 30)
    @Column(name = "USER_TYPE")
    private String userType;
    @OneToMany(mappedBy = "userId")
    private Collection<CustomerDetail> customerDetailCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userType")
    private UserGroups userGroups;
    @OneToMany(mappedBy = "userId")
    private Collection<UserDetail> userDetailCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userType")
    private EmployeeDetail employeeDetail;

    public UserType() {
    }

    public UserType(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @XmlTransient
    public Collection<CustomerDetail> getCustomerDetailCollection() {
        return customerDetailCollection;
    }

    public void setCustomerDetailCollection(Collection<CustomerDetail> customerDetailCollection) {
        this.customerDetailCollection = customerDetailCollection;
    }

    public UserGroups getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(UserGroups userGroups) {
        this.userGroups = userGroups;
    }

    @XmlTransient
    public Collection<UserDetail> getUserDetailCollection() {
        return userDetailCollection;
    }

    public void setUserDetailCollection(Collection<UserDetail> userDetailCollection) {
        this.userDetailCollection = userDetailCollection;
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
//        if (!(object instanceof UserType)) {
//            return false;
//        }
//        UserType other = (UserType) object;
//        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entities.UserType[ userId=" + userId + " ]";
    }
    
}
