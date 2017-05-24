package com.online.dao;

import com.online.domain.ProgrameQuestionDO;
import com.online.mapper.ProgrameQuestionMapper;
import com.online.param.Paging;
import com.online.param.QueryProgrameQuestionParam;
import com.online.service.ProgrameQuestionServiceImp;
import com.online.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
@Repository
public class ProgrameQuestionDaoImp implements ProgrameQuestionDao{

    @Resource
    private ProgrameQuestionServiceImp programeQuestionServiceImp;

    public int saveProgrameQuestion(ProgrameQuestionDO programeQuestionDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result;
        try {
            ProgrameQuestionMapper programeQuestionMapper = sqlSession.getMapper(ProgrameQuestionMapper.class);
            result = programeQuestionMapper.saveProgrameQuestion(programeQuestionDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public void deleteProgrameQuestionById(Long programeQuestionId) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            ProgrameQuestionMapper programeQuestionMapper = sqlSession.getMapper(ProgrameQuestionMapper.class);
            programeQuestionMapper.deleteProgrameQuestionById(programeQuestionId);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public List<ProgrameQuestionDO> pageGetProgrameQuestionByTime(QueryProgrameQuestionParam param) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<ProgrameQuestionDO> programeQuestionDOS;
        try {
            ProgrameQuestionMapper programeQuestionMapper = sqlSession.getMapper(ProgrameQuestionMapper.class);
            programeQuestionDOS = programeQuestionMapper.pageGetProgrameQuestionByTime(param);
        }finally {
            sqlSession.close();
        }
        return programeQuestionDOS;
    }

    public List<ProgrameQuestionDO> pageGetProgrameQuestionList(Paging paging) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<ProgrameQuestionDO> programeQuestionDOS;
        try {
            ProgrameQuestionMapper programeQuestionMapper = sqlSession.getMapper(ProgrameQuestionMapper.class);
            programeQuestionDOS = programeQuestionMapper.pageGetProgrameQuestionList(paging);
        }finally {
            sqlSession.close();
        }
        return programeQuestionDOS;
    }

    /*
    public List<ProgrameQuestionDO> getProgrameQuestionList(Long yearTime) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<ProgrameQuestionDO> programeQuestionDOS;
        try {
            ProgrameQuestionMapper programeQuestionMapper = sqlSession.getMapper(ProgrameQuestionMapper.class);
            programeQuestionDOS = programeQuestionMapper.getProgrameQuestionList(yearTime);
        }finally {
            sqlSession.close();
        }
        return programeQuestionDOS;
    }*/


}
