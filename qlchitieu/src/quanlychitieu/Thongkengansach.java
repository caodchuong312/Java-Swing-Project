package quanlychitieu;
import quanlychitieu.DAO.ChiTieuDAO;
import quanlychitieu.DAO.UserDAO;
import quanlychitieu.DAO.DanhMucDAO;
import quanlychitieu.DAO.NganSachDAO;
import quanlychitieu.models.NganSach;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class Thongkengansach extends javax.swing.JFrame {
    int userId = new UserDAO().getIdByUsername(UserManager.getCurrentUser());
    public Thongkengansach() {
        if(UserManager.getCurrentUser()==null){
            new Dangnhap().setVisible(true);
            this.dispose();
        }else{
            initComponents();
            fetchDataFromDatabase();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        filter = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Danh mục", "Ngân sách", "Số tiền còn lại", "Thời gian", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setMinWidth(0);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(0);
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
        jLabel1.setText("Thống kê ngân sách");

        filter.setText("Lọc");
        filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterMouseClicked(evt);
            }
        });
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        new Themngansach().show();
        this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int selectedRow = jTable1.getSelectedRow();
            int id = (int) jTable1.getValueAt(selectedRow, 4);
            NganSach nganSach = new NganSachDAO().layNganSachTheoID(id);
            new Thaydoingansach(nganSach).show();
            this.dispose();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        if (filter.isSelected()) {
            fetchDataFromDatabaseAndFilter();
            filter.setText("Bỏ lọc");
        }else{
            fetchDataFromDatabase();
            filter.setText("Lọc");
            fetchDataFromDatabase();
        }
    }//GEN-LAST:event_filterActionPerformed

    private void filterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_filterMouseClicked


        private void fetchDataFromDatabase() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
//        int userId = new UserDAO().getIdByUsername(UserManager.getCurrentUser());
        NganSachDAO NganSachDAO = new NganSachDAO();
        List<NganSach> danhSachNganSach= NganSachDAO.layDanhSachNganSachTheoUser(new UserDAO().getIdByUsername(UserManager.getCurrentUser()));
        for (NganSach ngansach : danhSachNganSach) {
            String danhmuc = new DanhMucDAO().getTenDanhMucById(ngansach.getDanhMucId());
            Double sotienconlai = ngansach.getNganSach() - new ChiTieuDAO().tinhTongChiTheoDanhMucVaUser(userId, ngansach.getDanhMucId());
            model.addRow(new Object[]{
                danhmuc, ngansach.getNganSach(),sotienconlai,ngansach.getThangNam(), ngansach.getId()
            });
        }
        
    }
    private void fetchDataFromDatabaseAndFilter() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);   
        NganSachDAO nganSachDAO = new NganSachDAO();
        int monthChooser = jMonthChooser1.getMonth()+1;        
        int yearChooser = jYearChooser1.getYear();
        String thangNam = String.format("%d-%02d", yearChooser, monthChooser);
        List<NganSach> danhsachNganSach = nganSachDAO.layDanhSachNganSachTheoUserVaThangNam(userId,thangNam);
        for (NganSach nganSach : danhsachNganSach) {
            String danhmuc = new DanhMucDAO().getTenDanhMucById(nganSach.getDanhMucId());
            Double sotienconlai = nganSach.getNganSach() - new ChiTieuDAO().tinhTongChiTheoDanhMucVaUserVaThangNam(userId, nganSach.getDanhMucId(), monthChooser, yearChooser);
            model.addRow(new Object[]{
                danhmuc, nganSach.getNganSach(), sotienconlai, nganSach.getThangNam(), nganSach.getId()
            });
        }  
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thongkengansach().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JToggleButton filter;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
