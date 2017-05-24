package com.online.dao;

import com.online.domain.ProgrameQuestionDO;
import com.online.param.Paging;
import com.online.param.QueryProgrameQuestionParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
public interface ProgrameQuestionDao {
    int saveProgrameQuestion(ProgrameQuestionDO programeQuestionDO) throws IOException;

    void deleteProgrameQuestionById(Long programeQuestionId) throws IOException;

    List<ProgrameQuestionDO> pageGetProgrameQuestionByTime(QueryProgrameQuestionParam param) throws IOException;

    List<ProgrameQuestionDO> pageGetProgrameQuestionList(Paging paging) throws IOException;

}
