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
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author erifc
 */
public class DB {

    public DB() {
    }
    //********* Añadir datos objeto a la base de datos ***********

    public static void transactionAddToDB(Object obj) {
        Transaction tran = null;
        try {
            //Collemos a sesión de Hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzamos unha transacción
            tran = session.beginTransaction();

            //Gardamos o equipo
            session.save(obj);

            //Facemos un commit da transacción
            tran.commit();
            System.out.println("******* COMMIT ******");
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //********* Borrar datos objeto de la base de datos ***********
    public static void transactionDeleteOfDB(Object obj) {
        Transaction tran = null;
        try {
            //Collemos a sesión de Hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzamos unha transacción
            tran = session.beginTransaction();

            //Gardamos o equipo
            session.delete(obj);

            //Facemos un commit da transacción
            tran.commit();
            System.out.println("******* COMMIT ******");
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    //********* Actualizar datos objeto de la base de datos ***********
    public static void transactionUpdateDB(Object obj) {
        Transaction tran = null;
        try {
            //Collemos a sesión de Hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzamos unha transacción
            tran = session.beginTransaction();

            //Gardamos o equipo
            session.update(obj);

            //Facemos un commit da transacción
            tran.commit();
            System.out.println("******* COMMIT ******");
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //*********** Consultas a la base d datos *********
    public static ArrayList<String> getProvinces() {

        ArrayList<String> provincesStrings = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT p FROM Province p");
        List<Province> provinces = q1.list();
        provinces.forEach((province) -> {
            provincesStrings.add(province.toString());
        });

        return provincesStrings;
    }

    public static List<Customer> getCustomers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = q1.list();
  
        return customers;
    }

    public static Customer getCustomer(int id) {
        Customer customer;
        //Facemos unha consulta en HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //Facemos unha consulta en HQL
            Query hql2 = session.createQuery("SELECT c FROM Customer c WHERE c.customer_id=:n");
            hql2.setParameter("n", id);
            customer = (Customer) hql2.uniqueResult();
        }
        return customer;
    }

    public static List<Store> getStores() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT s FROM Store s");
        List<Store> stores = q1.list();

        return stores;
    }

    public static Store getStore(int id) {
        Store store;
        //Facemos unha consulta en HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //Facemos unha consulta en HQL
            Query hql2 = session.createQuery("SELECT s FROM Store s WHERE s.store_id=:n");
            hql2.setParameter("n", id);
            store = (Store) hql2.uniqueResult();
        }
        return store;
    }

    public static List<Employee> getEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = q1.list();

        return employees;
    }

    public static Employee getEmployee(int id) {
        Employee employee;
        //Facemos unha consulta en HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //Facemos unha consulta en HQL
            Query hql2 = session.createQuery("SELECT e FROM Employee e WHERE e.employee_id=:n");
            hql2.setParameter("n", id);
            employee = (Employee) hql2.uniqueResult();
        }
        return employee;
    }

    public static List<Item> getItems() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT i FROM Item i");
        List<Item> items = q1.list();

        return items;
    }

    public static Item getItem(int id) {
        Item item;
        //Facemos unha consulta en HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //Facemos unha consulta en HQL
            Query hql2 = session.createQuery("SELECT i FROM Item i WHERE i.item_id=:n");
            hql2.setParameter("n", id);
            item = (Item) hql2.uniqueResult();
        }
        return item;
    }

    public static List<String> getCustomersEmails() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT c.email FROM Customer c");
        List<String> emailsList = q1.list();
        return emailsList;
    }

    public static List<Store> getStoresEmployee(Employee employee) {
        //Collemos a sesión de Hibernate    
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Tamén podemos escoller recuperar só algún parámetro
        Query q2 = session.createQuery("SELECT e.store FROM EmployeeStore e WHERE e.employee=:n");
        q2.setParameter("n", employee);
        List<Store> storesEmployee = q2.list();

        return storesEmployee;
    }

    public static List<Employee> getEmployeesStore(Store selectedStore) {
        //Collemos a sesión de Hibernate    
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Tamén podemos escoller recuperar só algún parámetro
        Query q2 = session.createQuery("SELECT e.employee FROM EmployeeStore e WHERE e.store=:n");
        q2.setParameter("n", selectedStore);
        List<Employee> employees = q2.list();

        return employees;
    }

    public static List<Item> getItemsStore(Store selectedStore) {
        //Collemos a sesión de Hibernate    
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Tamén podemos escoller recuperar só algún parámetro
        Query q2 = session.createQuery("SELECT i.item FROM ItemStore i WHERE i.store=:n");
        q2.setParameter("n", selectedStore);
        List<Item> items = q2.list();

        return items;
    }

    public static ItemStore getItemStore(Item selectedItem, Store selectedStore) {
        ItemStore itemStore;
        //Facemos unha consulta en HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //Facemos unha consulta en HQL
            Query hql2 = session.createQuery("SELECT i FROM ItemStore i WHERE i.item=:it AND i.store=:st");
            hql2.setParameter("it", selectedItem);
            hql2.setParameter("st", selectedStore);
            itemStore = (ItemStore) hql2.uniqueResult();
        }
        return itemStore;
    }
    
    public static EmployeeStore getEmployeeStore(Employee selectedEmployee, Store selectedStore) {
        EmployeeStore employeeStore;
        //Facemos unha consulta en HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //Facemos unha consulta en HQL
            Query hql2 = session.createQuery("SELECT e FROM EmployeeStore e WHERE e.employee=:em AND e.store=:st");
            hql2.setParameter("em", selectedEmployee);
            hql2.setParameter("st", selectedStore);
            employeeStore = (EmployeeStore) hql2.uniqueResult();
        }
        return employeeStore;
    }
}
