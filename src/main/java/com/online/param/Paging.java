package com.online.param;

/**
 * Created by panlu02 on 2017/5/7.
 */
public class Paging {
    /**
     * 是否分页
     */
    private Boolean paging = true;
    /**
     * 页索引
     */
    private Integer pageIndex = 1;
    /**
     * 页大小
     */
    private Integer pageSize = 10;

    public Boolean getPaging() {
        return paging;
    }

    public void setPaging(Boolean paging) {
        this.paging = paging;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
