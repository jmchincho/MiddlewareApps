package com.middleware.app.cow.utils;

public class Select {

    private static final String SELECT_FROM = "select * from ";
    private static final String OFFSET = " offset ";
    private static final String ROWS_FETCH_NEXT = " rows fetch next ";
    private static final String ROWS_ONLY = " rows only";
    private static final String WHERE = " where ";
    private static final String ORDER_BY = " order by ";

    public static String createSelectFindAll(String entity, String where, String orderBy, Integer page, Integer perPage) {
        String res = SELECT_FROM + entity;

        res = (where != null ) ? res + WHERE + where : res;
        res = (orderBy != null ) ? res + ORDER_BY + orderBy : res;
        res = (page != null && perPage != null ) ? res + OFFSET + perPage * page + ROWS_FETCH_NEXT + perPage + ROWS_ONLY : res;

        return res;
    }

}
