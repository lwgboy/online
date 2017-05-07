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

        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
        int result = onlineUserMapper.saveUser(onlineUserDO);
        return result;
    }

    public int deleteUser(Long userId) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
        return onlineUserMapper.deleteUser(userId);
    }

    public OnlineUserDO getUserByType(Integer type) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();

        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
        OnlineUserDO onlineUserDO = onlineUserMapper.getUserByType(type);
        return onlineUserDO;
    }

    public int getUserType(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();

        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
        int type = onlineUserMapper.getUserType(onlineUserDO);
        return type;
    }

    public OnlineUserDO getUserByStudentNumberAndPasswd(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);
        OnlineUserDO userDO = onlineUserMapper.getUserByStuNumberAndPasswd(onlineUserDO);
        return userDO;
    }

    public List<OnlineUserDO> getAdminList(QueryOnlineUserParam param) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);

        List<OnlineUserDO> onlineUserDOS = onlineUserMapper.getAdminList(param);
        return onlineUserDOS;
    }

    public void updateUser(OnlineUserDO onlineUserDO) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSession();
        OnlineUserMapper onlineUserMapper = sqlSession.getMapper(OnlineUserMapper.class);

        onlineUserMapper.updateOnlineUser(onlineUserDO);
    }
}
