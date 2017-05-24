package com.online.domain;

/**
 * Created by panlu02 on 2017/5/16.
 */
public class UserEssayAssoDO {
    private Integer id;
    private Integer userId;
    private Integer questionId;
    private String codeResult;
    private String userAnswer;
    private String checkResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getCodeResult() {
        return codeResult;
    }

    public void setCodeResult(String codeResult) {
        this.codeResult = codeResult;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    @Override
    public String toString() {
        return "UserEssayAssoDO{" +
                "userId=" + userId +
                ", questionId=" + questionId +
                ", codeResult='" + codeResult + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                ", checkResult='" + checkResult + '\'' +
                '}';
    }
}
