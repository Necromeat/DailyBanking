/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrew
 */
@Embeddable
public class AccountDetailPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    private BigInteger accountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigInteger userId;

    public AccountDetailPK() {
    }

    public AccountDetailPK(long accountId, long userId) {
        this.accountId = BigInteger.valueOf(accountId);
        this.userId = BigInteger.valueOf(userId);
    }

    public long getAccountId() {
        String temp = ""+accountId;
        return Long.parseLong(temp);
    }

    public void setAccountId(long accountId) {
        this.accountId = BigInteger.valueOf(accountId);
    }

    public long getUserId() {
         String temp = ""+userId;
        return Long.parseLong(temp); 
    }

    public void setUserId(long userId) {
        this.userId = BigInteger.valueOf(userId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetailPK)) {
            return false;
        }
        AccountDetailPK other = (AccountDetailPK) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountDetailPK[ accountId=" + accountId + ", userId=" + userId + " ]";
    }
    
}
