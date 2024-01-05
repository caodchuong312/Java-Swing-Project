/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlychitieu;

import quanlychitieu.DAO.ChiTieuDAO;
import quanlychitieu.DAO.UserDAO;
import quanlychitieu.DAO.DanhMucDAO;
import quanlychitieu.models.ChiTieu;
import java.sql.Date;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Thongkegiaodich extends javax.swing.JFrame {
    int userID = new UserDAO().getIdByUsername(UserManager.getCurrentUser());
    public Thongkegiaodich() {
        if(UserManager.getCurrentUser()==null){
            new Dangnhap().setVisible(true);
            this.dispose();
        }else{
            initComponents();
            double tongThu = new ChiTieuDAO().tinhTongThu(userID);
            double tongChi = new ChiTieuDAO().tinhTongChi(userID);
            double soDu = tongThu - tongChi;
            jLabel3.setText("Tổng thu: " + tongThu);
            chi.setText("Tổng chi: " + tongChi);
            sodu.setText("Số dư: " + soDu);
            fetchDataFromDatabase();
        }              
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chi = new javax.swing.JLabel();
        sodu = new javax.swing.JLabel();
        month = new com.toedter.calendar.JMonthChooser();
        year = new com.toedter.calendar.JYearChooser();
        filter = new javax.swing.JToggleButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thời gian", "Danh mục", "Số tiền", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMinWidth(0);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        back.setText("Trở lại");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        add.setText("Thêm");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Thống kê giao dịch");

        jLabel3.setText("Tổng thu: 7.000.000");

        chi.setText("Tổng chi: 4.420.000");

        sodu.setText("Số dư: 2.580.000");

        month.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                monthAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        month.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthPropertyChange(evt);
            }
        });

        year.setPreferredSize(new java.awt.Dimension(66, 22));

        filter.setText("Lọc");
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sodu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chi)
                    .addComponent(sodu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(add))
                .addGap(9, 9, 9))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new Quanlychitieu().show();
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        new Themgiaodich().show();
        this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int selectedRow = jTable1.getSelectedRow();
            int id = (int) jTable1.getValueAt(selectedRow, 3);
            ChiTieu chiTieu = new ChiTieuDAO().layChiTieuTheoId(id);
            new Thaydoigiaodich(chiTieu).show();
            this.dispose();
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed

        if (filter.isSelected()) {
            int monthChooser = month.getMonth()+1;
            int yearChooser = year.getYear();
            fetchDataFromDatabaseAndFilter();
            double tongThu = new ChiTieuDAO().tinhTongThuTheoThangNam(userID, monthChooser, yearChooser);
            double tongChi = new ChiTieuDAO().tinhTongChiTheoThangNam(userID, monthChooser, yearChooser);
            double soDu = tongThu - tongChi;
            jLabel3.setText("Tổng thu: " + tongThu);
            chi.setText("Tổng chi: " + tongChi);
            sodu.setText("Số dư: " + soDu);
            filter.setText("Bỏ lọc");
        }else{
            double tongThu = new ChiTieuDAO().tinhTongThu(userID);
            double tongChi = new ChiTieuDAO().tinhTongChi(userID);
            double soDu = tongThu - tongChi;
            jLabel3.setText("Tổng thu: " + tongThu);
            chi.setText("Tổng chi: " + tongChi);
            sodu.setText("Số dư: " + soDu);
            filter.setText("Lọc");
            fetchDataFromDatabase();
        }
    }//GEN-LAST:event_filterActionPerformed

    private void monthAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_monthAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_monthAncestorAdded

    private void monthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthPropertyChange

    }//GEN-LAST:event_monthPropertyChange

    private void fetchDataFromDatabase() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        ChiTieuDAO chiTieuDAO = new ChiTieuDAO();
        List<ChiTieu> danhSachChiTieu = chiTieuDAO.layDanhSachChiTieuTheoUser(new UserDAO().getIdByUsername(UserManager.getCurrentUser()));
        for (ChiTieu chiTieu : danhSachChiTieu) {
            model.addRow(new Object[]{
                chiTieu.getNgay(), new DanhMucDAO().getTenDanhMucById(chiTieu.getDanhMucId()), chiTieu.getTien(),chiTieu.getId()
            });
        }
    }
    private void fetchDataFromDatabaseAndFilter() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        ChiTieuDAO chiTieuDAO = new ChiTieuDAO();
        int monthChooser = month.getMonth()+1;        
        int yearChooser = year.getYear();
        List<ChiTieu> danhSachChiTieu = chiTieuDAO.layDanhSachChiTieuTheoUserVaFilter(new UserDAO().getIdByUsername(UserManager.getCurrentUser()),monthChooser, yearChooser);
        for (ChiTieu chiTieu : danhSachChiTieu) {

            model.addRow(new Object[]{
                chiTieu.getNgay(), new DanhMucDAO().getTenDanhMucById(chiTieu.getDanhMucId()), chiTieu.getTien(),chiTieu.getId()
            });
        }  
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thongkegiaodich().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JLabel chi;
    private javax.swing.JToggleButton filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JLabel sodu;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
