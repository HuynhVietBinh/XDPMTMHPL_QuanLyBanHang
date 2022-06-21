/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.KhachHangBLL;
import BLL.SanPhamBLL;
import DTO.DatHangDTO;
import DTO.KhachHangDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Win 10
 */
public class Panel_DatHang extends javax.swing.JPanel {

    DefaultTableModel dtmDatHang;
    DefaultTableModel dtmDuyet;
    ArrayList<DatHangDTO> datHangList;
    ArrayList<String> arrayState = new ArrayList<>();
    Panel_DatHang_XemChiTiet panel = new Panel_DatHang_XemChiTiet();
    public Panel_DatHang() {
        initComponents();
        this.setBounds(0, 0, 786, 632);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        dtmDatHang = (DefaultTableModel) tblDatHang.getModel();
//        dtmDuyet =  (DefaultTableModel) tblDuyet.getModel();
        showDonDatHang();
        TimKiem();
        reload();

    }
    
    public void showDonDatHang() {
        datHangList = BLL.DatHangBLL.loadDataDatHang();
        dtmDatHang.setRowCount(0);
//        dtmDuyet.setRowCount(0);
        tblDatHang.setModel(dtmDatHang);
//        tblDuyet.setModel(dtmDuyet);
        
        ArrayList<String> stateIDList = new ArrayList<>();
        
        for(int i = 0; i < datHangList.size(); i++){
            stateIDList.add(String.valueOf(datHangList.get(i).getCard_id()));
        }
        try {
            datHangList.forEach((DatHangDTO) -> {
                String getState = null;
                try {
                    getState = BLL.DatHangBLL.getStateFormCart(String.valueOf(DatHangDTO.getCard_id()));
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_DatHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                ImageIcon icon = new ImageIcon("C:\\xampp\\htdocs\\hangdientu\\dientu\\image\\" + DatHangDTO.getImage());
                
                dtmDatHang.addRow(new Object[]{DatHangDTO.getCard_id(), DatHangDTO.getCustomer_id(), DatHangDTO.getProduct_id(),
                    DatHangDTO.getProduct_name(), DatHangDTO.getImage(), DatHangDTO.getQuantity(), DatHangDTO.getPrice(), getState});
                panel.datHangList.add(DatHangDTO);
                arrayState.add(getState);
//                dtmDuyet.addRow(new Object[]{"Duyệt"});
                
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TimKiem() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblDatHang.getModel());
        tblDatHang.setRowSorter(rowSorter);
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
    public void reload(){
        panel.btnDuyet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(e.getSource() == panel.btnDuyet){
                    showDonDatHang();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDatHang = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatHang = new javax.swing.JTable();

        setBackground(new java.awt.Color(96, 166, 254));
        setEnabled(false);
        setMinimumSize(new java.awt.Dimension(8, 0));
        setPreferredSize(new java.awt.Dimension(786, 629));

        lblDatHang.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblDatHang.setText("ĐẶT HÀNG");

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm:");

        tblDatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đơn", "Mã khách", "Mã sản phẩm", "Tên sản phẩm", "Hình ảnh", "Số lượng", "Giá", "Trạng thái"
            }
        ));
        tblDatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(lblDatHang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    int index;
    private void tblDatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatHangMouseClicked
        // TODO add your handling code here:
         index = tblDatHang.getSelectedRow();
//        mabill = dtmhd.getValueAt(index, 0).toString();
//        int index = tableList.getSelectedRow();
//        txtid1.setText((String) (model.getValueAt(index, 0)));
//        txtten1.setText((String) (model.getValueAt(index, 1)));
//        txtdiem1.setText((String) (model.getValueAt(index, 2)));
        datHangList = BLL.DatHangBLL.loadDataDatHang();
        DatHangDTO datHangDTO = datHangList.get(index);
        ImageIcon icon = new ImageIcon("src/image/" + datHangDTO.getImage());
        KhachHangDTO kh = new KhachHangDTO(SOMEBITS, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
        kh = KhachHangBLL.getKhachHangByID(String.valueOf(datHangDTO.getCustomer_id()));
        panel.lblAnhSP.setIcon(icon);
        panel.txtMadon.setText(String.valueOf(datHangDTO.getCard_id()));
        panel.txtTen.setText(kh.getCustomer_name());
        panel.txtDiaChi.setText(kh.getCustomer_address());
        panel.txtSdt.setText(kh.getCustomer_contact());
        panel.txtMaSp.setText(String.valueOf(datHangDTO.getProduct_id()));
        panel.txtSl.setText(String.valueOf(datHangDTO.getQuantity()));
        panel.txtGia.setText(String.valueOf(datHangDTO.getPrice()));
        panel.txtState.setText(arrayState.get(index));
        panel.setVisible(true);
        if(arrayState.get(index).equals("Đã duyệt")){
            panel.btnDuyet.setEnabled(false);
        }
        else{
            panel.btnDuyet.setEnabled(true);
        }
        panel.index_DatHang_XemChiTiet = index;
        showDonDatHang();
    }//GEN-LAST:event_tblDatHangMouseClicked
//    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
//
//        new ThemSanPham().setVisible(true);
//    }
//    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
//
//        int selectedIndex = tblDatHang.getSelectedRow();
//        if (selectedIndex >= 0) {
//            DatHangDTO datHangDTO = datHangList.get(selectedIndex);
//            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?");
//            if (option == 0) {
//                BLL.DatHangBLL.removeSanPham(datHangDTO.getId());
//                JOptionPane.showMessageDialog(null, "Xóa thành công");
//                showDonDnatHang();
//            }
//        }
//    }
//    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
//        int selectedIndex = tblDatHang.getSelectedRow();
//        SanPhamDTO sp = spList.get(selectedIndex);
//        SuaSanPham pns = new SuaSanPham();
//        pns.setVisible(true);
//        pns.txtID.setText(String.valueOf(sp.getId()));
//        pns.cbMaLoai.setSelectedItem(sp.getMaLoai() + " - " + SanPhamBLL.findLoaiByID(sp.getMaLoai()));
//        pns.cbMaHieu.setSelectedItem(sp.getMaHieu() + " - " + SanPhamBLL.findHieuByID(sp.getMaHieu()));
//        pns.txtTenSP.setText(sp.getTenSP());
//        pns.txtGia.setText(String.valueOf(sp.getGia()));
//        pns.txtMota.setText(sp.getMota());
//        pns.txtSL.setText(String.valueOf(sp.getSl()));
//        pns.txtAnh.setText(sp.getImage());
//        pns.txtKw.setText(sp.getKeyword());
//        pns.loadAnh();
//
//    }

    private void tblspMouseClicked(java.awt.event.MouseEvent evt) {
//        btnSua.setEnabled(true);
//        btnXoa.setEnabled(true);

    }

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {
//        btnSua.setEnabled(false);
//        btnXoa.setEnabled(false);
        showDonDatHang();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatHang;
    private javax.swing.JTable tblDatHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
