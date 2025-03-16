package com.app.sony.entity;

import com.app.sony.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String mobileNumber;

    @Column
    private String address;

    @Column
    private User.RoleEnum role;

    public UserEntity() {
    }
    public UserEntity(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User.RoleEnum getRole() {
        return role;
    }

    public void setRole(User.RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(address, that.address) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, password, email, mobileNumber, address, role);
    }
}

