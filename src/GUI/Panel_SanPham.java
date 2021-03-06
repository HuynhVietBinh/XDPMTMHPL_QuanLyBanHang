/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.SanPhamBLL;
import DAL.StorageDAL;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Win 10
 */
public class Panel_SanPham extends javax.swing.JPanel {

    DefaultTableModel dtmsp;
    ArrayList<SanPhamDTO> spList;
    
    public Panel_SanPham() {
        initComponents();
        this.setBounds(0, 0, 786, 632);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        dtmsp = (DefaultTableModel) tblsp.getModel();
        showSP();
        TimKiem();
        reload();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
        public void showSP(){
            spList = SanPhamBLL.loadDataSanPham();
            dtmsp.setRowCount(0);
            spList.forEach((SanPhamDTO) -> {
                dtmsp.addRow(new Object[]{SanPhamDTO.getId(), SanPhamDTO.getMaLoai(), SanPhamDTO.getMaHieu(),
                    SanPhamDTO.getTenSP(), SanPhamDTO.getGia(), SanPhamDTO.getMota(), SanPhamDTO.getSl(), SanPhamDTO.getImage(),
                    SanPhamDTO.getKeyword()});
            });
        }

        public void TimKiem() {
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblsp.getModel());
            tblsp.setRowSorter(rowSorter);
            txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent de) {
                    String text = txtTimKiem.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    String text = txtTimKiem.getText();
                    if (text.length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblsp = new javax.swing.JTable();
        btnReload = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setBackground(new java.awt.Color(96, 166, 254));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(786, 629));

        jLabel1.setBackground(new java.awt.Color(0, 153, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("QU???N L?? S???N PH???M");

        btnThem.setBackground(new java.awt.Color(153, 153, 153));
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(153, 153, 153));
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setText("X??a");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 153));
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setText("S???a");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        tblsp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? SP", "Lo???i", "Hi???u", "T??n s???n ph???m", "Gi??", "M?? t???", "S??? l?????ng", "???nh", "Keyword"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsp.setRowHeight(20);
        tblsp.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblsp.setShowVerticalLines(false);
        tblsp.getTableHeader().setReorderingAllowed(false);
        tblsp.setUpdateSelectionOnSort(false);
        tblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblspMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblsp);
        if (tblsp.getColumnModel().getColumnCount() > 0) {
            tblsp.getColumnModel().getColumn(0).setMinWidth(45);
            tblsp.getColumnModel().getColumn(0).setMaxWidth(45);
            tblsp.getColumnModel().getColumn(1).setMinWidth(60);
            tblsp.getColumnModel().getColumn(1).setMaxWidth(60);
            tblsp.getColumnModel().getColumn(2).setMinWidth(60);
            tblsp.getColumnModel().getColumn(2).setMaxWidth(60);
            tblsp.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblsp.getColumnModel().getColumn(4).setMinWidth(60);
            tblsp.getColumnModel().getColumn(4).setMaxWidth(60);
            tblsp.getColumnModel().getColumn(6).setMinWidth(60);
            tblsp.getColumnModel().getColumn(6).setMaxWidth(60);
        }
        tblsp.getAccessibleContext().setAccessibleName("");

        btnReload.setBackground(new java.awt.Color(153, 153, 153));
        btnReload.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReload.setText("L??m m???i");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("T??m ki???m:");

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1)))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(468, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        new Panel_Kho().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
        int selectedIndex = tblsp.getSelectedRow();
        if (selectedIndex >= 0) {
            SanPhamDTO sp = spList.get(selectedIndex);
            String temp = StorageDAL.findQuantityByID(String.valueOf(sp.getId()));
            int amount = Integer.parseInt(temp);
            StorageDAL.editStorage(String.valueOf(sp.getId()), sp.getSl() + amount);
            int option = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a?");
            if (option == 0) {
                SanPhamBLL.removeSanPham(sp.getId());
                JOptionPane.showMessageDialog(null, "X??a th??nh c??ng");
                showSP();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    public void reload(){
        ThemSanPham them = new ThemSanPham();
        them.btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(e.getSource() == them.btnThem){
                    showSP();
                }
            }
        });
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedIndex = tblsp.getSelectedRow();
        SanPhamDTO sp = spList.get(selectedIndex);
        SuaSanPham pns = new SuaSanPham();
        pns.setVisible(true);
        pns.txtID.setText(String.valueOf(sp.getId()));
        pns.cbMaLoai.setSelectedItem(sp.getMaLoai()+ " - " + SanPhamBLL.findLoaiByID(sp.getMaLoai()));
        pns.cbMaHieu.setSelectedItem(sp.getMaHieu() + " - " + SanPhamBLL.findHieuByID(sp.getMaHieu()));
        pns.txtTenSP.setText(sp.getTenSP());
        pns.txtGia.setText(String.valueOf(sp.getGia()));
        pns.txtMota.setText(sp.getMota());
        pns.txtSL.setText(String.valueOf(sp.getSl()));
        pns.txtAnh.setText(sp.getImage());
        pns.txtKw.setText(sp.getKeyword());
        pns.loadAnh();
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspMouseClicked
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }//GEN-LAST:event_tblspMouseClicked

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        showSP();
    }//GEN-LAST:event_btnReloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblsp;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
