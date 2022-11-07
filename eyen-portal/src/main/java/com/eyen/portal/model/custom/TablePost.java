package com.eyen.portal.model.custom;

/**
 * bootstrap post 参数
 *
 * @author yuwenbo
 * @date 2022/11/7 23:27
 **/
public class TablePost {
    private int page;//页码
    private int limit;//数量
    private String orderByColumn;//排序字段
    private String isAsc;//排序字符 asc desc
    private String searchText;//列表table里面的搜索

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
