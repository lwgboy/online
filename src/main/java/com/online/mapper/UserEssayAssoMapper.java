package com.online.mapper;

import com.online.domain.UserEssayAssoDO;
import com.online.param.UserEssayAssoListParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
public interface UserEssayAssoMapper {

    @Insert("insert into user_essay_asso values(null, #{userId}, #{questionId}, #{codeResult}, #{userAnswer}, null)")
    public int addUserEssayAsso(UserEssayAssoDO userEssayAssoDO);

    @Delete("delete from user_essay_asso where id = #{UserEssayAssoId}")
    public int deleteUserEssayAssoById(Integer UserEssayAssoId);

    @Update("update user_essay_asso set code_result = #{codeResult}, user_answer = #{userAnswer} where id = #{id}")
    public int updateUserEssayAssoById(UserEssayAssoDO userEssayAssoDO);

    @Select("select * from user_essay_asso where user_id = #{userId}")
    public List<UserEssayAssoDO> getUserEssayAssoList(UserEssayAssoListParam param);

    @Select("select * from user_essay_asso")
    public List<UserEssayAssoDO> getAllUserEssayAsso();
}
