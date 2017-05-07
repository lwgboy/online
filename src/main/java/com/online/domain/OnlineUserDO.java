package com.online.domain;

/**
 * Created by panlu02 on 2017/4/29.
 */
public class OnlineUserDO {
    private Long userId;
    private String userName;
    private String studentNumber;
    private String classNo;
    private String telephone;
    private String password;
    private Integer type;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OnlineUserDO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", classNo='" + classNo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
