package com.online.service;

import com.online.dao.OnlineUserDao;
import com.online.domain.OnlineUserDO;
import com.online.param.QueryOnlineUserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/2.
 */
@Service
public class OnlineUserServiceImp implements OnlineUserService {

    @Resource
    OnlineUserDao onlineUserDao;

    public void saveUser(OnlineUserDO onlineUserDO) throws IOException {
        onlineUserDao.saveUser(onlineUserDO);
    }

    public int deleteUser(Long userId) throws IOException {
        return onlineUserDao.deleteUser(userId);
    }

    public OnlineUserDO getUserByType(int type) throws IOException {
        return onlineUserDao.getUserByType(type);
    }

    public int getUserType(OnlineUserDO onlineUserDO) throws IOException {
        return onlineUserDao.getUserType(onlineUserDO);
    }

    public OnlineUserDO getUserByStuNumberAndPasswd(OnlineUserDO onlineUserDO) throws IOException {
        return onlineUserDao.getUserByStudentNumberAndPasswd(onlineUserDO);
    }

    public List<OnlineUserDO> getAdminList(QueryOnlineUserParam param) throws IOException {
        return onlineUserDao.getAdminList(param);
    }

    public void updateUser(OnlineUserDO onlineUserDO) throws IOException {
        onlineUserDao.updateUser(onlineUserDO);
    }
}
