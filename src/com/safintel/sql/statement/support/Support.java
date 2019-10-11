package com.safintel.sql.statement.support;

public class Support {

    public static Join join(String talbe1, String table2) {
        return join(talbe1, table2, null);
    }

    public static Join join(String table1, String table2, String table2Alias) {
        return new Join(table1, table2, table2Alias);
    }

    public static String column(String column){
        return new Column(column).toSql();
    }

    public static String column(String column, String alias) {
        return new Column(column,alias).toSql();
    }

    public static Table table(String table){
        return new Table(table);
    }

    public static Table table(String table, String alias) {
        return new Table(table,alias);
    }
}
