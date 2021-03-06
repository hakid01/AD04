package com.accesodatos.AD04;

import com.accesodatos.AD04.utilities.TitleXML;
import com.accesodatos.AD04.utilities.Title;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hak
 */
public class ElPaisDialog extends javax.swing.JDialog {

    DefaultListModel listModel;

    int nTitles = 0;

    /**
     * Creates new form CustomersDialog
     *
     * @param parent
     */
    public ElPaisDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        listModel = new DefaultListModel();
        listTitulares.setModel(listModel);

        addElements(rss());
    }

    private void addElements(ArrayList<String> titulares) {
        nTitles = titulares.size();
        for (String titular : titulares) {
            listModel.addElement(titular);
        }
    }

    private ArrayList<String> rss() {
        XMLReader procesadorXML = null;
        ArrayList<String> titlesStrings = new ArrayList<>();
        try {

            //Creamos un parseador de texto e engadimoslle a nosa clase que vai parsear o texto
            procesadorXML = XMLReaderFactory.createXMLReader();
            TitleXML persoasXML = new TitleXML();
            procesadorXML.setContentHandler(persoasXML);

            //Indicamos o texto donde estan gardadas as persoas
            InputSource web = new InputSource("http://ep00.epimg.net/rss/elpais/portada.xml");
            procesadorXML.parse(web);

            //ArrayList para return
            ArrayList<Title>titles = persoasXML.getTitles();
            for (int i = 0; i < titles.size(); i++) {
                Title tempTitle = titles.get(i);
//                System.out.println("Titular: " + tempTitle.getTitle());
                titlesStrings.add("Titular " + (i+1) + ": " + tempTitle.getTitle());
            }

        } catch (SAXException e) {
            System.out.println("Ocurriu un erro ao ler o arquivo XML");
        } catch (IOException e) {
            System.out.println("Ocurriu un erro ao ler o arquivo XML");
        }
        return titlesStrings;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbElPais = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTitulares = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbElPais.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbElPais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbElPais.setText("Titulares El País");

        jScrollPane2.setViewportView(listTitulares);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbElPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbElPais, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ElPaisDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElPaisDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElPaisDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElPaisDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ElPaisDialog dialog = new ElPaisDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbElPais;
    private javax.swing.JList<String> listTitulares;
    // End of variables declaration//GEN-END:variables
}
