package com.online.service;

import com.online.dao.ProgrameQuestionDao;
import com.online.domain.ProgrameQuestionDO;
import com.online.param.Paging;
import com.online.param.QueryProgrameQuestionParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by panlu02 on 2017/5/16.
 */
@Service
public class ProgrameQuestionServiceImp {
    @Resource
    ProgrameQuestionDao programeQuestionDao;

    public int saveProgrameQuestion(ProgrameQuestionDO programeQuestionDO) throws IOException {
        programeQuestionDO.setCtime(System.currentTimeMillis());
        programeQuestionDO.setUtime(System.currentTimeMillis());
        return programeQuestionDao.saveProgrameQuestion(programeQuestionDO);
    }

    public void deleteProgrameQuestionById(Long programeQuestionId) throws IOException {
        programeQuestionDao.deleteProgrameQuestionById(programeQuestionId);
    }

    /**
     * 查询一个年度的所有编程题，首先需要设置时间屏障，然后设置分页查询的参数
     * @param page
     * @return
     */
    public List<ProgrameQuestionDO> pageGetProgrameQuestionByTime(Paging page){
        QueryProgrameQuestionParam param = new QueryProgrameQuestionParam();
        List<ProgrameQuestionDO> programeQuestionDOS = null;

        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String timeBarrier = year+"-01-01";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        param.setPageStart((param.getPageIndex() - 1) * param.getPageSize());
        try {
            date = sdf.parse(timeBarrier);
            Long yearTime = date.getTime();
            param.setTimeBarrie(yearTime);

            programeQuestionDOS = programeQuestionDao.pageGetProgrameQuestionByTime(param);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return programeQuestionDOS;
    }

    public List<ProgrameQuestionDO> pageGetProgrameQuestionList(Paging page) throws IOException {
        return programeQuestionDao.pageGetProgrameQuestionList(page);
    }
}
