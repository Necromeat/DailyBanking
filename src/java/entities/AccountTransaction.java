/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "AccountTransaction.findByAmount", query = "SELECT a FROM AccountTransaction a WHERE a.amount = :amount"),
    @NamedQuery(name = "AccountTransaction.findByTransactionTime", query = "SELECT a FROM AccountTransaction a WHERE a.transactionTime = :transactionTime")})
public class AccountTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "TRANSACTION_TIME")
    @Temporal(TemporalType.DATE)
    private Date transactionTime;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account accountId;

    public AccountTransaction() {
    }

    public AccountTransaction(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountTransaction)) {
            return false;
        }
        AccountTransaction other = (AccountTransaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountTransaction[ transactionId=" + transactionId + " ]";
    }
    
}
