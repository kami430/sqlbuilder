package com.safintel.sql.statement.support;

public class Column{
    private String column;
    private String alias;
    private StringBuilder builder;

    public Column(String column, String alias) {
        this.column = column;
        this.alias = alias;
        builder = new StringBuilder(column).append(this.alias==null?"":new StringBuilder(" AS ").append(this.alias));
    }

    public Column(String column){
        this.column = column;
        builder = new StringBuilder(column).append(this.alias==null?"":new StringBuilder(" AS ").append(this.alias));
    }

    public String toSql() {
        return builder.toString();
    }
}
