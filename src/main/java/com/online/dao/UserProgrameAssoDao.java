package com.online.dao;

import com.online.domain.UserProgrameAssoDO;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/17.
 */
public interface UserProgrameAssoDao {
    int saveUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO) throws IOException;

    int updateUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO) throws IOException;

    List<UserProgrameAssoDO> getUserProgrameAssoByUserId(Integer userId) throws IOException;

}
