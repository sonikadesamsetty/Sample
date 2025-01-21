package com.app.sony.entity;

import com.app.sony.model.User;
import com.app.sony.util.RoleEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "role", nullable = false)
    private RoleEnum role;

    @Column(name = "address", nullable = false)
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(role, that.role) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, mobileNumber, role, address);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
