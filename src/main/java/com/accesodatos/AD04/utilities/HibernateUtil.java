/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.AD04.utilities;

import com.accesodatos.AD04.entities.Customer;
import com.accesodatos.AD04.entities.Employee;
import com.accesodatos.AD04.entities.EmployeeStore;
import com.accesodatos.AD04.entities.Item;
import com.accesodatos.AD04.entities.ItemStore;
import com.accesodatos.AD04.entities.Province;
import com.accesodatos.AD04.entities.Store;
import java.util.Properties;
import java.util.TimeZone;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author hak
 */
public class HibernateUtil {

    private static String address;
    private static String password;
    private static String port;
    private static String name;
    private static String user;

    private static String dialect;
    private static String driver;
    private static String hbm2ddl_auto;
    private static String show_sql;

    private static SessionFactory sessionFactory;

    //Este método devolve a sesión para poder facer operacións coa base de datos
    public static SessionFactory getSessionFactory() {

        loadConfig();
        //Se a sesion non se configurou, creamolo
        if (sessionFactory == null) {
            try {
                Configuration conf = new Configuration();

                //Engadimos as propiedades
                Properties settings = new Properties();

                //Indicamos o conector da base de datos que vamos a usar
                settings.put(Environment.DRIVER, driver);

                //Indicamos a localización da base de datos que vamos a utilizar
                settings.put(Environment.URL, createURLDB(address, port, name));

                //Indicamos o usuario da base de datos con cal nos vamos conectar e o seu contrasinal
                settings.put(Environment.USER, user);
                settings.put(Environment.PASS, password);

                //Indicamos o dialecto que ten que usar Hibernate 
                settings.put(Environment.DIALECT, dialect);

                //Indicamos que se as táboas todas se borren e se volvan crear
                settings.put(Environment.HBM2DDL_AUTO, hbm2ddl_auto);

                //Indicamos que se mostre as operacións SQL que Hibernate leva a cabo
                settings.put(Environment.SHOW_SQL, show_sql);
                conf.setProperties(settings);

                //Engaidmos aquelas clases nas que queremos facer persistencia
                conf.addAnnotatedClass(Customer.class);
                conf.addAnnotatedClass(Province.class);
                conf.addAnnotatedClass(Store.class);
                conf.addAnnotatedClass(Item.class);
                conf.addAnnotatedClass(Employee.class);
                conf.addAnnotatedClass(ItemStore.class);
                conf.addAnnotatedClass(EmployeeStore.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
                sessionFactory = conf.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static void loadConfig() {
        ManageJson mj = new ManageJson();

        Config c = (Config) mj.jsonToObj("/config.json", Config.class);

        address = c.getDbConnection().getAddress();
        name = c.getDbConnection().getName();
        password = c.getDbConnection().getPassword();
        port = c.getDbConnection().getPort();
        user = c.getDbConnection().getUser();

        dialect = c.getHibernate().getDialect();
        driver = c.getHibernate().getDriver();
        hbm2ddl_auto = c.getHibernate().getHBM2DDL_AUTO();
        show_sql = c.getHibernate().getSHOW_SQL();
    }

    private static String createURLDB(String address, String port, String name) {
        String url = "jdbc:mysql://" + address + ":" + port + "/" + name
                + "?serverTimezone=" + TimeZone.getDefault().getID();
        return url;
    }

}
