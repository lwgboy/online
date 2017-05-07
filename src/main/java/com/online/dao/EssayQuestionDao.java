package com.online.dao;

import com.online.domain.EssayQuestionDO;

import java.io.IOException;

/**
 * Created by panlu02 on 2017/5/6.
 */
public interface EssayQuestionDao {

    int saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException;

    void deleteEssayQuestionByOrderNumber(Integer orderNumber) throws IOException;
}
