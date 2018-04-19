package cn.jyuyang.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * store_sticket
 * @author 
 */
public class StoreSticket implements Serializable {
    public static final String STORE_STATE_NORMAl="正常";
    public static final String STORE_STATE_DISABLE="禁用";

    private Integer id;

    /**
     * 法人
     */
    private String managerName;

    private String managerMobile;

    /**
     * 售票点名称
     */
    private String storeName;

    /**
     * 售票点地址
     */
    private String ticketStoreAddress;

    private String businessLicensePhoto;

    private String managerCard;

    /**
     * 法人身份证照片
     */
    private String managerCardBefore;

    private Date createTime;

    private Date updateTime;

    /**
     * 售票点登录帐号
     */
    private Integer accountId;

    /**
     * 经度
     */
    private String storeLongitude;

    /**
     * 售票点维度
     */
    private String storeLatitude;

    /**
     * 法人身份反面照片
     */
    private String managerCardAfter;

    /**
     * 售票点状态
     */
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTicketStoreAddress() {
        return ticketStoreAddress;
    }

    public void setTicketStoreAddress(String ticketStoreAddress) {
        this.ticketStoreAddress = ticketStoreAddress;
    }

    public String getBusinessLicensePhoto() {
        return businessLicensePhoto;
    }

    public void setBusinessLicensePhoto(String businessLicensePhoto) {
        this.businessLicensePhoto = businessLicensePhoto;
    }

    public String getManagerCard() {
        return managerCard;
    }

    public void setManagerCard(String managerCard) {
        this.managerCard = managerCard;
    }

    public String getManagerCardBefore() {
        return managerCardBefore;
    }

    public void setManagerCardBefore(String managerCardBefore) {
        this.managerCardBefore = managerCardBefore;
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getStoreLongitude() {
        return storeLongitude;
    }

    public void setStoreLongitude(String storeLongitude) {
        this.storeLongitude = storeLongitude;
    }

    public String getStoreLatitude() {
        return storeLatitude;
    }

    public void setStoreLatitude(String storeLatitude) {
        this.storeLatitude = storeLatitude;
    }

    public String getManagerCardAfter() {
        return managerCardAfter;
    }

    public void setManagerCardAfter(String managerCardAfter) {
        this.managerCardAfter = managerCardAfter;
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
        StoreSticket other = (StoreSticket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getManagerName() == null ? other.getManagerName() == null : this.getManagerName().equals(other.getManagerName()))
            && (this.getManagerMobile() == null ? other.getManagerMobile() == null : this.getManagerMobile().equals(other.getManagerMobile()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getTicketStoreAddress() == null ? other.getTicketStoreAddress() == null : this.getTicketStoreAddress().equals(other.getTicketStoreAddress()))
            && (this.getBusinessLicensePhoto() == null ? other.getBusinessLicensePhoto() == null : this.getBusinessLicensePhoto().equals(other.getBusinessLicensePhoto()))
            && (this.getManagerCard() == null ? other.getManagerCard() == null : this.getManagerCard().equals(other.getManagerCard()))
            && (this.getManagerCardBefore() == null ? other.getManagerCardBefore() == null : this.getManagerCardBefore().equals(other.getManagerCardBefore()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getStoreLongitude() == null ? other.getStoreLongitude() == null : this.getStoreLongitude().equals(other.getStoreLongitude()))
            && (this.getStoreLatitude() == null ? other.getStoreLatitude() == null : this.getStoreLatitude().equals(other.getStoreLatitude()))
            && (this.getManagerCardAfter() == null ? other.getManagerCardAfter() == null : this.getManagerCardAfter().equals(other.getManagerCardAfter()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getManagerName() == null) ? 0 : getManagerName().hashCode());
        result = prime * result + ((getManagerMobile() == null) ? 0 : getManagerMobile().hashCode());
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getTicketStoreAddress() == null) ? 0 : getTicketStoreAddress().hashCode());
        result = prime * result + ((getBusinessLicensePhoto() == null) ? 0 : getBusinessLicensePhoto().hashCode());
        result = prime * result + ((getManagerCard() == null) ? 0 : getManagerCard().hashCode());
        result = prime * result + ((getManagerCardBefore() == null) ? 0 : getManagerCardBefore().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getStoreLongitude() == null) ? 0 : getStoreLongitude().hashCode());
        result = prime * result + ((getStoreLatitude() == null) ? 0 : getStoreLatitude().hashCode());
        result = prime * result + ((getManagerCardAfter() == null) ? 0 : getManagerCardAfter().hashCode());
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
        sb.append(", storeName=").append(storeName);
        sb.append(", ticketStoreAddress=").append(ticketStoreAddress);
        sb.append(", businessLicensePhoto=").append(businessLicensePhoto);
        sb.append(", managerCard=").append(managerCard);
        sb.append(", managerCardBefore=").append(managerCardBefore);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", accountId=").append(accountId);
        sb.append(", storeLongitude=").append(storeLongitude);
        sb.append(", storeLatitude=").append(storeLatitude);
        sb.append(", managerCardAfter=").append(managerCardAfter);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}