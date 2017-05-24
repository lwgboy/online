package com.online.mapper;

import com.online.domain.EssayQuestionDO;
import com.online.param.EssayQuestionParam;
import com.online.param.Paging;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by panlu02 on 2017/5/6.
 */
public interface EssayQuestionMapper {

    @Insert("insert into essay_question values(null, #{orderNumber}, #{question}, #{code}, #{ctime}, #{utime})")
    int saveEssayQuestion(EssayQuestionDO essayQuestionDO);

    @Delete("delete from essay_question where id = #{essayQuestionId}")
    void deleteEssayQuestionById(EssayQuestionParam param);

    @Update("update essay_question set order_number = #{orderNumber}, question = #{question}, code = #{code} where id = #{id}")
    int updateEssayQuestion(EssayQuestionDO essayQuestionDO);

    @Select("select * from essay_question limit #{pageStart}, #{pageSize}")
    List<EssayQuestionDO> getEssayQuestionList(EssayQuestionParam param);

    @Select("select * from essay_question where id = #{essayQuestionId}")
    EssayQuestionDO getEssayQuestionById(Long essayQuestionId);
}
