package cn.jyuyang.entity;

public class User {
    private Integer id;
    private String userName;
    private String address;
    private String tel;
    public User() {
    }

    public User(String userName, String address, String tel) {
        this.userName = userName;
        this.address = address;
        this.tel = tel;
    }

    public User(Integer id, String userName, String address, String tel) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
