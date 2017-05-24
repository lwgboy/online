package com.online.service;

import com.online.dao.OnlineUserDao;
import com.online.domain.OnlineUserDO;
import com.online.param.QueryOnlineUserParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOG = LogManager.getLogger(OnlineUserService.class);

    @Resource
    OnlineUserDao onlineUserDao;

    public int saveUser(OnlineUserDO onlineUserDO) throws IOException {
        LOG.info("Online_userService#saveUser. opUser: {}", onlineUserDO);
        return onlineUserDao.saveUser(onlineUserDO);
    }

    public int deleteUser(Long userId) throws IOException {
        return onlineUserDao.deleteUser(userId);
    }

    public List<OnlineUserDO> getUserList(QueryOnlineUserParam param) throws IOException {
        return onlineUserDao.getUserList(param);
    }


    public int getUserType(OnlineUserDO onlineUserDO) throws IOException {
        return onlineUserDao.getUserType(onlineUserDO);
    }

    public OnlineUserDO getUserByStuNumberAndPasswd(OnlineUserDO onlineUserDO) throws IOException {
        return onlineUserDao.getUserByStudentNumberAndPasswd(onlineUserDO);
    }


    public void updateUser(OnlineUserDO onlineUserDO) throws IOException {
        onlineUserDao.updateUser(onlineUserDO);
    }
}
