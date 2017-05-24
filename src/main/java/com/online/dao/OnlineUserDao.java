package com.online.dao;

import com.online.domain.OnlineUserDO;
import com.online.param.QueryOnlineUserParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/2.
 */
public interface OnlineUserDao {
    int saveUser(OnlineUserDO onlineUserDO) throws IOException;

    int deleteUser(Long userId) throws IOException;

    List<OnlineUserDO> getUserList(QueryOnlineUserParam param) throws IOException;

    int getUserType(OnlineUserDO onlineUserDO) throws IOException;

    OnlineUserDO getUserByStudentNumberAndPasswd(OnlineUserDO onlineUserDO) throws IOException;

    void updateUser(OnlineUserDO onlineUserDO) throws IOException;
}
