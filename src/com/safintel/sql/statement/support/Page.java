package com.safintel.sql.statement.support;

public class Page {
    private Integer pageIndex;
    private Integer pageSize;

    public Page(Integer pageIndex,Integer pageSize){
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getOffset(){
        return (pageIndex-1)*pageSize;
    }

    public Integer getLimit(){
        return pageSize;
    }
}
