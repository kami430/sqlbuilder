package com.safintel.sql.statement.support;

public class Join {
    private boolean first = true;
    private String table1;
    private String table2;
    private String table2Alias;
    private StringBuilder builder;

    public Join(String table1, String table2, String table2Alias) {
        this.table1 = table1;
        this.table2 = table2;
        this.table2Alias = table2Alias;
        builder = new StringBuilder((this.table2Alias == null ? this.table2
                : new StringBuilder(this.table2).append(" AS ").append(this.table2Alias))).append(" ON ");
    }

    public Join on(String field1, String field2) {
        return on(field1, field2, JoinFlag.EQ);
    }

    public Join on(String field1, String field2, JoinFlag flag) {
        builder.append(first ? "" : " AND ")
                .append(table1).append(".").append(field1).append(" ")
                .append(flag.getFlag()).append(" ")
                .append(this.table2Alias == null ? this.table2 : this.table2Alias)
                .append(".").append(field2);
        first = first ? false : false;
        return this;
    }

    public Join onOr(String field1, String field2) {
        return onOr(field1, field2, JoinFlag.EQ);
    }

    public Join onOr(String field1, String field2, JoinFlag flag) {
        builder.append(first ? "" : " OR ")
                .append(table1).append(".").append(field1).append(" ")
                .append(flag.getFlag()).append(" ")
                .append(this.table2Alias == null ? this.table2 : this.table2Alias)
                .append(".").append(field2);
        first = first ? false : false;
        return this;
    }

    public String toSql() {
        return builder.toString();
    }


    public enum JoinFlag {
        EQ("="), LE("<="), GE(">="), LT("<"), GT(">");
        private final String val;

        private JoinFlag(String flag) {
            this.val = flag;
        }

        public String getFlag() {
            return val;
        }
    }
}
