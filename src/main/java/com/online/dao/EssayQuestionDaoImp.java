package com.online.dao;

import com.online.domain.EssayQuestionDO;
import com.online.mapper.EssayQuestionMapper;
import com.online.param.EssayQuestionParam;
import com.online.param.Paging;
import com.online.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/6.
 */
@Repository
public class EssayQuestionDaoImp implements EssayQuestionDao {

    public int saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;

        try {
            EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
            result = essayQuestionMapper.saveEssayQuestion(essayQuestionDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public void deleteEssayQuestionById(EssayQuestionParam param) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();

        try {
            EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
            essayQuestionMapper.deleteEssayQuestionById(param);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public EssayQuestionDO getEssayQuestionById(Long essayQuestionId) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        EssayQuestionDO essayQuestionDO = null;
        try {
            EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
            essayQuestionDO = essayQuestionMapper.getEssayQuestionById(essayQuestionId);
        }finally {
            sqlSession.close();
        }
        return essayQuestionDO;
    }

    public List<EssayQuestionDO> getEssayQuestionList(EssayQuestionParam param) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<EssayQuestionDO> essayQuestionDOList = null;
        try {
            EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
            essayQuestionDOList = essayQuestionMapper.getEssayQuestionList(param);
        }finally {
            sqlSession.close();
        }
        return essayQuestionDOList;
    }

    public int updateEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;
        try {
            EssayQuestionMapper essayQuestionMapper = sqlSession.getMapper(EssayQuestionMapper.class);
            result = essayQuestionMapper.updateEssayQuestion(essayQuestionDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }
}
