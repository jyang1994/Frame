package cn.jyuyang.tms.entity;

import java.io.Serializable;

/**
 * customer_photo
 * @author 
 */
public class CustomerPhoto implements Serializable {
    private Integer id;

    private String cardBefore;

    private String cardAfter;

    private String personPhoto;

    private Integer customerId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardBefore() {
        return cardBefore;
    }

    public void setCardBefore(String cardBefore) {
        this.cardBefore = cardBefore;
    }

    public String getCardAfter() {
        return cardAfter;
    }

    public void setCardAfter(String cardAfter) {
        this.cardAfter = cardAfter;
    }

    public String getPersonPhoto() {
        return personPhoto;
    }

    public void setPersonPhoto(String personPhoto) {
        this.personPhoto = personPhoto;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
        CustomerPhoto other = (CustomerPhoto) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCardBefore() == null ? other.getCardBefore() == null : this.getCardBefore().equals(other.getCardBefore()))
            && (this.getCardAfter() == null ? other.getCardAfter() == null : this.getCardAfter().equals(other.getCardAfter()))
            && (this.getPersonPhoto() == null ? other.getPersonPhoto() == null : this.getPersonPhoto().equals(other.getPersonPhoto()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCardBefore() == null) ? 0 : getCardBefore().hashCode());
        result = prime * result + ((getCardAfter() == null) ? 0 : getCardAfter().hashCode());
        result = prime * result + ((getPersonPhoto() == null) ? 0 : getPersonPhoto().hashCode());
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
        sb.append(", cardBefore=").append(cardBefore);
        sb.append(", cardAfter=").append(cardAfter);
        sb.append(", personPhoto=").append(personPhoto);
        sb.append(", customerId=").append(customerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}