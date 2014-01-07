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
@Table(name = "EMPLOYEE_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeDetail.findAll", query = "SELECT e FROM EmployeeDetail e"),
    @NamedQuery(name = "EmployeeDetail.findByUserId", query = "SELECT e FROM EmployeeDetail e WHERE e.userId = :userId"),
    @NamedQuery(name = "EmployeeDetail.findByFname", query = "SELECT e FROM EmployeeDetail e WHERE e.fname = :fname"),
    @NamedQuery(name = "EmployeeDetail.findByLname", query = "SELECT e FROM EmployeeDetail e WHERE e.lname = :lname"),
    @NamedQuery(name = "EmployeeDetail.findByDepartmentId", query = "SELECT e FROM EmployeeDetail e WHERE e.departmentId = :departmentId"),
    @NamedQuery(name = "EmployeeDetail.findByPhone", query = "SELECT e FROM EmployeeDetail e WHERE e.phone = :phone")})
public class EmployeeDetail implements Serializable {
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
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @Column(name = "PHONE")
    private BigInteger phone;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public EmployeeDetail() {
    }

    public EmployeeDetail(long userId) {
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

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
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
        if (!(object instanceof EmployeeDetail)) {
            return false;
        }
        EmployeeDetail other = (EmployeeDetail) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EmployeeDetail[ userId=" + userId + " ]";
    }
    
}
