package com.online.dao;

import com.online.domain.OnlineUserDO;
import com.online.mapper.OnlineUserMapper;
import com.online.param.QueryOnlineUserParam;
import com.online.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/2.
 */
@Repository
public class OnlineUserDaoImp implements OnlineUserDao {

    public int saveUser(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;

        try {
            OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
            result = onlineUserMapper.saveUser(onlineUserDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

        return result;
    }

    public int deleteUser(Long userId) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int result = 0;

        try {
            OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
            result = onlineUserMapper.deleteUser(userId);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

        return result;
    }

    public List<OnlineUserDO> getUserList(QueryOnlineUserParam param) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<OnlineUserDO> onlineUserDOS = null;

        try {
            OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
            onlineUserDOS = onlineUserMapper.getUserList(param);
        }finally {
            sqlSession.close();
        }

        return onlineUserDOS;
    }

    public int getUserType(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        int type = 0;

        try {
            OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
            type = onlineUserMapper.getUserType(onlineUserDO);
        }finally {
            sqlSession.close();
        }

        return type;
    }

    public OnlineUserDO getUserByStudentNumberAndPasswd(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        OnlineUserDO userDO = null;

        try {
            OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
            userDO = onlineUserMapper.getUserByStuNumberAndPasswd(onlineUserDO);
        }finally {
            sqlSession.close();
        }

        return userDO;
    }

    public void updateUser(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();

        try {
            OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
            onlineUserMapper.updateOnlineUser(onlineUserDO);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

    }
}
