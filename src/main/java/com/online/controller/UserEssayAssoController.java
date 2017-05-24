package com.online.controller;

import com.online.domain.UserEssayAssoDO;
import com.online.param.UserEssayAssoListParam;
import com.online.result.ResponseCode;
import com.online.result.RestResponse;
import com.online.service.UserEssayAssoService;
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
@RequestMapping(value = "/useressayasso")
public class UserEssayAssoController {

    private static final Logger LOG = LogManager.getLogger(UserEssayAssoController.class);

    @Resource
    private UserEssayAssoService userEssayAssoService;

    /**
     * 分页获取所有用户问答关联表
     * @return
     */
    @RequestMapping(value = "/list/get", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse getAllUserEssayAsso(){
        LOG.debug("UserEssayAssoController#getAllUserEssayAsso");
        RestResponse restResponse = new RestResponse();

        try {
            List<UserEssayAssoDO> userEssayAssoDOS = userEssayAssoService.getAllUserEssayAsso();
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setData(userEssayAssoDOS);
            restResponse.setMessage("分页获取用户-问答题列表成功");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("分页获取用户-问答题列表失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 根据用户id获取该用户的问答题列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/id/get", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse getUserEssayAssoListByUserId(@RequestBody UserEssayAssoListParam param){
        LOG.debug("UserEssayAssoController#getUserEssayAssoListByUserId UserEssayAssoListParam{},",param);
        RestResponse restResponse = new RestResponse();

        try {
            List<UserEssayAssoDO> userEssayAssoDOS = userEssayAssoService.getUserEssayAssoList(param);
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setData(userEssayAssoDOS);
            restResponse.setMessage("获取用户-问答题列表成功");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("获取用户-问答题列表失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 添加用户问答题关联表的数据
     * @param userEssayAssoDO
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveUserEssayAsso(@RequestBody UserEssayAssoDO userEssayAssoDO){
        LOG.debug("UserEssayAssoController#saveUserEssayAsso UserEssayAssoDO{},",userEssayAssoDO);
        RestResponse restResponse = new RestResponse();

        try {
            System.out.println(userEssayAssoDO.toString());
            int result = userEssayAssoService.addUserEssayAsso(userEssayAssoDO);
            if (result == 1){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("添加用户-问答题数据成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("添加用户-问答题数据失败");
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 修改一条数据
     * @param userEssayAssoDO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse updateUserEssayAsso(@RequestBody UserEssayAssoDO userEssayAssoDO){
        LOG.debug("UserEssayAssoController#updateUserEssayAsso UserEssayAssoDO{},",userEssayAssoDO);
        RestResponse restResponse = new RestResponse();

        try {
            int result = userEssayAssoService.updateUserEssayAssoById(userEssayAssoDO);
            if (result == 1){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("修改用户-问答题数据成功");
            }
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage("修改用户-问答题数据失败");
            e.printStackTrace();
        }
        return restResponse;
    }

}
