package com.safintel.sql.statement;

public class Join {

    public static SubJoin join(String talbe1, String table2) {
        return join(talbe1, table2, null);
    }

    public static SubJoin join(String table1, String table2, String table2Alias) {
        return new SubJoin(table1,table2,table2Alias);
    }

    public static class SubJoin {
        private boolean first = true;
        private String table1;
        private String table2;
        private String table2Alias;
        private StringBuilder builder;

        public SubJoin(String table1, String table2, String table2Alias) {
            this.table1 = table1;
            this.table2 = table2;
            this.table2Alias = table2Alias;
            builder=new StringBuilder((this.table2Alias==null?this.table2
                    :new StringBuilder(this.table2).append(" AS ").append(this.table2Alias).append(" ON ")));
        }

        public SubJoin on(String field1, String field2) {
            return on(field1,field2,JoinFlag.EQ);
        }

        public SubJoin on(String field1, String field2,JoinFlag flag) {
            builder.append(first?"":" AND ")
                    .append(table1).append(".").append(field1).append(" ")
                    .append(flag.getFlag()).append(" ")
                    .append(this.table2Alias==null?this.table2:this.table2Alias)
                    .append(".").append(field2);
            first=first?false:false;
            return this;
        }

        public SubJoin onOr(String field1, String field2) {
            return onOr(field1,field2,JoinFlag.EQ);
        }

        public SubJoin onOr(String field1, String field2,JoinFlag flag) {
            builder.append(first?"":" OR ")
                    .append(table1).append(".").append(field1).append(" ")
                    .append(flag.getFlag()).append(" ")
                    .append(this.table2Alias==null?this.table2:this.table2Alias)
                    .append(".").append(field2);
            first=first?false:false;
            return this;
        }

        public String toSql(){
            return builder.toString();
        }
    }

    public enum JoinFlag{
        EQ("="), LE("<="), GE(">="), LT("<"), GT( ">");
        private final String val;
        private JoinFlag(String flag) {
            this.val = flag;
        }
        public String getFlag() {
            return val;
        }
    }
}
