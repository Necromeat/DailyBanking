/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ACCOUNT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountType.findAll", query = "SELECT a FROM AccountType a"),
    @NamedQuery(name = "AccountType.findByAccountId", query = "SELECT a FROM AccountType a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "AccountType.findByAccountType", query = "SELECT a FROM AccountType a WHERE a.accountType = :accountType")})
public class AccountType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    
    @GeneratedValue(strategy = GenerationType.AUTO,generator="my_seq1")
    @SequenceGenerator(name="my_seq1",sequenceName="seq_account_id")
    @Column(name = "ACCOUNT_ID")
    private BigInteger accountId;
    @Size(max = 30)
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountType")
    private Collection<AccountDetail> accountDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountType")
    private Collection<AccountTransaction> accountTransactionCollection;

    public AccountType() {
    }

    public AccountType(long accountId) {
        this.accountId = BigInteger.valueOf(accountId);
    }

    public long getAccountId() {
        String temp = ""+accountId;
        return Long.parseLong(temp);
    }

    public void setAccountId(long accountId) {
        this.accountId = BigInteger.valueOf(accountId);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @XmlTransient
    public Collection<AccountDetail> getAccountDetailCollection() {
        return accountDetailCollection;
    }

    public void setAccountDetailCollection(Collection<AccountDetail> accountDetailCollection) {
        this.accountDetailCollection = accountDetailCollection;
    }

    @XmlTransient
    public Collection<AccountTransaction> getAccountTransactionCollection() {
        return accountTransactionCollection;
    }

    public void setAccountTransactionCollection(Collection<AccountTransaction> accountTransactionCollection) {
        this.accountTransactionCollection = accountTransactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountType)) {
            return false;
        }
        AccountType other = (AccountType) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountType[ accountId=" + accountId + " ]";
    }
    
}
