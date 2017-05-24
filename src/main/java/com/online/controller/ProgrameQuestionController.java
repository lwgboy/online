package com.online.controller;

import com.online.domain.ProgrameQuestionDO;
import com.online.param.Paging;
import com.online.param.QueryProgrameQuestionParam;
import com.online.result.ResponseCode;
import com.online.result.RestResponse;
import com.online.service.ProgrameQuestionServiceImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/16.
 */
@Controller
@RequestMapping(value = "/proquestion")
public class ProgrameQuestionController {

    private static final Logger LOG = LogManager.getLogger(ProgrameQuestionController.class);

    @Resource
    ProgrameQuestionServiceImp programeQuestionServiceImp;

    /**
     * 添加一道编程题
     * @param programeQuestionDO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveProgrameQuestion(@RequestBody ProgrameQuestionDO programeQuestionDO){
        LOG.debug("ProgrameQuestionController#saveProgrameQuestion. ProgrameQuestionDO: {}", programeQuestionDO);
        RestResponse restResponse = new RestResponse();
//        System.out.println(programeQuestionDO.toString());
        try {
            int result = programeQuestionServiceImp.saveProgrameQuestion(programeQuestionDO);
            if (result == 1){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("添加编程题成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("添加编程题失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    @RequestMapping(value = "/id/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse deleteProgrameQuestionById(@RequestBody QueryProgrameQuestionParam param){
        LOG.debug("ProgrameQuestionController#deleteProgrameQuestionById. programeQuestionId: {}", param.getProgrameQuestionId());
        RestResponse restResponse = new RestResponse();
        try {
            programeQuestionServiceImp.deleteProgrameQuestionById(param.getProgrameQuestionId());
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setMessage("删除编程题成功");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("删除编程题失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    public RestResponse updateProgrameQuestionById(){
        return null;
    }

    /**
     * 分页获取所有的编程题
     * @param param
     * @return
     */
    @RequestMapping(value = "/page/all/get", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse pageGetAllProgrameQuestion(@RequestBody Paging param){
        LOG.debug("ProgrameQuestionController#pageGetAllProgrameQuestion. Paging: {}", param);
        RestResponse restResponse = new RestResponse();
        try {
            List<ProgrameQuestionDO> programeQuestionDOS = programeQuestionServiceImp.pageGetProgrameQuestionList(param);
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setMessage("分页获取全部编程题成功");
            restResponse.setData(programeQuestionDOS);
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("分页获取全部编程题失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 分页获取今年的编程题
     * @return
     */
    @RequestMapping(value = "/page/time/get", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse pageGetProgrameQuestionByTime(@RequestBody Paging param){
        LOG.debug("ProgrameQuestionController#pageGetProgrameQuestionByTime. Paging: {}", param);
        RestResponse restResponse = new RestResponse();

        List<ProgrameQuestionDO> programeQuestionDOS = programeQuestionServiceImp.pageGetProgrameQuestionByTime(param);
        restResponse.setCode(ResponseCode.OK.getCode());
        restResponse.setMessage("分页获取今年编程题成功");
        restResponse.setData(programeQuestionDOS);

        return restResponse;
    }
}
