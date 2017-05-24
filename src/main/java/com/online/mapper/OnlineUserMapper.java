package com.online.mapper;

import com.online.domain.OnlineUserDO;
import com.online.param.QueryOnlineUserParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by panlu02 on 2017/5/2.
 */
public interface OnlineUserMapper {

    @Insert("insert into online_user values(null, #{userName}, #{studentNumber}, #{classNo}, #{telephone}, #{password}, #{type})")
    int saveUser(OnlineUserDO onlineUserDO);

    @Select("select type from online_user where student_number = #{studentNumber} and password = #{password}")
    int getUserType(OnlineUserDO onlineUserDO);

    @Select("select * from online_user where student_number = #{studentNumber} and password = #{password}")
    OnlineUserDO getUserByStuNumberAndPasswd(OnlineUserDO onlineUserDO);

    @Select("select * from online_user where type = #{type} limit #{pageStart}, #{pageSize}")
    List<OnlineUserDO> getUserList(QueryOnlineUserParam param);

    @Delete("delete from online_user where id = #{onlineUserId}")
    int deleteUser(Long onlineUserId);

    @Update("update online_user set user_name = #{userName}, student_number = #{studentNumber}, class_no = #{classNo}, telephone = #{telephone}, password = #{password},type = #{type} where id = #{userId}")
    void updateOnlineUser(OnlineUserDO onlineUserDO);

}
