package com.middleware.app.cow.utils;

import org.apache.ibatis.jdbc.SQL;

public class SelectSqlBuilder {

    private static final String ALL_COLUMNS = "*";
    private static final String SPACE = " ";
    public static final String PURCHASE_ORDER = "purchaseOrder";

    public static String build(final String table,
                               final String conditions, final String orderByColumn) {

        if(conditions != null)
            return new SQL(){{SELECT(ALL_COLUMNS);FROM(table);WHERE(conditions);ORDER_BY(orderByColumn);}}.toString() + ";";
        else
            if(orderByColumn != null)
                return new SQL(){{SELECT(ALL_COLUMNS);FROM(table);ORDER_BY(orderByColumn);}}.toString() + ";";
            else
                return new SQL(){{SELECT(ALL_COLUMNS);FROM(table);}}.toString() + ";";
    }

    public static String nameTable(String table) {
        if(table.equals("Order")) {
            return PURCHASE_ORDER + SPACE + table.toLowerCase().substring(0, 1);
        } else {
            return table + SPACE + table.toLowerCase();
        }
    }
}
