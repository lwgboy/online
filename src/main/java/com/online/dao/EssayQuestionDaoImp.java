package com.online.dao;

import com.online.domain.EssayQuestionDO;
import com.online.mapper.EssayQuestionMapper;
import com.online.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by panlu02 on 2017/5/6.
 */
@Repository
public class EssayQuestionDaoImp implements EssayQuestionDao {

    public int saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();

        EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
        int result = essayQuestionMapper.saveEssayQuestion(essayQuestionDO);
        return result;
    }

    public void deleteEssayQuestionByOrderNumber(Integer orderNumber) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();

        EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
        essayQuestionMapper.deleteEssayQuestionByOrderNumber(orderNumber);
    }

}
