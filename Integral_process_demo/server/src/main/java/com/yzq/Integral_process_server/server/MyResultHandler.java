package com.yzq.Integral_process_server.server;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyResultHandler<T> implements ResultSetHandler<T> {

    private final Class<? extends T> aClass;

    public MyResultHandler(Class<? extends T> aClass) {
        this.aClass = aClass;
    }

    @Override
    public T handle(ResultSet resultSet) throws SQLException {
        return null;
    }
}
