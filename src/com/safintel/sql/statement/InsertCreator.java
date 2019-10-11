package com.safintel.sql.statement;

import java.io.Serializable;

/**
 * A Spring PreparedStatementCreator that you can use like an InsertBuilder.
 * Example usage is as follows:
 *
 * <pre>
 * PreparedStatementCreator psc = new InsertCreator(&quot;emp&quot;).setRaw(&quot;id&quot;, &quot;emp_id_seq.nextval&quot;).setValue(&quot;name&quot;,
 *         employee.getName());
 *
 * new JdbcTemplate(dataSource).update(psc);
 * </pre>
 *
 * @author John Krasnay <john@krasnay.ca>
 */
public class InsertCreator implements Serializable {

    private static final long serialVersionUID = 1;

    private InsertBuilder builder;

    private ParameterizedPreparedStatementCreator ppsc = new ParameterizedPreparedStatementCreator();

    public InsertCreator(String table) {
        builder = new InsertBuilder(table);
    }

    public ParameterizedPreparedStatementCreator setParameter(String name, Object value) {
        return ppsc.setParameter(name, value);
    }

    public InsertCreator setRaw(String column, String value) {
        builder.set(column, value);
        return this;
    }

    public InsertCreator setValue(String column, Object value) {
        setRaw(column, ":" + column);
        setParameter(column, value);
        return this;
    }

}
