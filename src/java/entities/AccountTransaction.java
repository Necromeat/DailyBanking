/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ACCOUNT_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountTransaction.findAll", query = "SELECT a FROM AccountTransaction a"),
    @NamedQuery(name = "AccountTransaction.findByTransactionId", query = "SELECT a FROM AccountTransaction a WHERE a.transactionId = :transactionId"),
    @NamedQuery(name = "AccountTransaction.findByTypeOf", query = "SELECT a FROM AccountTransaction a WHERE a.typeOf = :typeOf"),
    @NamedQuery(name = "AccountTransaction.findByAmount", query = "SELECT a FROM AccountTransaction a WHERE a.amount = :amount"),
    @NamedQuery(name = "AccountTransaction.findByMessage", query = "SELECT a FROM AccountTransaction a WHERE a.message = :message")})
public class AccountTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private long transactionId;
    @Size(max = 50)
    @Column(name = "TYPE_OF")
    private String typeOf;
    @Column(name = "AMOUNT")
    private double amount;
    @Size(max = 50)
    @Column(name = "MESSAGE")
    private String message;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private AccountType accountId;

    public AccountTransaction() {
    }

    public AccountTransaction(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
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

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AccountType getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountType accountId) {
        this.accountId = accountId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (transactionId != null ? transactionId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof AccountTransaction)) {
//            return false;
//        }
//        AccountTransaction other = (AccountTransaction) object;
//        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entities.AccountTransaction[ transactionId=" + transactionId + " ]";
    }
    
}
