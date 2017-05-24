package com.online.service;

import com.online.dao.UserProgrameAssoDao;
import com.online.domain.UserProgrameAssoDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/17.
 */
@Service
public class UserProgrameAssoServiceImp {

    @Resource
    private UserProgrameAssoDao userProgrameAssoDao;

    public int saveUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO) throws IOException {
        InputStreamReader stdISR = null;
        InputStreamReader errISR = null;
        Process process = null;
        String command = "/Users/panlu02/IdeaProjects/online/src/main/java/com/online/shellscript/compile.sh";
        try {
            process = Runtime.getRuntime().exec(command);
            int exitValue = process.waitFor();

            String line = null;

            stdISR = new InputStreamReader(process.getInputStream());
            BufferedReader stdBR = new BufferedReader(stdISR);
            while ((line = stdBR.readLine()) != null) {
                System.out.println("STD line:" + line);
            }

            errISR = new InputStreamReader(process.getErrorStream());
            BufferedReader errBR = new BufferedReader(errISR);
            while ((line = errBR.readLine()) != null) {
                System.out.println("ERR line:" + line);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stdISR != null) {
                    stdISR.close();
                }
                if (errISR != null) {
                    errISR.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (IOException e) {
                System.out.println("正式执行命令：" + command + "有IO异常");
            }
        }

        return userProgrameAssoDao.saveUserProgrameAsso(userProgrameAssoDO);
    }

    public int updateUserProgrameAsso(UserProgrameAssoDO userProgrameAssoDO) throws IOException {
        return userProgrameAssoDao.updateUserProgrameAsso(userProgrameAssoDO);
    }

    public List<UserProgrameAssoDO> getUserProgrameAssoByUserId(Integer userId) throws IOException {
        return userProgrameAssoDao.getUserProgrameAssoByUserId(userId);
    }
}
