package com.safintel.sql.statement.support;

public class Support {
    //------------------- join ------------------------//
    public static Join _j(String talbe1, String table2) {
        return _j(talbe1, table2, null);
    }

    public static Join _j(String table1, String table2, String table2Alias) {
        return new Join(table1, table2, table2Alias);
    }

    public static Join _j(Table t1,Table t2){
        return _j(t1.getAliasNullToTable(),t2.getTable(),t2.getAlias());
    }

    //------------------- column ----------------------//
    public static String _c(String column){
        return new Column(column).toSql();
    }

    public static String _c(String column, String alias) {
        return new Column(column,alias).toSql();
    }

    //------------------- table -----------------------//
    public static Table _t(String table){
        return new Table(table);
    }

    public static Table _t(String table, String alias) {
        return new Table(table,alias);
    }

    //------------------- where column -------------------//
    public static String _w(Table t1,String column){
        return new StringBuilder(t1.getAliasNullToTable()).append(".").append(column).toString();
    }
}
