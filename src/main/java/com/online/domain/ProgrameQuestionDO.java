package com.online.domain;

/**
 * Created by panlu02 on 2017/5/16.
 */
public class ProgrameQuestionDO {
    private Long id;
    private Integer orderNumber;
    private String question;      //小标题描述
    private String description;
    private String inputDescription;
    private String outputDescription;
    private String inputData;
    private String outputData;
    private Long ctime;
    private Long utime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    public String getOutputDescription() {
        return outputDescription;
    }

    public void setOutputDescription(String outputDescription) {
        this.outputDescription = outputDescription;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getOutputData() {
        return outputData;
    }

    public void setOutputData(String outputData) {
        this.outputData = outputData;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "ProgrameQuestionDO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", question='" + question + '\'' +
                ", description='" + description + '\'' +
                ", inputDescription='" + inputDescription + '\'' +
                ", outputDescription='" + outputDescription + '\'' +
                ", inputData='" + inputData + '\'' +
                ", outputData='" + outputData + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                '}';
    }
}
