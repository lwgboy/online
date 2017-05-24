package com.online.service;

import com.online.dao.UserEssayAssoDao;
import com.online.domain.UserEssayAssoDO;
import com.online.param.UserEssayAssoListParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
@Service
public class UserEssayAssoServiceImp implements UserEssayAssoService{

    @Resource
    UserEssayAssoDao userEssayAssoDao;

    public int addUserEssayAsso(UserEssayAssoDO userEssayAssoDO) throws IOException {
        return userEssayAssoDao.addUserEssayAsso(userEssayAssoDO);
    }

    public int deleteUserEssayAssoById(Integer UserEssayAssoId) throws IOException {
        return userEssayAssoDao.deleteUserEssayAssoById(UserEssayAssoId);
    }

    public int updateUserEssayAssoById(UserEssayAssoDO userEssayAssoDO) throws IOException {
        return userEssayAssoDao.updateUserEssayAssoById(userEssayAssoDO);
    }

    public List<UserEssayAssoDO> getUserEssayAssoList(UserEssayAssoListParam param) throws IOException {
        return userEssayAssoDao.getUserEssayAssoList(param);
    }

    public List<UserEssayAssoDO> getAllUserEssayAsso() throws IOException {
        return userEssayAssoDao.getAllUserEssayAsso();
    }
}
