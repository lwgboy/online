package com.online.service;

import com.online.domain.UserEssayAssoDO;
import com.online.param.UserEssayAssoListParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
public interface UserEssayAssoService {
    public int addUserEssayAsso(UserEssayAssoDO userEssayAssoDO) throws IOException;

    public int deleteUserEssayAssoById(Integer UserEssayAssoId) throws IOException;

    public int updateUserEssayAssoById(UserEssayAssoDO userEssayAssoDO) throws IOException;

    public List<UserEssayAssoDO> getUserEssayAssoList(UserEssayAssoListParam param) throws IOException;

    public List<UserEssayAssoDO> getAllUserEssayAsso() throws IOException;
}
