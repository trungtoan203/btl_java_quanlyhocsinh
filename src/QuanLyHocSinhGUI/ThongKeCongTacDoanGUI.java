/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuanLyHocSinhGUI;

import Engine.DBHocSinhEngine;
import HomeGUI.HomeGUI;
import Model.HocSinh;
import Utils.MessageDialogs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.*;

/**
 *
 * @author HoangCongMinh
 */
public class ThongKeCongTacDoanGUI extends javax.swing.JFrame {
    
    public DefaultTableModel tableModel;
    /**
     * Creates new form ThongKeGUI
     */
    public ThongKeCongTacDoanGUI() {
        initComponents();
        initTable();
        setLocationRelativeTo(null);
        LoadDataToTable();
    }
    
    public void initTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {"", "Đoàn Viên", "Đảng Viên"});
        tblThongKe.setModel(tableModel);
    }
    
    public void LoadDataToTable(){
        String type = (String)comboBox.getSelectedItem();
        
        if(type == "Toàn trường")
            LoadDataForSchool();
        if(type == "Lớp")
            LoadDataForClass();
    }
    
    public void LoadDataForSchool(){
        try{
            tableModel.setColumnIdentifiers(new String[] {"Toàn trường", "Đoàn Viên", "Đảng Viên"});
            DBHocSinhEngine db = new DBHocSinhEngine();
            List<HocSinh> dsHS = db.ReadDataFromFile();
            int[] count = {0, 0};
            for(HocSinh hs : dsHS){
                if(hs.getCongTacDoan().equalsIgnoreCase("Đoàn Viên")){
                    count[0]++;
                }
                else count[1]++;
            }
            tableModel.setRowCount(0);
            Object[] rowData = new Object[3];
            rowData[0] = null;
            Object[] rowRate = new Object[3];
            rowRate[0] = "Tỷ lệ";
            int sum = 0;
            for(int i = 0; i < count.length; i++){
                sum += count[i];
            }
            for(int i = 0; i < 2; i++){
                rowData[i + 1] = count[i];
                float number = ((float)count[i] / sum) * 100;
                String formattedNumber = String.format("%.2f", number);
                rowRate[i + 1] = formattedNumber + "%";
            }
            tableModel.addRow(rowData);
            tableModel.addRow(rowRate);
            tableModel.fireTableDataChanged();
        } catch(Exception ex) {
            ex.printStackTrace();
            MessageDialogs.ShowErrorMessage(this, ex.toString(), "Lỗi");
        }
    }
    public void LoadDataForClass(){
        try{
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(new String[] {"Lớp", "Đoàn Viên", "Đảng Viên"});
            DBHocSinhEngine db = new DBHocSinhEngine();
            List<HocSinh> dsHS = db.ReadDataFromFile();
            Collections.sort(dsHS, new Comparator<HocSinh>(){
                @Override
                public int compare(HocSinh hs1, HocSinh hs2){
                    return hs1.getLop().compareTo(hs2.getLop());
                }
            });
            int[] count = {0, 0};
            List<String> dsLop = new ArrayList<>();
            String tmp;
            for(int i = 0; i < dsHS.size(); i++){
                tmp = dsHS.get(i).getLop();
                if(dsLop.contains(tmp) == false){
                    dsLop.add(tmp);
                }
            }
            for(int i = 0; i < dsLop.size(); i++){
                for(HocSinh hs : dsHS){
                    if(hs.getLop().equals(dsLop.get(i))){
                        if(hs.getCongTacDoan().equalsIgnoreCase("Đoàn Viên")){
                            count[0]++;
                        }
                        else count[1]++;
                    }
                }
                Object[] rowData = new Object[3];
                rowData[0] = dsLop.get(i);
                Object[] rowRate = new Object[3];
                rowRate[0] = "Tỷ lệ";
                int sum = 0;
                for(int j = 0; j < count.length; j++){
                    sum += count[j];
                }
                for(int k = 0; k < 2; k++){
                    rowData[k + 1] = count[k];
                    float number = ((float)count[k] / sum) * 100;
                    String formattedNumber = String.format("%.2f", number);
                    rowRate[k + 1] = formattedNumber + "%";
                }
                tableModel.addRow(rowData);
                tableModel.addRow(rowRate);
                tableModel.addRow(new Object[]{null, null, null, null, null, null});
                tableModel.fireTableDataChanged();
                for(int u = 0; u < count.length; u++){
                    count[u] = 0;
                }
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
            MessageDialogs.ShowErrorMessage(this, ex.toString(), "Lỗi");
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

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        comboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnReThongKe = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Thống kê");

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "", "Đoàn Viên", "Đảng Viên"
            }
        ));
        JTableHeader header = tblThongKe.getTableHeader();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jScrollPane1.setViewportView(tblThongKe);
        tblThongKe.getAccessibleContext().setAccessibleDescription("");

        comboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toàn trường", "Lớp" }));
        comboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Thống kê cho:");

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnBack.setText("Trở về");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnReThongKe.setBackground(new java.awt.Color(51, 102, 255));
        btnReThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnReThongKe.setText("Thống Kê");
        btnReThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReThongKeActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnHome)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(btnReThongKe)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReThongKe)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new QuanLyHocSinhGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReThongKeActionPerformed
        String type = (String)comboBox.getSelectedItem();
        
        if(type == "Toàn trường")
            LoadDataForSchool();
        if(type == "Lớp")
            LoadDataForClass();
    }//GEN-LAST:event_btnReThongKeActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        new HomeGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeCongTacDoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeCongTacDoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeCongTacDoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeCongTacDoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeCongTacDoanGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReThongKe;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKe;
    // End of variables declaration//GEN-END:variables
}
