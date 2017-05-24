package com.online.domain;

/**
 * Created by panlu02 on 2017/5/17.
 */
public class UserProgrameAssoDO {
    private Integer id;
    private Integer userId;
    private Integer questionId;
    private String codeResult;
    private String runResult;

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

    public String getRunResult() {
        return runResult;
    }

    public void setRunResult(String runResult) {
        this.runResult = runResult;
    }

    @Override
    public String toString() {
        return "UserProgrameAssoDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", codeResult='" + codeResult + '\'' +
                ", runResult='" + runResult + '\'' +
                '}';
    }
}
