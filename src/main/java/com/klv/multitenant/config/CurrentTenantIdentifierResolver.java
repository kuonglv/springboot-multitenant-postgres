package com.klv.multitenant.config;

import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolver implements org.hibernate.context.spi.CurrentTenantIdentifierResolver {

    private final String defaultTenant = "public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String t = TenantContext.getTenantId();
        if (t != null) {
            return t;
        } else {
            return defaultTenant;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
