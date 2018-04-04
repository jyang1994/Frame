package cn.jyuyang.entity;

import java.math.BigDecimal;

public class KaoLa {
    private Integer id;
    private String productName;
    private BigDecimal price;
    private BigDecimal markerPrice;
    private  String place;
    private  Integer comment_num;
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarkerPrice() {
        return markerPrice;
    }

    public void setMarkerPrice(BigDecimal markerPrice) {
        this.markerPrice = markerPrice;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "KaoLa{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", markerPrice=" + markerPrice +
                ", place='" + place + '\'' +
                ", comment_num=" + comment_num +
                ", typeId=" + typeId +
                '}';
    }
}
