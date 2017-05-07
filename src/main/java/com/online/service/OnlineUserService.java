package com.online.service;

import com.online.domain.OnlineUserDO;
import com.online.param.QueryOnlineUserParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/2.
 */
public interface OnlineUserService {
    void saveUser(OnlineUserDO onlineUserDO) throws IOException;
    int deleteUser(Long userId) throws IOException;
    OnlineUserDO getUserByType(int type) throws IOException;
    int getUserType(OnlineUserDO onlineUserDO) throws IOException;

    OnlineUserDO getUserByStuNumberAndPasswd(OnlineUserDO onlineUserDO) throws IOException;

    List<OnlineUserDO> getAdminList(QueryOnlineUserParam param) throws IOException;

    void updateUser(OnlineUserDO onlineUserDO) throws IOException;
}
