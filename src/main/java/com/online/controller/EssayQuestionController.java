package com.online.controller;

import com.online.domain.EssayQuestionDO;
import com.online.param.EssayQuestionParam;
import com.online.result.ResponseCode;
import com.online.result.RestResponse;
import com.online.service.EssayQuestionService;
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
 * Created by panlu02 on 2017/4/30.
 */
@Controller
@RequestMapping(value = "/essayquestion")
public class EssayQuestionController {

    private static final Logger LOG = LogManager.getLogger(EssayQuestionController.class);

    @Resource
    EssayQuestionService essayQuestionService;

    /**
     * 根据问答题的Id查询问答题数据
     * @param param
     * @return
     */
    @RequestMapping(value = "/id/get", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse getEssayQuestionById(@RequestBody EssayQuestionParam param){
        LOG.debug("EssayQuestionController#getEssayQuestionById. param: {}", param);
        RestResponse restResponse = new RestResponse();
        try {
            EssayQuestionDO essayQuestionDO = essayQuestionService.getEssayQuestionById(param.getEssayQuestionId());
            if (essayQuestionDO != null){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setData(essayQuestionDO);
                restResponse.setMessage("根据Id获取问答题成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("根据Id获取问答题失败");
        }
        return restResponse;
    }

    /**
     * 分页查询问答题数据
     * @param param
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse getEssayQuestionList(@RequestBody EssayQuestionParam param){
        LOG.debug("EssayQuestionController#getEssayQuestionList. param: {}", param);
        RestResponse restResponse = new RestResponse();
        try {
            List<EssayQuestionDO> essayQuestionDOS = essayQuestionService.getEssayQuestionList(param);
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setData(essayQuestionDOS);
            restResponse.setMessage("分页获取问答题列表成功");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("分页获取问答题列表失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 添加问答题
     * @param essayQuestionDO
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse addEssayQuestion(@RequestBody EssayQuestionDO essayQuestionDO){
        LOG.debug("EssayQuestionController#addEssayQuestion. essayQuestionDO: {}", essayQuestionDO);
        RestResponse restResponse = new RestResponse();
        try {
            int result = essayQuestionService.saveEssayQuestion(essayQuestionDO);
            if (result == 1) {
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("添加问答题成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("添加问答题失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 根据Id号删除问答题
     * @param param
     * @return
     */
    @RequestMapping(value = "/id/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse deleteEssayQuestion(@RequestBody EssayQuestionParam param){
        LOG.debug("EssayQuestionController#deleteEssayQuestion. EssayQuestionParam: {}", param);
        RestResponse restResponse = new RestResponse();
        try {
            essayQuestionService.deleteEssayQuestionById(param);
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setMessage("删除问答题成功");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("删除问答题失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 更新问答题数据
     * @param essayQuestionDO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse updateEssayQuestion(@RequestBody EssayQuestionDO essayQuestionDO){
        LOG.debug("EssayQuestionController#updateEssayQuestion. EssayQuestionDO: {}", essayQuestionDO);
        RestResponse restResponse = new RestResponse();
        try {
            int result = essayQuestionService.updateEssayQuestion(essayQuestionDO);
            if (result == 1){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("更新问答题成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("更新问答题失败");
            e.printStackTrace();
        }
        return restResponse;
    }
}

