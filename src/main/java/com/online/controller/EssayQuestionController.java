package com.online.controller;

import com.online.param.EssayQuestionParam;
import com.online.result.RestResponse;
import com.online.service.EssayQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by panlu02 on 2017/4/30.
 */
@Controller
@RequestMapping(value = "/online/essayquestion")
public class EssayQuestionController {

    @Resource
    EssayQuestionService essayQuestionService;

    @RequestMapping(value = "/getEssayQuestionById", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse getEssayQuestionById(EssayQuestionParam param){
//        LOG.debug("EssayQuestionController#getEssayQuestionById. param: {}", param);
        return null;
    }
}

