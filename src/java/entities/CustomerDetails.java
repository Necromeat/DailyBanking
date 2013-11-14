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
@Table(name = "CUSTOMER_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDetails.findAll", query = "SELECT c FROM CustomerDetails c"),
    @NamedQuery(name = "CustomerDetails.findById", query = "SELECT c FROM CustomerDetails c WHERE c.id = :id"),
    @NamedQuery(name = "CustomerDetails.findByAddress", query = "SELECT c FROM CustomerDetails c WHERE c.address = :address"),
    @NamedQuery(name = "CustomerDetails.findByZip", query = "SELECT c FROM CustomerDetails c WHERE c.zip = :zip"),
    @NamedQuery(name = "CustomerDetails.findByRegion", query = "SELECT c FROM CustomerDetails c WHERE c.region = :region"),
    @NamedQuery(name = "CustomerDetails.findByPhone", query = "SELECT c FROM CustomerDetails c WHERE c.phone = :phone")})
public class CustomerDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ZIP")
    private Integer zip;
    @Size(max = 50)
    @Column(name = "REGION")
    private String region;
    @Column(name = "PHONE")
    private Integer phone;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    public CustomerDetails() {
    }

    public CustomerDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDetails)) {
            return false;
        }
        CustomerDetails other = (CustomerDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerDetails[ id=" + id + " ]";
    }
    
}
