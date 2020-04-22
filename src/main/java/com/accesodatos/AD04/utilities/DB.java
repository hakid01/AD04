/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.AD04.utilities;

import com.accesodatos.AD04.entities.Customer;
import com.accesodatos.AD04.entities.Employee;
import com.accesodatos.AD04.entities.Item;
import com.accesodatos.AD04.entities.Province;
import com.accesodatos.AD04.entities.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public static ArrayList<String> getCustomers() {

        ArrayList<String> customersStrings = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = q1.list();
        customers.forEach((customer) -> {
            customersStrings.add(customer.toString());
        });

        return customersStrings;
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
    
    public static ArrayList<String> getStores() {

        ArrayList<String> storesStrings = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT s FROM Store s");
        List<Store> stores = q1.list();
        stores.forEach((store) -> {
            storesStrings.add(store.toString());
        });

        return storesStrings;
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

    public static ArrayList<String> getEmployees() {

        ArrayList<String> employeesStrings = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = q1.list();
        employees.forEach((employee) -> {
            employeesStrings.add(employee.toString());
        });

        return employeesStrings;
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

    public static ArrayList<String> getItems() {

        ArrayList<String> itemsStrings = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Facemos unha consulta
        Query q1 = session.createQuery("SELECT i FROM Item i");
        List<Item> items = q1.list();
        items.forEach((item) -> {
            itemsStrings.add(item.toString());
        });

        return itemsStrings;
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

    public static ArrayList<String> getStoresEmployee(Employee employee) {
        ArrayList<String> storesEmployeeStrings = new ArrayList<>();
        //Collemos a sesión de Hibernate    
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Tamén podemos escoller recuperar só algún parámetro
        Query q2 = session.createQuery("SELECT e.store FROM EmployeeStore e WHERE e.employee=:n");
        q2.setParameter("n", employee);
        List<Store> stores = q2.list();
          stores.forEach((store) -> {
            storesEmployeeStrings.add(store.toString());
        });
          
        return storesEmployeeStrings;
    }
    
    public static ArrayList<String> getEmployeesStore(Store selectedStore) {
        ArrayList<String> employeeStoreStrings = new ArrayList<>();
        //Collemos a sesión de Hibernate    
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Tamén podemos escoller recuperar só algún parámetro
        Query q2 = session.createQuery("SELECT e.employee FROM EmployeeStore e WHERE e.store=:n");
        q2.setParameter("n", selectedStore);
        List<Employee> employees = q2.list();
          employees.forEach((employee) -> {
            employeeStoreStrings.add(employee.toString());
        });
          
        return employeeStoreStrings;
    }
    
    public static ArrayList<String> getItemsStore(Store selectedStore) {
        ArrayList<String> itemsStoreStrings = new ArrayList<>();
        //Collemos a sesión de Hibernate    
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Tamén podemos escoller recuperar só algún parámetro
        Query q2 = session.createQuery("SELECT i.item FROM ItemStore i WHERE i.store=:n");
        q2.setParameter("n", selectedStore);
        List<Item> items = q2.list();
          items.forEach((item) -> {
            itemsStoreStrings.add(item.toString());
        });
          
        return itemsStoreStrings;
    }
    
        public static Item getItemStore(int id, Store selectedStore) {
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

    
    
    
    //********* Metodos para consultas ************
    public static ArrayList<String> getProvinces(Connection con) {

        ArrayList<String> provinces = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select * from provinces order by province_id");
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas
                String province_id = rs.getString("province_id");
                String name = rs.getString("name");
                System.out.println("Provincia: " + province_id + " " + name);
                provinces.add(name);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return provinces;
    }


    public static ArrayList<String> getStores(Connection con) {

        ArrayList<String> stores = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select s.store_id, s.name, s.town, p.name "
                    + "from stores s, provinces p where s.province_id = p.province_id");
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas
                int store_id = rs.getInt(1);
                String name = rs.getString(2);
                String town = rs.getString(3);
                String province = rs.getString(4);
                System.out.println("Tienda: " + store_id + " - " + name + ", " + town + " -> " + province);
                stores.add("" + store_id + " - " + name + ", " + town + " (" + province + ")");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return stores;
    }


    public static ArrayList<String> getItemsStore(Connection con, int store_id) {

        ArrayList<String> items = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select i.name, i.item_id, x.stock from items i, item_store x "
                    + "where i.item_id = x.item_id and x.store_id = " + store_id);
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas
                String name = rs.getString(1);
                int item_id = rs.getInt(2);
                int stock = rs.getInt(3);
                System.out.println("Id: " + item_id + " Producto: " + name + " - Stock: " + stock);
                items.add("" + item_id + " - " + name + " - Stock: " + stock);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return items;
    }

    public static ArrayList<String> getIdsItemsStore(Connection con, int store_id) {

        ArrayList<String> idsItems = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select i.item_id from items i, item_store x "
                    + "where i.item_id = x.item_id and x.store_id = " + store_id);
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas

                int item_id = rs.getInt(1);

                System.out.println("Id: " + item_id);
                idsItems.add("" + item_id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return idsItems;
    }

    public static ArrayList<String> getEmployeesStore(Connection con, int store_id) {

        ArrayList<String> employees = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select e.employee_id, e.name, e.surname, x.hours "
                    + "from employees e, employee_store x "
                    + "where e.employee_id = x.employee_id and x.store_id = " + store_id);
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas
                int employee_id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                int hours = rs.getInt(4);
                System.out.println("Id: " + employee_id + " Empleado: " + name + " " + surname + " - Horas: " + hours);
                employees.add("" + employee_id + " - " + name + " " + surname + " - Horas: " + hours);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return employees;
    }

    public static ArrayList<String> getIdsEmployeesStore(Connection con, int store_id) {

        ArrayList<String> idsEmployees = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select e.employee_id "
                    + "from employees e, employee_store x "
                    + "where e.employee_id = x.employee_id and x.store_id = " + store_id);
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas
                int employee_id = rs.getInt(1);
                System.out.println("Id: " + employee_id);
                idsEmployees.add("" + employee_id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return idsEmployees;
    }

    public static ArrayList<String> getStoresEmployee(Connection con, int employee_id) {

        ArrayList<String> stores = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            //Probamos a realizar unha consulta
            ResultSet rs = statement.executeQuery("select s.store_id, s.name, s.town, p.name "
                    + "from stores s, employee_store x, provinces p "
                    + "where s.store_id = x.store_id and p.province_id = s.province_id and x.employee_id = " + employee_id);
            System.out.println("antes del while");
            while (rs.next()) {
                //imprimimos o nome de todolas persoas
                int store_id = rs.getInt(1);
                String store_name = rs.getString(2);
                String store_town = rs.getString(3);
                String province_name = rs.getString(4);
                System.out.println("Id: " + store_id + " Empleado: " + store_name + " " + store_town + " - Horas: " + province_name);
                stores.add("" + store_id + " - " + store_name + ". Ciudad: " + store_town + ". Provincia: " + province_name);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return stores;
    }

    //*********** Métdodos para borrar datos *************
    public static void deleteCustormer(Connection con, String email) {
        try {
            String sql = "DELETE FROM customers WHERE email = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            System.out.println("Cliente borrado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteEmployee(Connection con, int idSelectedEmployee) {
        try {
            String sql = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idSelectedEmployee);
            pstmt.executeUpdate();
            System.out.println("Empleado borrado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteItem(Connection con, int id) {
        try {
            String sql = "DELETE FROM items WHERE item_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Producto borrado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteItemStore(Connection con, int store_id, int item_id) {
        try {
            String sql = "DELETE FROM item_store WHERE store_id = ? and item_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, store_id);
            pstmt.setInt(2, item_id);
            pstmt.executeUpdate();
            System.out.println("Producto borrado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteEmployeeStore(Connection con, int store_id, int employee_id) {
        try {
            String sql = "DELETE FROM employee_store WHERE store_id = ? and employee_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, store_id);
            pstmt.setInt(2, employee_id);
            pstmt.executeUpdate();
            System.out.println("Empleado borrado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteStore(Connection con, int id) {
        try {
            String sql = "DELETE FROM stores WHERE store_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Producto borrado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //*********** Metodos para actualizar datos ***********
    public static void updateStockItem_Store(Connection con, int newStock, int store_id, int item_id) {
        try {
            String sql = "UPDATE item_store SET stock = ? "
                    + "WHERE store_id = ? AND item_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, newStock);
            pstmt.setInt(2, store_id);
            pstmt.setInt(3, item_id);
            pstmt.executeUpdate();
            System.out.println("Stock actualizado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void updateHoursEmployee_Store(Connection con, int newHours, int store_id, int employee_id) {
        try {
            String sql = "UPDATE employee_store SET hours = ? "
                    + "WHERE store_id = ? AND employee_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, newHours);
            pstmt.setInt(2, store_id);
            pstmt.setInt(3, employee_id);
            pstmt.executeUpdate();
            System.out.println("Número de horas semanales actualizado con éxito");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
