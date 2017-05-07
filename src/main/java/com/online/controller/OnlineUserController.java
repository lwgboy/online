package com.online.controller;

import com.online.domain.OnlineUserDO;
import com.online.param.QueryOnlineUserParam;
import com.online.result.ResponseCode;
import com.online.result.RestResponse;
import com.online.service.OnlineUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by panlu02 on 2017/4/30.
 */
@Controller
@RequestMapping(value = "/user")
public class OnlineUserController {
    private static final Logger LOG = LogManager.getLogger(OnlineUserController.class);

    @Resource
    private OnlineUserService onlineUserService;

    /**
     * 根据学号和密码进行登录，登录的时候判断用户身份
     * @param onlineUserDO
     * @return
     */
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse validateUser(@RequestBody OnlineUserDO onlineUserDO){
        LOG.debug("validate user is root", onlineUserDO);
        RestResponse restResponse = new RestResponse();
        int type = 0;

        try {
            type = onlineUserService.getUserType(onlineUserDO);
            if (type == 1){
                restResponse.setCode(ResponseCode.ROOTUSER.getCode());
                restResponse.setMessage("超管登录");
            } else if (type == 2){
                restResponse.setCode(ResponseCode.ADMINUSER.getCode());
                restResponse.setMessage("普通管理员登录");
            } else if (type == 3) {
                restResponse.setCode(ResponseCode.USUALUSER.getCode());
                restResponse.setMessage("普通用户登录");
            } else {
                restResponse.setCode(ResponseCode.BAD_PARAMETERS.getCode());
                restResponse.setMessage("登录失败，参数异常");
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 超管新添管理员信息
     * @param onlineUserDO
     * @return
     */
    @RequestMapping(value = "/addAdminUser", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse addAdminUser(@RequestBody OnlineUserDO onlineUserDO){
        LOG.debug("UserController#addAdminUser. online_user: {}", onlineUserDO);
        RestResponse restResponse = new RestResponse();

        onlineUserDO.setType(2);
        try {
            onlineUserService.saveUser(onlineUserDO);
        } catch (IOException e) {
            LOG.error("保存用户出错", e);
            restResponse.setCode(ResponseCode.INTERNAL_ERROR.getCode());
            restResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 根据user的id删除一条信息
     * @param onlineUserDO
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse updateUserById(@RequestBody OnlineUserDO onlineUserDO){
        LOG.debug("UserController#updateUser. online_user {}", onlineUserDO);
        RestResponse restResponse = new RestResponse();

        try {
            onlineUserService.updateUser(onlineUserDO);
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setMessage("更新成功");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 根据用户id删除用户
     * @param param
     * @return
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse deleteAdmin(@RequestBody QueryOnlineUserParam param) {
        LOG.debug("UserController#deleteAdmin QueryOnlineUserParam {}",param);
        RestResponse restResponse = new RestResponse();
        Long onlineUserId = param.getId();
        int result = 0;
        try {
            result = onlineUserService.deleteUser(onlineUserId);
            if (result == 1){
                restResponse.setCode(ResponseCode.OK.getCode());
                restResponse.setMessage("删除成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }

    /**
     * 获取管理员数据列表
     * @return
     */
    @RequestMapping(value = "/getAdminList", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse getAdminList(){
        LOG.debug("UserController#getAdminList ");
        RestResponse restResponse = new RestResponse();

        QueryOnlineUserParam param = new QueryOnlineUserParam();
        param.setType(2);
        try {
            restResponse.setData(onlineUserService.getAdminList(param));
            restResponse.setCode(ResponseCode.OK.getCode());
            restResponse.setMessage("获取管理员列表");
        } catch (IOException e) {
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     * 普通用户的注册，首先判断数据库中是否已经存在该条数据，不存在则判断每个字段是否填写完整，然后保存
     * @param onlineUserDO
     * @return
     */
    @RequestMapping(value = "/addusualUser", method = RequestMethod.POST)
    @ResponseBody
    public  RestResponse addUsualUser(@RequestBody OnlineUserDO onlineUserDO){
        LOG.debug("OnlineUserController#addUsualUser. online_user{}", onlineUserDO);
        RestResponse restResponse = new RestResponse();
        try {
            OnlineUserDO userDO = onlineUserService.getUserByStuNumberAndPasswd(onlineUserDO);
            if (userDO != null){
                restResponse.setMessage("用户已经注册，请直接登录");
                restResponse.setCode(ResponseCode.NOTLOGIN.getCode());
                return restResponse;
            }
            if (onlineUserDO.getUserName()!=null && onlineUserDO.getStudentNumber()!= null && onlineUserDO.getPassword()!=null && onlineUserDO.getClassNo()!=null && onlineUserDO.getTelephone()!=null) {
                onlineUserDO.setType(3);
                onlineUserService.saveUser(onlineUserDO);
            }else {
                restResponse.setMessage("注册参数错误");
                restResponse.setCode(ResponseCode.BAD_PARAMETERS.getCode());
                return restResponse;
            }
        } catch (IOException e) {
            LOG.error("保存普通用户出错");
            restResponse.setCode(ResponseCode.OTHER.getCode());
            restResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return restResponse;
    }
}
