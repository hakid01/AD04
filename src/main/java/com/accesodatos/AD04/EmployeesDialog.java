package com.accesodatos.AD04;

import com.accesodatos.AD04.entities.Employee;
import com.accesodatos.AD04.utilities.DB;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hak
 */
public class EmployeesDialog extends javax.swing.JDialog {

    DefaultListModel listModel;

    int nEmployees = 0;

    int idSelectedEmployee = 0;
    
    List<Employee> employees;

    /**
     * Creates new form CustomersDialog
     *
     * @param parent
     */
    public EmployeesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        listModel = new DefaultListModel();
        listEmployees.setModel(listModel);

        reloadList();
        if (listModel.isEmpty()) {
            lbError.setText("No hay ningún empleado");
        }
    }

    private void reloadList() {
        removeElements();
        employees= DB.getEmployees();
        
        ArrayList<String> employeesArrayList = new ArrayList<>();
        
        employees.forEach((employee) -> {
            employeesArrayList.add(employee.toString());
        });
        
        addElements(employeesArrayList);
    }

    private void addElements(ArrayList<String> employees) {
        nEmployees = employees.size();
        for (String employee : employees) {
            listModel.addElement(employee);
        }
    }

    private void removeElements() {
        int listLength = nEmployees;
        if (listLength != 0) {
            for (int i = listLength - 1; i >= 0; i--) {
                listModel.remove(i);
            }
        }
    }

    private void removeSelectedElement() {
        String selectedEmployee = listEmployees.getSelectedValue();
        if (selectedEmployee == null) {
            lbError.setText("Selecciona el empleado a eliminar.");
        } else {
            String[] dataSplit = selectedEmployee.split(" - ");
            String idString = dataSplit[0];
            System.out.println("Vamos a eliminar a " + selectedEmployee);
            int respuesta = JOptionPane.showConfirmDialog(null, "Quiere eliminar a \""
                    + dataSplit[1] + "\" de la lista de clientes?");
            if (respuesta == 0) {

                int idSelectedEmployee = Integer.valueOf(idString);
                
                DB.transactionDeleteOfDB(DB.getEmployee(idSelectedEmployee));
            }
        }
    }

    private void showStores() {
        String selectedEmployee = listEmployees.getSelectedValue();
        if (selectedEmployee == null) {
            lbError.setText("Selecciona el empleado a eliminar.");
        } else {
            String[] dataSplit = selectedEmployee.split(" - ");
            String idString = dataSplit[0];

            int idSelectedEmployee = Integer.valueOf(idString);

            EmployeeStoresDialog esd = new EmployeeStoresDialog(null, true, DB.getEmployee(idSelectedEmployee));
            esd.setVisible(true);
        }
    }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbEmpleados = new javax.swing.JLabel();
        btnAddEmployee = new javax.swing.JButton();
        btnDeleteEmployee = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEmployees = new javax.swing.JList<>();
        lbError = new javax.swing.JLabel();
        btnStores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbEmpleados.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmpleados.setText("Empleados Franquicia");

        btnAddEmployee.setText("Añadir empleado");
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        btnDeleteEmployee.setText("Eliminar empleado");
        btnDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEmployeeActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listEmployees);

        lbError.setForeground(new java.awt.Color(254, 95, 95));
        lbError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnStores.setText("Trabajando en ...");
        btnStores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnStores, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStores, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
        // TODO add your handling code here:
        lbError.setText("");
        EmployeeCreateDialog ecd = new EmployeeCreateDialog(null, true);
        ecd.setVisible(true);
        reloadList();
    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    private void btnDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmployeeActionPerformed
        // TODO add your handling code here:
        lbError.setText("");
        removeSelectedElement();
        reloadList();
    }//GEN-LAST:event_btnDeleteEmployeeActionPerformed

    private void btnStoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoresActionPerformed
        // TODO add your handling code here:
        showStores();
    }//GEN-LAST:event_btnStoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeesDialog dialog = new EmployeesDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnDeleteEmployee;
    private javax.swing.JButton btnStores;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbEmpleados;
    private javax.swing.JLabel lbError;
    private javax.swing.JList<String> listEmployees;
    // End of variables declaration//GEN-END:variables
}
