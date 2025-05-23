package gui;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class VSupplier extends javax.swing.JFrame {

    public Color genericColor = new Color(209, 220, 204);    
    private final AlternatingListCellRenderer cellRenderer;
    Connection connObj = null;
    Statement stateObj = null;
    ResultSet resultObj = null;
      
    private void getsuppliers()    {
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://192.168.1.16:3306/kbellplumb?useSSL=false", "admin", "1qaz2wsx");
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select supplierid, companyname, contact, address1, city, state, postalcode, phone, fax, terms, comments from supplier");
            supplier.setModel(DbUtils.resultSetToTableModel(resultObj));
            supplier.getColumn("supplierid").setHeaderValue("Supplier ID");
            supplier.getColumn("companyname").setHeaderValue("Company");
            supplier.getColumn("contact").setHeaderValue("Contact");
            supplier.getColumn("address1").setHeaderValue("Address");
            supplier.getColumn("city").setHeaderValue("City");
            supplier.getColumn("state").setHeaderValue("State");
            supplier.getColumn("postalcode").setHeaderValue("Postal Code");
            supplier.getColumn("phone").setHeaderValue("Phone");
            supplier.getColumn("fax").setHeaderValue("Fax");
            supplier.getColumn("terms").setHeaderValue("Terms");
            supplier.getColumn("comments").setHeaderValue("Comments");
            supplier.repaint();       
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private final DefaultListModel<NSupplier> supplierModel; 
    /**
     * Creates new form view_suppliers
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public VSupplier() {
        this.supplierModel = new DefaultListModel<>();
        this.cellRenderer = new AlternatingListCellRenderer();
        this.setResizable(false);
        initComponents();
        getsuppliers();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view_supplier_list = new javax.swing.JScrollPane();
        supplier = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        addSupplierButton = new javax.swing.JButton();
        updateSupplierButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Suppliers");

        view_supplier_list.setPreferredSize(new java.awt.Dimension(800, 402));

        supplier.setAutoCreateRowSorter(true);
        supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Company", "Contact", "Address", "City", "State", "Postal Code", "Phone", "Fax", "Terms", "Comments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplier.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() ==2 ) {
                    NSupplier addSupplier = new NSupplier((int)supplier.getValueAt(row, 0));
                    addSupplier.setVisible(true);
                }
            }
        });
        view_supplier_list.setViewportView(supplier);

        addSupplierButton.setText("Add Supplier");
        addSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierButtonActionPerformed(evt);
            }
        });

        updateSupplierButton.setText("Update Supplier");
        updateSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSupplierButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        refresh.setText("Refresh Page");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSupplierButton)
                .addGap(18, 18, 18)
                .addComponent(updateSupplierButton)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addGap(300, 300, 300))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSupplierButton)
                    .addComponent(updateSupplierButton)
                    .addComponent(closeButton)
                    .addComponent(refresh))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(view_supplier_list, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(view_supplier_list, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierButtonActionPerformed
        NSupplier addSupplier = new NSupplier(-1);
        addSupplier.setVisible(true);
    }//GEN-LAST:event_addSupplierButtonActionPerformed

    private void updateSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSupplierButtonActionPerformed
        int[] index = supplier.getSelectedRows();
        if(index.length <= 0){
            JOptionPane.showMessageDialog(null, "No supplier selected to update.");
        } 
        else if (index.length > 1){
            JOptionPane.showMessageDialog(null, "Select only one supplier to update.");
        }
        else{
            int id = (int) supplier.getValueAt(index[0], 0);
            NSupplier addSupplier = new NSupplier(id);
            addSupplier.setVisible(true);
        }
    }//GEN-LAST:event_updateSupplierButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        getsuppliers();
    }//GEN-LAST:event_refreshActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VSupplier().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSupplierButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton refresh;
    private javax.swing.JTable supplier;
    private javax.swing.JButton updateSupplierButton;
    private javax.swing.JScrollPane view_supplier_list;
    // End of variables declaration//GEN-END:variables
}
