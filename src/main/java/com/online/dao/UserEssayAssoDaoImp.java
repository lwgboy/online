package com.online.dao;

import com.online.domain.UserEssayAssoDO;
import com.online.mapper.UserEssayAssoMapper;
import com.online.param.UserEssayAssoListParam;
import com.online.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
@Repository
public class UserEssayAssoDaoImp implements UserEssayAssoDao{

    public int addUserEssayAsso(UserEssayAssoDO userEssayAssoDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;
        try {
            UserEssayAssoMapper userEssayAssoMapper = sqlSession.getMapper(UserEssayAssoMapper.class);
            result = userEssayAssoMapper.addUserEssayAsso(userEssayAssoDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int deleteUserEssayAssoById(Integer UserEssayAssoId) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;
        try {
            UserEssayAssoMapper userEssayAssoMapper = sqlSession.getMapper(UserEssayAssoMapper.class);
            result = userEssayAssoMapper.deleteUserEssayAssoById(UserEssayAssoId);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int updateUserEssayAssoById(UserEssayAssoDO userEssayAssoDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;
        try {
            UserEssayAssoMapper userEssayAssoMapper = sqlSession.getMapper(UserEssayAssoMapper.class);
            result = userEssayAssoMapper.updateUserEssayAssoById(userEssayAssoDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public List<UserEssayAssoDO> getUserEssayAssoList(UserEssayAssoListParam param) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<UserEssayAssoDO> userEssayAssoDOS = null;
        try {
            UserEssayAssoMapper userEssayAssoMapper = sqlSession.getMapper(UserEssayAssoMapper.class);
            userEssayAssoDOS = userEssayAssoMapper.getUserEssayAssoList(param);
        }finally {
            sqlSession.close();
        }
        return userEssayAssoDOS;
    }

    public List<UserEssayAssoDO> getAllUserEssayAsso() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<UserEssayAssoDO> userEssayAssoDOS = null;
        try {
            UserEssayAssoMapper userEssayAssoMapper = sqlSession.getMapper(UserEssayAssoMapper.class);
            userEssayAssoDOS = userEssayAssoMapper.getAllUserEssayAsso();
        }finally {
            sqlSession.close();
        }
        return userEssayAssoDOS;
    }
}
