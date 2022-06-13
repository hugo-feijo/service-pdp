package com.pdp.servicepdp.abstratas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbProperties {
    @Value("${database.url}")
    private String databaseUrl;
    public static String DATABASE_URL;

    @Value("${database.user}")
    private String databaseUser;
    public static String DATABASE_USER;

    @Value("${database.password}")
    private String databasePassword;
    public static String DATABASE_PASSWORD;

    @Value("${database.url}")
    public void setDatabaseUrlStatic(String databaseUrl){
        DbProperties.DATABASE_URL = databaseUrl;
    }

    @Value("${database.user}")
    public void setDatabaseUserStatic(String databaseUser){
        DbProperties.DATABASE_USER = databaseUser;
    }

    @Value("${database.password}")
    public void setDatabasePasswordStatic(String databasePassword){
        DbProperties.DATABASE_PASSWORD = databasePassword;
    }
}
