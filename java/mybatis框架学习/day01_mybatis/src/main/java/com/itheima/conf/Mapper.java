package com.itheima.conf;

public class Mapper {
    /**
     * QueryString  sql语句
     * ResultType   返回类型
     * @return
     */
    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String quertString) {
        this.queryString = quertString;
    }

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }

    private String queryString;
    private String ResultType;
}
