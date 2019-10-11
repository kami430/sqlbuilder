package com.safintel.sql.statement;

public class SQL {

    public static SelectCreator select(){
        return new SelectCreator();
    }

    public static SelectCreator select(SelectCreator selectCreator){
        return new SelectCreator(selectCreator);
    }

    public static InsertCreator insert(String table){
        return new InsertCreator(table);
    }

    public static UpdateCreator update(String table){
        return new UpdateCreator(table);
    }

    public static DeleteCreator delete(String table){
        return new DeleteCreator(table);
    }
}
