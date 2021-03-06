package com.safewind.model;

public class User {
    private Integer id;

    private String realName;

    private String phoneNumber;

    private String password;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.getId().equals(user.getId()) && this.getEmail().equals(user.getEmail()) && this.getPhoneNumber().equals(user.getPhoneNumber()) && this.getRealName().equals(user.getRealName()) && this.getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return realName.hashCode();
    }
}