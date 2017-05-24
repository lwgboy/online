package com.online.service;

import com.online.domain.EssayQuestionDO;
import com.online.param.EssayQuestionParam;
import com.online.param.Paging;
import com.online.result.EssayQuestionListResult;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/4/30.
 */
public interface EssayQuestionService {
    int saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException;

    void deleteEssayQuestionById(EssayQuestionParam param) throws IOException;

    EssayQuestionDO getEssayQuestionById(Long essayQuestionId) throws IOException;

    List<EssayQuestionDO> getEssayQuestionList(EssayQuestionParam param) throws IOException;

    int updateEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException;
}
