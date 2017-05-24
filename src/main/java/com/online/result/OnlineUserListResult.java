package com.online.result;

import com.online.domain.OnlineUserDO;

import java.util.List;

/**
 * Created by panlu02 on 2017/5/10.
 */
public class OnlineUserListResult {
    private Integer count;     //保存数据库中数据总数
    private List<OnlineUserDO> onlineUserDOS;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<OnlineUserDO> getOnlineUserDOS() {
        return onlineUserDOS;
    }

    public void setOnlineUserDOS(List<OnlineUserDO> onlineUserDOS) {
        this.onlineUserDOS = onlineUserDOS;
    }

    @Override
    public String toString() {
        return "OnlineUserListResult{" +
                "count=" + count +
                ", onlineUserDOS=" + onlineUserDOS +
                '}';
    }
}
