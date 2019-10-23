package com.safintel.sql.statement.support;

public class Table{
    private String table;
    private String alias;
    private StringBuilder builder;

    public Table(String table, String alias) {
        this.table = table;
        this.alias = alias;
        builder = new StringBuilder(table).append(isEmpty(this.alias)?"":new StringBuilder(" AS ").append(this.alias));
    }

    public Table(String table){
        this.table = table;
        builder = new StringBuilder(table).append(isEmpty(this.alias)?"":new StringBuilder(" AS ").append(this.alias));
    }

    public String toSql() {
        return builder.toString();
    }

    public String getTable() {return this.table;}

    public String getAlias(){
        return isEmpty(this.alias)?null:this.alias;
    }

    public String getAliasNullToTable(){
        return isEmpty(this.alias)?this.table:this.alias;
    }

    private boolean isEmpty(String str){
        return str==null||str.trim().equals("");
    }
}