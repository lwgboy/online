package com.online.dao;

import com.online.domain.UserEssayAssoDO;
import com.online.domain.UserProgrameAssoDO;
import com.online.mapper.UserEssayAssoMapper;
import com.online.mapper.UserProgrameAssoMapper;
import com.online.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/17.
 */
@Repository
public class UserProgrameAssoDaoImp implements UserProgrameAssoDao {

    public int saveUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;
        try {
            UserProgrameAssoMapper userProgrameAssoMapper = sqlSession.getMapper(UserProgrameAssoMapper.class);
            result = userProgrameAssoMapper.saveUserProgrameAsso(userProgrameAssoDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

        return result;
    }

    public int updateUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;
        try {
            UserProgrameAssoMapper userProgrameAssoMapper = sqlSession.getMapper(UserProgrameAssoMapper.class);
            result = userProgrameAssoMapper.updateUserProgrameAsso(userProgrameAssoDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public List<UserProgrameAssoDO> getUserProgrameAssoByUserId(Integer userId) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<UserProgrameAssoDO> userProgrameAssoDOS = null;
        try {
            UserProgrameAssoMapper userProgrameAssoMapper = sqlSession.getMapper(UserProgrameAssoMapper.class);
            userProgrameAssoDOS = userProgrameAssoMapper.getUserProgrameAssoByUserId(userId);
        }finally {
            sqlSession.close();
        }
        return userProgrameAssoDOS;
    }

}
