package cn.jyuyang.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * store_account
 * @author 
 */
public class StoreAccount implements Serializable {
    private Integer id;

    /**
     * 法人
     */
    private String managerName;

    private String managerMobile;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Integer storeSciketId;

    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStoreSciketId() {
        return storeSciketId;
    }

    public void setStoreSciketId(Integer storeSciketId) {
        this.storeSciketId = storeSciketId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        StoreAccount other = (StoreAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getManagerName() == null ? other.getManagerName() == null : this.getManagerName().equals(other.getManagerName()))
            && (this.getManagerMobile() == null ? other.getManagerMobile() == null : this.getManagerMobile().equals(other.getManagerMobile()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStoreSciketId() == null ? other.getStoreSciketId() == null : this.getStoreSciketId().equals(other.getStoreSciketId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getManagerName() == null) ? 0 : getManagerName().hashCode());
        result = prime * result + ((getManagerMobile() == null) ? 0 : getManagerMobile().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStoreSciketId() == null) ? 0 : getStoreSciketId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", managerName=").append(managerName);
        sb.append(", managerMobile=").append(managerMobile);
        sb.append(", password=").append(password);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", storeSciketId=").append(storeSciketId);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}