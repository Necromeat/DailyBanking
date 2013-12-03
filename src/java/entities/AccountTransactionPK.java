/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrew
 */
@Embeddable
public class AccountTransactionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    private long accountId;
    @Basic(optional = false)
    @NotNull
    
    @GeneratedValue(strategy = GenerationType.AUTO,generator="my_seq2")
    @SequenceGenerator(name="my_seq2",sequenceName="seq_transaction_id")
    @Column(name = "TRANSACTION_ID")
    private long transactionId;

    public AccountTransactionPK() {
    }

    public AccountTransactionPK(long accountId, long transactionId) {
        this.accountId = accountId;
        this.transactionId = transactionId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (accountId != null ? accountId.hashCode() : 0);
//        hash += (transactionId != null ? transactionId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof AccountTransactionPK)) {
//            return false;
//        }
//        AccountTransactionPK other = (AccountTransactionPK) object;
//        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
//            return false;
//        }
//        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entities.AccountTransactionPK[ accountId=" + accountId + ", transactionId=" + transactionId + " ]";
    }
    
}
