/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "AccountDetail.findByAccountId", query = "SELECT a FROM AccountDetail a WHERE a.accountDetailPK.accountId = :accountId"),
    @NamedQuery(name = "AccountDetail.findByUserId", query = "SELECT a FROM AccountDetail a WHERE a.accountDetailPK.userId = :userId"),
    @NamedQuery(name = "AccountDetail.findByBalance", query = "SELECT a FROM AccountDetail a WHERE a.balance = :balance")})
public class AccountDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountDetailPK accountDetailPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BALANCE")
    private double balance;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AccountType accountType;

    public AccountDetail() {
    }

    public AccountDetail(AccountDetailPK accountDetailPK) {
        this.accountDetailPK = accountDetailPK;
    }

    public AccountDetail(long accountId, long userId) {
        this.accountDetailPK = new AccountDetailPK(accountId, userId);
    }

    public AccountDetailPK getAccountDetailPK() {
        return accountDetailPK;
    }

    public void setAccountDetailPK(AccountDetailPK accountDetailPK) {
        this.accountDetailPK = accountDetailPK;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountDetailPK != null ? accountDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetail)) {
            return false;
        }
        AccountDetail other = (AccountDetail) object;
        if ((this.accountDetailPK == null && other.accountDetailPK != null) || (this.accountDetailPK != null && !this.accountDetailPK.equals(other.accountDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountDetail[ accountDetailPK=" + accountDetailPK + " ]";
    }
    
}
