/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.AD04.utilities;

/**
 *
 * @author hak
 */
public class Config {
    ConfigDB dbConnection;
    ConfigHibernate hibernate;

    public Config() {
    }

    public Config(ConfigDB dbConnection, ConfigHibernate hibernate) {
        this.dbConnection = dbConnection;
        this.hibernate = hibernate;
    }

    public ConfigDB getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(ConfigDB dbConnection) {
        this.dbConnection = dbConnection;
    }

    public ConfigHibernate getHibernate() {
        return hibernate;
    }

    public void setHibernate(ConfigHibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public String toString() {
        return "Config{" + "dbConnection=" + dbConnection + ", hibernate=" + hibernate + '}';
    }
    
    
}
