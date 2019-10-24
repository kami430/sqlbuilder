package com.safintel.sql.statement.support;

import com.safintel.sql.statement.SelectCreator;

import java.util.UUID;

public class SubTable extends Table {

    private static int aliasIndex = 0;

    private String tableSql;
    private String alias;

    public SubTable(String tableSql, String alias) {
        super(tableSql, alias);
        this.tableSql = tableSql;
        this.alias = isEmpty(alias)?getRandomAlias():alias;
    }

    public SubTable(SelectCreator selectCreator,String alias){
        super(selectCreator.toSql(),alias);
        this.tableSql = selectCreator.toSql();
        this.alias = isEmpty(alias)?getRandomAlias():alias;
    }

    public SubTable(String tableSql) {
        super(tableSql);
        this.tableSql = tableSql;
        this.alias = getRandomAlias();
    }

    public SubTable(SelectCreator selectCreator) {
        super(selectCreator.toSql());
        this.tableSql = selectCreator.toSql();
        this.alias = getRandomAlias();
    }

    @Override
    public String toSql() {
        return new StringBuilder("(").append(this.tableSql).append(") AS ").append(this.alias).toString();
    }

    @Override
    public String getTable() {
        return new StringBuilder("(").append(this.tableSql).append(")").toString();
    }

    @Override
    public String getAlias() {
        return this.alias;
    }

    @Override
    public String getAliasNullToTable() {
        return this.alias;
    }

    private static String getRandomAlias() {
        return new StringBuilder("T_").append(UUID.randomUUID().toString().substring(0, 2)).append(aliasIndex=++aliasIndex<10?aliasIndex:0).toString();
    }

    private boolean isEmpty(String str){
        return str==null||str.trim().equals("");
    }
}
