package com.online.param;

/**
 * Created by panlu02 on 2017/5/7.
 */
public class QueryOnlineUserParam extends Paging {
    private Integer type;
    private Long id;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QueryOnlineUserParam{" +
                "type=" + type +
                ", id=" + id +
                '}';
    }
}
