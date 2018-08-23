package com.anuradha.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    private int user_id;
    private String name;
    private String email;
    private String position;
    private String contact_no;
    private String user_role;
    private String password;
    private String encPassword;
    private String salt;
    private String token;
    private String imgUrl;
    private String addedDate;
    private int UserToken;
    private int provider;

    public User() {

    }

    public User(int user_id, String name, String email, String position, String contact_no, String user_role, String password, String encPassword, String salt, String token, String imgUrl, String addedDate, int userToken, int provider) {
        this.setUser_id(user_id);
        this.setName(name);
        this.setEmail(email);
        this.setPosition(position);
        this.setContact_no(contact_no);
        this.setUser_role(user_role);
        this.setPassword(password);
        this.setEncPassword(encPassword);
        this.setSalt(salt);
        this.setToken(token);
        this.setImgUrl(imgUrl);
        this.setAddedDate(addedDate);
        setUserToken(userToken);
        this.setProvider(provider);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", user_role='" + user_role + '\'' +
                ", password='" + password + '\'' +
                ", encPassword='" + encPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", token='" + token + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", addedDate='" + addedDate + '\'' +
                ", UserToken=" + UserToken +
                ", provider=" + provider +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncPassword() {
        return encPassword;
    }

    public void setEncPassword(String encPassword) {
        this.encPassword = encPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public int getUserToken() {
        return UserToken;
    }

    public void setUserToken(int userToken) {
        UserToken = userToken;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }
}
