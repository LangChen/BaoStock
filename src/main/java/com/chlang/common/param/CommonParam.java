package com.chlang.common.param;

/**
 * 通用搜索参数
 */
public class CommonParam {

    /**
     * 页数
     */
    private Integer pageNum;
    /**
     * 每页行数
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
