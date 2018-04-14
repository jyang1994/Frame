package cn.jyuyang.tms.entity;

import java.io.Serializable;
import java.util.List;

/**
 * account
 * @author 
 */
public class Account implements Serializable {
    public List<AccountRolesKey> getAccountRolesKeysList() {
        return accountRolesKeysList;
    }

    public void setAccountRolesKeysList(List<AccountRolesKey> accountRolesKeysList) {
        this.accountRolesKeysList = accountRolesKeysList;
    }

    /**
     * 查找对应的account-roles表
     */
    private List<AccountRolesKey> accountRolesKeysList ;

    private Integer id;

    private String username;

    private String password;

    private Integer accLock;

    private Integer disable;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccLock() {
        return accLock;
    }

    public void setAccLock(Integer accLock) {
        this.accLock = accLock;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Account other = (Account) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAccLock() == null ? other.getAccLock() == null : this.getAccLock().equals(other.getAccLock()))
            && (this.getDisable() == null ? other.getDisable() == null : this.getDisable().equals(other.getDisable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAccLock() == null) ? 0 : getAccLock().hashCode());
        result = prime * result + ((getDisable() == null) ? 0 : getDisable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", accLock=").append(accLock);
        sb.append(", disable=").append(disable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}