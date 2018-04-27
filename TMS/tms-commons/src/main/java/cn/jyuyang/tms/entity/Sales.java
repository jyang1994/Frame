package cn.jyuyang.tms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sales
 * @author 
 */
public class Sales implements Serializable {
    private Customer customer;

    private Integer id;

    private Integer saleStoreId;

    private String saleTicketNum;

    private Date createTime;

    private BigDecimal salePrice;

    private String saleState;

    private Integer customerId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleStoreId() {
        return saleStoreId;
    }

    public void setSaleStoreId(Integer saleStoreId) {
        this.saleStoreId = saleStoreId;
    }

    public String getSaleTicketNum() {
        return saleTicketNum;
    }

    public void setSaleTicketNum(String saleTicketNum) {
        this.saleTicketNum = saleTicketNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSaleState() {
        return saleState;
    }

    public void setSaleState(String saleState) {
        this.saleState = saleState;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        Sales other = (Sales) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSaleStoreId() == null ? other.getSaleStoreId() == null : this.getSaleStoreId().equals(other.getSaleStoreId()))
            && (this.getSaleTicketNum() == null ? other.getSaleTicketNum() == null : this.getSaleTicketNum().equals(other.getSaleTicketNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getSaleState() == null ? other.getSaleState() == null : this.getSaleState().equals(other.getSaleState()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSaleStoreId() == null) ? 0 : getSaleStoreId().hashCode());
        result = prime * result + ((getSaleTicketNum() == null) ? 0 : getSaleTicketNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getSaleState() == null) ? 0 : getSaleState().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleStoreId=").append(saleStoreId);
        sb.append(", saleTicketNum=").append(saleTicketNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", saleState=").append(saleState);
        sb.append(", customerId=").append(customerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}