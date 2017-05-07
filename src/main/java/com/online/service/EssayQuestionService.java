package com.online.service;

import com.online.domain.EssayQuestionDO;
import com.online.result.EssayQuestionListResult;

import java.io.IOException;

/**
 * Created by panlu02 on 2017/4/30.
 */
public interface EssayQuestionService {
    void saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException;
    EssayQuestionDO getEssayQuestionById(Long essayQuestionId);
    EssayQuestionListResult getEssayQuestionList();

    void deleteEssayQuestionByOrderNumber(Integer orderNumber) throws IOException;
}
