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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "ACCOUNT_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDetail.findAll", query = "SELECT a FROM AccountDetail a"),
    @NamedQuery(name = "AccountDetail.findByAccountId", query = "SELECT a FROM AccountDetail a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "AccountDetail.findByCustomerId", query = "SELECT a FROM AccountDetail a WHERE a.customerId = :customerId"),
    @NamedQuery(name = "AccountDetail.findByBalance", query = "SELECT a FROM AccountDetail a WHERE a.balance = :balance")})
public class AccountDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    private long accountId;
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    @Column(name = "BALANCE")
    private long balance;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AccountType accountType;

    public AccountDetail() {
    }

    public AccountDetail(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (accountId != null ? accountId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof AccountDetail)) {
//            return false;
//        }
//        AccountDetail other = (AccountDetail) object;
//        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entities.AccountDetail[ accountId=" + accountId + " ]";
    }
    
}
