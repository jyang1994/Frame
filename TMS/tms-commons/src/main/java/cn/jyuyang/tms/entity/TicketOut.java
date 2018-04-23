package cn.jyuyang.tms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ticket_out
 * @author 
 */
public class TicketOut implements Serializable {
    public static final  String TICKET_PAY="已支付";
    public static final  String NO_TICKET_PAY="未支付";
    private Integer id;

    private Date outTime;

    private String outStore;

    private String content;

    private Integer outNum;

    private String outStartTicket;

    private String outEndTicket;

    private BigDecimal onePrice;

    private BigDecimal totalPrice;

    private String outState;

    /**
     * 下发人
     */
    private String outAccount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOutStore() {
        return outStore;
    }

    public void setOutStore(String outStore) {
        this.outStore = outStore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOutNum() {
        return outNum;
    }

    public void setOutNum(Integer outNum) {
        this.outNum = outNum;
    }

    public String getOutStartTicket() {
        return outStartTicket;
    }

    public void setOutStartTicket(String outStartTicket) {
        this.outStartTicket = outStartTicket;
    }

    public String getOutEndTicket() {
        return outEndTicket;
    }

    public void setOutEndTicket(String outEndTicket) {
        this.outEndTicket = outEndTicket;
    }

    public BigDecimal getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(BigDecimal onePrice) {
        this.onePrice = onePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOutState() {
        return outState;
    }

    public void setOutState(String outState) {
        this.outState = outState;
    }

    public String getOutAccount() {
        return outAccount;
    }

    public void setOutAccount(String outAccount) {
        this.outAccount = outAccount;
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
        TicketOut other = (TicketOut) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOutTime() == null ? other.getOutTime() == null : this.getOutTime().equals(other.getOutTime()))
            && (this.getOutStore() == null ? other.getOutStore() == null : this.getOutStore().equals(other.getOutStore()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getOutNum() == null ? other.getOutNum() == null : this.getOutNum().equals(other.getOutNum()))
            && (this.getOutStartTicket() == null ? other.getOutStartTicket() == null : this.getOutStartTicket().equals(other.getOutStartTicket()))
            && (this.getOutEndTicket() == null ? other.getOutEndTicket() == null : this.getOutEndTicket().equals(other.getOutEndTicket()))
            && (this.getOnePrice() == null ? other.getOnePrice() == null : this.getOnePrice().equals(other.getOnePrice()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getOutState() == null ? other.getOutState() == null : this.getOutState().equals(other.getOutState()))
            && (this.getOutAccount() == null ? other.getOutAccount() == null : this.getOutAccount().equals(other.getOutAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOutTime() == null) ? 0 : getOutTime().hashCode());
        result = prime * result + ((getOutStore() == null) ? 0 : getOutStore().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getOutNum() == null) ? 0 : getOutNum().hashCode());
        result = prime * result + ((getOutStartTicket() == null) ? 0 : getOutStartTicket().hashCode());
        result = prime * result + ((getOutEndTicket() == null) ? 0 : getOutEndTicket().hashCode());
        result = prime * result + ((getOnePrice() == null) ? 0 : getOnePrice().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getOutState() == null) ? 0 : getOutState().hashCode());
        result = prime * result + ((getOutAccount() == null) ? 0 : getOutAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", outTime=").append(outTime);
        sb.append(", outStore=").append(outStore);
        sb.append(", content=").append(content);
        sb.append(", outNum=").append(outNum);
        sb.append(", outStartTicket=").append(outStartTicket);
        sb.append(", outEndTicket=").append(outEndTicket);
        sb.append(", onePrice=").append(onePrice);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", outState=").append(outState);
        sb.append(", outAccount=").append(outAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}