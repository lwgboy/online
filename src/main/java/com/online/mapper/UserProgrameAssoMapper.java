package com.online.mapper;

import com.online.dao.UserProgrameAssoDao;
import com.online.domain.UserProgrameAssoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by panlu02 on 2017/5/17.
 */
public interface UserProgrameAssoMapper {

    @Insert("insert into user_programe_asso values(null,#{userId},#{questionId},#{codeResult},null)")
    int saveUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO);

    @Update("update user_programe_asso set code_result = #{codeResult} where user_id = #{userId} and question_id = #{questionId}")
    int updateUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO);

    @Select("select * from user_programe_asso where user_id = #{userId}")
    List<UserProgrameAssoDO> getUserProgrameAssoByUserId(Integer userId);
}
