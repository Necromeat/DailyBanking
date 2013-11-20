/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CUSTOMER_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDetail.findAll", query = "SELECT c FROM CustomerDetail c"),
    @NamedQuery(name = "CustomerDetail.findByCustomerId", query = "SELECT c FROM CustomerDetail c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CustomerDetail.findByAddress", query = "SELECT c FROM CustomerDetail c WHERE c.address = :address"),
    @NamedQuery(name = "CustomerDetail.findByZip", query = "SELECT c FROM CustomerDetail c WHERE c.zip = :zip"),
    @NamedQuery(name = "CustomerDetail.findByRegion", query = "SELECT c FROM CustomerDetail c WHERE c.region = :region"),
    @NamedQuery(name = "CustomerDetail.findByPhone", query = "SELECT c FROM CustomerDetail c WHERE c.phone = :phone")})
public class CustomerDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 30)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 30)
    @Column(name = "REGION")
    private String region;
    @Column(name = "PHONE")
    private BigInteger phone;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserType userId;

    public CustomerDetail() {
    }

    public CustomerDetail(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public UserType getUserId() {
        return userId;
    }

    public void setUserId(UserType userId) {
        this.userId = userId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (customerId != null ? customerId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CustomerDetail)) {
//            return false;
//        }
//        CustomerDetail other = (CustomerDetail) object;
//        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entities.CustomerDetail[ customerId=" + customerId + " ]";
    }
    
}
