package com.safintel.sql.statement.support;

public class Table{
    private String table;
    private String alias;
    private StringBuilder builder;

    public Table(String table, String alias) {
        this.table = table;
        this.alias = alias;
        builder = new StringBuilder(table).append(this.alias==null?"":new StringBuilder(" AS ").append(this.alias));
    }

    public Table(String table){
        this.table = table;
        builder = new StringBuilder(table).append(this.alias==null?"":new StringBuilder(" AS ").append(this.alias));
    }

    public String toSql() {
        return builder.toString();
    }
}