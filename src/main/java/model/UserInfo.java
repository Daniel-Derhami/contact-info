package model;


import utils.validators.UserValidator;

import java.io.Serializable;

/**
 * Created by shahriar on 12/12/14.
 */
public class UserInfo implements Serializable{
    private String name;
    private String address;
    private String email;
    private Integer id;
    private Integer phone;

    public UserInfo() {
        setName("");
        address = "";
        email = "";
        setId(0);
        phone = 0;
    }

    public UserInfo(int id, String name, String address, int phone, String email) {
        this.setId(id);
        this.setName(name);
        this.address = address;
        this.phone = phone;
        this.setEmail(email);


    }

    public UserInfo(String name, String address, int phone, String email) {

        this.setName(name);
        this.address = address;
        this.phone = phone;
        this.setEmail(email);
    }

        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (UserValidator.validateEmail(email)){
            this.email = email;
        }else{
           // throw new UserInfoException(new Exception("email format is not correct"));
        }
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (getId() != userInfo.getId()) return false;
        else if (phone != userInfo.phone) return false;
        else if (!address.equals(userInfo.address)) return false;
        else if (!email.equals(userInfo.email)) return false;
        else if (!getName().equals(userInfo.getName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + getId();
        result = 31 * result + phone;
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + getName() + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", id=" + getId() +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
