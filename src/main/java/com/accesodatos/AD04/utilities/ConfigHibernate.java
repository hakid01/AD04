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
public class ConfigHibernate {
    private String driver;
    private String dialect;
    private String HBM2DDL_AUTO;
    private String SHOW_SQL;

    public ConfigHibernate() {
    }

    public ConfigHibernate(String driver, String dialect, String HBM2DDL_AUTO, String SHOW_SQL) {
        this.driver = driver;
        this.dialect = dialect;
        this.HBM2DDL_AUTO = HBM2DDL_AUTO;
        this.SHOW_SQL = SHOW_SQL;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getHBM2DDL_AUTO() {
        return HBM2DDL_AUTO;
    }

    public void setHBM2DDL_AUTO(String HBM2DDL_AUTO) {
        this.HBM2DDL_AUTO = HBM2DDL_AUTO;
    }

    public String getSHOW_SQL() {
        return SHOW_SQL;
    }

    public void setSHOW_SQL(String SHOW_SQL) {
        this.SHOW_SQL = SHOW_SQL;
    }

    @Override
    public String toString() {
        return "ConfigHibernate{" + "driver=" + driver + ", dialect=" + dialect + ", HBM2DDL_AUTO=" + HBM2DDL_AUTO + ", SHOW_SQL=" + SHOW_SQL + '}';
    }
    
    
}
