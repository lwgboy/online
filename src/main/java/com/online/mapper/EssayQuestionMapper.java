package com.online.mapper;

import com.online.domain.EssayQuestionDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by panlu02 on 2017/5/6.
 */
public interface EssayQuestionMapper {

    @Insert("insert into essay_question values(#{orderNumber}, #{question}, #{code}, #{codeResult}, #{answer})")
    int saveEssayQuestion(EssayQuestionDO essayQuestionDO);

    @Delete("delete from essay_question where id = #{essayQuestionId}")
    void deleteEssayQuestionByOrderNumber(Integer orderNumber);
}
