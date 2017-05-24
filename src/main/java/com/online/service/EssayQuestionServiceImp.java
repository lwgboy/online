package com.online.service;

import com.online.dao.EssayQuestionDao;
import com.online.domain.EssayQuestionDO;
import com.online.param.EssayQuestionParam;
import com.online.param.Paging;
import com.online.result.EssayQuestionListResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu02 on 2017/5/6.
 */
@Service
public class EssayQuestionServiceImp implements EssayQuestionService {

    private static final Logger LOG = LogManager.getLogger(OnlineUserService.class);

    @Autowired
    EssayQuestionDao essayQuestionDao;

    public int saveEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException {
        LOG.info("EssayQuestionService#saveEssayQuestion. essayQuestionDO: {}", essayQuestionDO);
        essayQuestionDO.setCtime(System.currentTimeMillis());
        essayQuestionDO.setUtime(System.currentTimeMillis());
        return essayQuestionDao.saveEssayQuestion(essayQuestionDO);
    }

    public void deleteEssayQuestionById(EssayQuestionParam param) throws IOException {
        LOG.info("EssayQuestionService#deleteEssayQuestionById. EssayQuestionParam: {}", param);
        essayQuestionDao.deleteEssayQuestionById(param);
    }

    public EssayQuestionDO getEssayQuestionById(Long essayQuestionId) throws IOException {
        LOG.info("EssayQuestionService#getEssayQuestionById. essayQuestionId: {}", essayQuestionId);
        return essayQuestionDao.getEssayQuestionById(essayQuestionId);
    }

    public List<EssayQuestionDO> getEssayQuestionList(EssayQuestionParam param) throws IOException {
        LOG.info("EssayQuestionService#getEssayQuestionList. Paging: {}", param);
        param.setPageStart((param.getPageIndex()-1) * param.getPageSize() + 1);
        return essayQuestionDao.getEssayQuestionList(param);
    }

    /**
     * 修改问答题的更新时间还有待完成
     * @param essayQuestionDO
     * @return
     * @throws IOException
     */
    public int updateEssayQuestion(EssayQuestionDO essayQuestionDO) throws IOException {
        LOG.info("EssayQuestionService#updateEssayQuestion. essayQuestionDO: {}", essayQuestionDO);
        return essayQuestionDao.updateEssayQuestion(essayQuestionDO);
    }
}
