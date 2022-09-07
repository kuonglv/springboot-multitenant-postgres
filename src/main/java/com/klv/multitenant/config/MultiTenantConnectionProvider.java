package com.klv.multitenant.config;

import org.hibernate.service.UnknownUnwrapTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class MultiTenantConnectionProvider implements org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider {

    private final static Logger LOGGER = LoggerFactory.getLogger(MultiTenantConnectionProvider.class);

    private final DataSource datasource;

    public MultiTenantConnectionProvider(DataSource datasource) {
        this.datasource = datasource;
    }


    @Override
    public Connection getAnyConnection() throws SQLException {
        return datasource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        LOGGER.trace("Get connection for tenant {}", tenantIdentifier);

        final Connection connection = getAnyConnection();
        connection.setSchema(tenantIdentifier);
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        LOGGER.trace("Release connection for tenant {}", tenantIdentifier);
        connection.setSchema(null);
        releaseAnyConnection(connection);
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class aClass) {
        return org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider.class.isAssignableFrom(aClass);
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        if (org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider.class.isAssignableFrom(aClass)) {
            return (T) this;
        } else {
            throw new UnknownUnwrapTypeException(aClass);
        }
    }
}
