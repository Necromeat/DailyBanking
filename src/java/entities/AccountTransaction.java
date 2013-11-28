/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.*;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "ACCOUNT_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountTransaction.findAll", query = "SELECT a FROM AccountTransaction a"),
    @NamedQuery(name = "AccountTransaction.findByAccountId", query = "SELECT a FROM AccountTransaction a WHERE a.accountTransactionPK.accountId = :accountId"),
    @NamedQuery(name = "AccountTransaction.findByTransactionId", query = "SELECT a FROM AccountTransaction a WHERE a.accountTransactionPK.transactionId = :transactionId"),
    @NamedQuery(name = "AccountTransaction.findByTypeOf", query = "SELECT a FROM AccountTransaction a WHERE a.typeOf = :typeOf"),
    @NamedQuery(name = "AccountTransaction.findByAmount", query = "SELECT a FROM AccountTransaction a WHERE a.amount = :amount"),
    @NamedQuery(name = "AccountTransaction.findByMessage", query = "SELECT a FROM AccountTransaction a WHERE a.message = :message")})
public class AccountTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountTransactionPK accountTransactionPK;
    @Size(max = 50)
    @Column(name = "TYPE_OF")
    private String typeOf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private double amount;
    @Size(max = 50)
    @Column(name = "MESSAGE")
    private String message;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AccountType accountType;

    public AccountTransaction() {
    }

    public AccountTransaction(AccountTransactionPK accountTransactionPK) {
        this.accountTransactionPK = accountTransactionPK;
    }

    public AccountTransaction(long accountId, long transactionId) {
        this.accountTransactionPK = new AccountTransactionPK(accountId, transactionId);
    }

    public AccountTransactionPK getAccountTransactionPK() {
        return accountTransactionPK;
    }

    public void setAccountTransactionPK(AccountTransactionPK accountTransactionPK) {
        this.accountTransactionPK = accountTransactionPK;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        hash += (accountTransactionPK != null ? accountTransactionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountTransaction)) {
            return false;
        }
        AccountTransaction other = (AccountTransaction) object;
        if ((this.accountTransactionPK == null && other.accountTransactionPK != null) || (this.accountTransactionPK != null && !this.accountTransactionPK.equals(other.accountTransactionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountTransaction[ accountTransactionPK=" + accountTransactionPK + " ]";
    }
    
}
