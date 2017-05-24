package com.online.param;

/**
 * Created by panlu02 on 2017/5/17.
 */
public class QueryProgrameQuestionParam extends Paging{
    private Long timeBarrie;

    private Long programeQuestionId;

    public Long getTimeBarrie() {
        return timeBarrie;
    }

    public void setTimeBarrie(Long timeBarrie) {
        this.timeBarrie = timeBarrie;
    }

    public Long getProgrameQuestionId() {
        return programeQuestionId;
    }

    public void setProgrameQuestionId(Long programeQuestionId) {
        this.programeQuestionId = programeQuestionId;
    }
}
