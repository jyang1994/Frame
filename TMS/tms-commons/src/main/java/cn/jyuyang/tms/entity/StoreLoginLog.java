package cn.jyuyang.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * store_login_log
 * @author 
 */
public class StoreLoginLog implements Serializable {
    private Integer id;

    private String loginip;

    private String storeAccountMobile;

    /**
     * 售票点登陆日志
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public String getStoreAccountMobile() {
        return storeAccountMobile;
    }

    public void setStoreAccountMobile(String storeAccountMobile) {
        this.storeAccountMobile = storeAccountMobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        StoreLoginLog other = (StoreLoginLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginip() == null ? other.getLoginip() == null : this.getLoginip().equals(other.getLoginip()))
            && (this.getStoreAccountMobile() == null ? other.getStoreAccountMobile() == null : this.getStoreAccountMobile().equals(other.getStoreAccountMobile()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginip() == null) ? 0 : getLoginip().hashCode());
        result = prime * result + ((getStoreAccountMobile() == null) ? 0 : getStoreAccountMobile().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginip=").append(loginip);
        sb.append(", storeAccountMobile=").append(storeAccountMobile);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}