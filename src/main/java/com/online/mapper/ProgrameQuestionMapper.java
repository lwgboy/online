package com.online.mapper;

import com.online.domain.ProgrameQuestionDO;
import com.online.param.Paging;
import com.online.param.QueryProgrameQuestionParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
public interface ProgrameQuestionMapper {

    @Insert("insert into programe_question values(null, #{orderNumber}, #{question}, #{description}, #{inputDescription}, #{outputDescription}, #{inputData}, #{outputData}, #{ctime}, #{utime})")
    int saveProgrameQuestion(ProgrameQuestionDO programeQuestionDO);

    @Delete("delete from programe_question where id = #{programeQuestionId}")
    void deleteProgrameQuestionById(Long programeQuestionId);

    @Select("select * from programe_question where ctime > #{timeBarrie} and utime > #{timeBarrie} limit #{pageStart}, #{pageSize}")
    List<ProgrameQuestionDO> pageGetProgrameQuestionByTime(QueryProgrameQuestionParam param);

    @Select("select * from programe_question limit #{pageStart}, #{pageSize}")
    List<ProgrameQuestionDO> pageGetProgrameQuestionList(Paging paging);
}
