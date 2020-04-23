package com.accesodatos.AD04;

import com.accesodatos.AD04.entities.Employee;
import com.accesodatos.AD04.entities.EmployeeStore;
import com.accesodatos.AD04.entities.Store;
import com.accesodatos.AD04.utilities.DB;
import com.accesodatos.AD04.utilities.ValidarCampos;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hak
 */
public class StoreEmployeeCreateDialog extends javax.swing.JDialog {

    int nEmployees = 0;

    Store selectedStore;

    List<Employee> employeesStore;
    List<Employee> employees;

    /**
     * Creates new form NewCustomerDialog
     */
    public StoreEmployeeCreateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public StoreEmployeeCreateDialog(java.awt.Frame parent, boolean modal, Store selectedStore) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);

        this.selectedStore = selectedStore;

        employees = DB.getEmployees();

        ArrayList<String> employeesArrayList = new ArrayList<>();

        employees.forEach((employee) -> {
            employeesArrayList.add(employee.toString());
        });
        addElements(employeesArrayList);

        if (employees.isEmpty()) {
            lbError.setText("Necesario añadir algún empleado a la franquicia.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAddEmployee = new javax.swing.JLabel();
        lbHoursWeek = new javax.swing.JLabel();
        txtFStock = new javax.swing.JTextField();
        lbEmployee = new javax.swing.JLabel();
        btnAcept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();
        comboEmployees = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbAddEmployee.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbAddEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAddEmployee.setText("Añadir pempleado");

        lbHoursWeek.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbHoursWeek.setText("Horas/ Semana");

        lbEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEmployee.setText("Empleado");

        btnAcept.setText("Aceptar");
        btnAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lbError.setForeground(new java.awt.Color(254, 95, 95));
        lbError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbHoursWeek, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lbEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFStock, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboEmployees, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 282, Short.MAX_VALUE)
                        .addComponent(btnAcept, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAddEmployee)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoursWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcept, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addElements(ArrayList<String> employees) {
        nEmployees = employees.size();
        for (String employee : employees) {
            comboEmployees.addItem(employee);
        }
    }

    private void btnAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptActionPerformed
        // TODO add your handling code here:

        employeesStore = DB.getEmployeesStore(selectedStore);

        String hoursString = txtFStock.getText();

        int employee_id = 0;
        int indexEmployee = comboEmployees.getSelectedIndex();
        System.out.println("INded:" + indexEmployee);

        if (employees.isEmpty()) {
            lbError.setText("No hay ningún empleado disponible, añadir empleado a la franquicia.");
        } else if (hoursString.isEmpty()) {
            lbError.setText("Rellena el campo de horas semanales");
        } else if (!ValidarCampos.validarEnteroPositivo(hoursString)) {
            lbError.setText("Número de hora incorrecto. Solo números enteros positivos.");
        } else {
            String employeeString = comboEmployees.getItemAt(indexEmployee);

            String[] employeeSplit = employeeString.split(" - ");
            String employee_idString = employeeSplit[0];
            
            employee_id = Integer.valueOf(employee_idString);
            Employee selectedEmployee = DB.getEmployee(employee_id);

            if (employeesStore.contains(selectedEmployee)) {
                lbError.setText("El empleado ya está asignado a la tienda. Utilice \"Actualizar horas\"");
            } else {

                int hours = Integer.valueOf(hoursString);

                DB.transactionAddToDB(new EmployeeStore(selectedStore, selectedEmployee, hours));

                dispose();
            }
        }


    }//GEN-LAST:event_btnAceptActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(StoreEmployeeCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreEmployeeCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreEmployeeCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreEmployeeCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StoreEmployeeCreateDialog dialog = new StoreEmployeeCreateDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAcept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> comboEmployees;
    private javax.swing.JLabel lbAddEmployee;
    private javax.swing.JLabel lbEmployee;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbHoursWeek;
    private javax.swing.JTextField txtFStock;
    // End of variables declaration//GEN-END:variables
}
