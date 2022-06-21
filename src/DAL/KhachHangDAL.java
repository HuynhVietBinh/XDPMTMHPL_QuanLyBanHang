/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHangDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 10
 */
public class KhachHangDAL {
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static ArrayList<KhachHangDTO> loadDataKhachHang() {
        
        ArrayList<KhachHangDTO> khachHangList = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM cart_detail";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDTO kh =  new KhachHangDTO(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_pass"), rs.getString("customer_country"),rs.getString("customer_city"), rs.getString("customer_contact"), rs.getString("customer_image"), rs.getString("customer_address"));
                khachHangList.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangList;
    }
    public static KhachHangDTO getKhachHangByID (String id){
        KhachHangDTO kh = null;
        try {
            String query = "SELECT * FROM customers Where customer_id = '" + id +"';";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                kh =  new KhachHangDTO(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_pass"), rs.getString("customer_country"),rs.getString("customer_city"), rs.getString("customer_contact"), rs.getString("customer_image"), rs.getString("customer_address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }
    
    public static ArrayList<KhachHangDTO> getKhachHangToNameByID (String id){
        ArrayList<KhachHangDTO> listkhachhang = new ArrayList<>();
        String query = "SELECT customer_name,customer_country,customer_city,customer_address FROM customers WHERE customer_id = '" + id +"';";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()) {
                KhachHangDTO kh=new KhachHangDTO();
                kh.setCustomer_name(rs.getString("customer_name"));
                kh.setCustomer_country(rs.getString("customer_country"));
                kh.setCustomer_city(rs.getString("customer_city"));
                kh.setCustomer_address(rs.getString("customer_address"));
                listkhachhang.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkhachhang;
        
    }
}
