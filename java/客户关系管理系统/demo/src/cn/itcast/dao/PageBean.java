package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public class PageBean<T> {
    @Override
    public String toString() {
        return "PageBean{" +
                "totalcount=" + totalcount +
                ", currentpage=" + currentpage +
                ", pagelist=" + pagelist +
                ", pagecount=" + pagecount +
                ", rows=" + rows +
                '}';
    }
    private int currentpage;
    private List<User> pagelist;
    private int pagecount;
    private int rows;
    private int totalcount;

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public List<User> getPagelist() {
        return pagelist;
    }

    public void setPagelist(List<User> pagelist) {
        this.pagelist = pagelist;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }



}
