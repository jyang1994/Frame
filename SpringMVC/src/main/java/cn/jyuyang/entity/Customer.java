package cn.jyuyang.entity;

public class Customer {
    private Integer id;
    private String name;
    private String address;

    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public java.lang.String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                '}';
    }
}
