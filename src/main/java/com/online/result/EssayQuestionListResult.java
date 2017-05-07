package com.online.result;

import com.online.domain.EssayQuestionDO;

import java.util.List;

/**
 * Created by panlu02 on 2017/4/30.
 */
public class EssayQuestionListResult {
    private Integer total;
    private List<EssayQuestionDO> essayQuestionDOList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<EssayQuestionDO> getEssayQuestionDOList() {
        return essayQuestionDOList;
    }

    public void setEssayQuestionDOList(List<EssayQuestionDO> essayQuestionDOList) {
        this.essayQuestionDOList = essayQuestionDOList;
    }
}
