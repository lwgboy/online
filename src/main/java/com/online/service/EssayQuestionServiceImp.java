package com.online.service;

import com.online.dao.EssayQuestionDao;
import com.online.domain.EssayQuestionDO;
import com.online.result.EssayQuestionListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by panlu02 on 2017/5/6.
 */
@Service
public class EssayQuestionServiceImp implements EssayQuestionService {

    @Autowired
    EssayQuestionDao essayQuestionDao;

    public void saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException {
        essayQuestionDao.saveEssayQuestion(essayQuestionDO);
    }

    public EssayQuestionDO getEssayQuestionById(Long essayQuestionId) {
        return null;
    }

    public EssayQuestionListResult getEssayQuestionList() {
        return null;
    }

    public void deleteEssayQuestionByOrderNumber(Integer orderNumber) throws IOException {
        essayQuestionDao.deleteEssayQuestionByOrderNumber(orderNumber);
    }
}
