package model;

import java.io.Serializable;

/**
 * Created by shahriar on 12/12/14.
 */
public class UserInfo implements Serializable{
    private String name, address, email;
    private int id, phone;

    public UserInfo() {
        name = "";
        address = "";
        email = "";
        id = 0;
        phone = 0;
    }

    public UserInfo(int id, String name, String address, int phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public UserInfo(String name, String address, int phone, String email) {

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (phone != userInfo.phone) return false;
        if (!address.equals(userInfo.address)) return false;
        if (!email.equals(userInfo.email)) return false;
        if (!name.equals(userInfo.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + id;
        result = 31 * result + phone;
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", phone=" + phone +
                '}';
    }
}
