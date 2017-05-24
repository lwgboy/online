package com.online.controller;

import com.online.domain.UserProgrameAssoDO;
import com.online.param.QueryUserProgrameAssoParam;
import com.online.result.ResponseCode;
import com.online.result.RestResponse;
import com.online.service.UserProgrameAssoServiceImp;
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
 * Created by panlu02 on 2017/5/17.
 */
@Controller
@RequestMapping(value = "/userprograme", method = RequestMethod.POST)
public class UserProgrameAssoController {
    private static final Logger LOG = LogManager.getLogger(UserProgrameAssoController.class);

    @Resource
    private UserProgrameAssoServiceImp userProgrameAssoServiceImp;

    /**
     * 保存用户的编程题结果
     * @param userProgrameAssoDO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse addUserProgrameAsso(@RequestBody UserProgrameAssoDO userProgrameAssoDO){
        LOG.debug("UserProgrameAssoController#addUserProgrameAsso, userProgrameAssoDO{}",userProgrameAssoDO);
        RestResponse restResponse = new RestResponse();
//        userProgrameAssoDO.setCodeResult(userProgrameAssoDO.getCodeResult().replaceAll("\"","\\\\\""));
//        System.out.println(userProgrameAssoDO.toString());
        try {
            int result = userProgrameAssoServiceImp.saveUserProgrameAsso(userProgrameAssoDO);
            if (result == 1) {
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("保存用户编程题结果成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("保存用户编程题结果失败");

            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 更新用户的编程题结果
     * @param userProgrameAssoDO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse updateUserProgrameAsso(@RequestBody UserProgrameAssoDO userProgrameAssoDO){
        LOG.debug("UserProgrameAssoController#updateUserProgrameAsso, userProgrameAssoDO{}",userProgrameAssoDO);
        RestResponse restResponse = new RestResponse();
        try {
            int result = userProgrameAssoServiceImp.updateUserProgrameAsso(userProgrameAssoDO);
            if (result == 1){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("更新用户编程题结果成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("更新用户编程题结果失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    @RequestMapping(value = "/userid/get", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse getUserProgrameAssoByUserId(@RequestBody QueryUserProgrameAssoParam param){
        LOG.debug("UserProgrameAssoController#getUserProgrameAssoByUserId, userProgrameAssoDO{}",param);
        RestResponse restResponse = new RestResponse();
        try {
            System.out.println(param.getUserId());
            List<UserProgrameAssoDO> userProgrameAssoDOS = userProgrameAssoServiceImp.getUserProgrameAssoByUserId(param.getUserId());
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setMessage("获取用户的编程题成功");
            restResponse.setData(userProgrameAssoDOS);
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("获取用户的编程题失败");
            e.printStackTrace();
        }
        return restResponse;
    }
}
