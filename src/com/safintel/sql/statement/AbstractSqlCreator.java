package com.safintel.sql.statement;

import java.io.Serializable;
import java.util.Map;

/**
 * Abstract base class of SQL creator classes.
 *
 * @author <a href="mailto:john@krasnay.ca">John Krasnay</a>
 */
public abstract class AbstractSqlCreator implements Serializable {

    private int paramIndex;

    private ParameterizedPreparedStatementCreator ppsc = new ParameterizedPreparedStatementCreator();

    public AbstractSqlCreator() {

    }

    /**
     * Copy constructor. Used by cloneable creators.
     *
     * @param other AbstractSqlCreator being cloned.
     */
    public AbstractSqlCreator(AbstractSqlCreator other) {
        this.paramIndex = other.paramIndex;
        this.ppsc = other.ppsc.clone();
    }

    /**
     * Allocate and return a new parameter that is unique within this
     * SelectCreator. The parameter is of the form "paramN", where N is an
     * integer that is incremented each time this method is called.
     */
    public String allocateParameter() {
        return "param" + paramIndex++;
    }

    /**
     * Returns the builder for this creator.
     */
    protected abstract AbstractSqlBuilder getBuilder();

    /**
     * Returns the prepared statement creator for this creator.
     */
    protected ParameterizedPreparedStatementCreator getPreparedStatementCreator() {
        return ppsc;
    }

    /**
     * Sets a parameter for the creator.
     */
    public AbstractSqlCreator setParameter(String name, Object value) {
        ppsc.setParameter(name, value);
        return this;
    }

    public Map<String, Object> getParameter() {
        return ppsc.getParameterMap();
    }

    @Override
    public String toString() {
        return ppsc.setSql(getBuilder().toString()).toString();
    }

    public String toSql() {
        return ppsc.setSql(getBuilder().toString()).toString();
    }

}
