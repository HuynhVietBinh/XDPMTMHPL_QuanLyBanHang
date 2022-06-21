/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Win 10
 */
import DTO.DatHangDTO;
import DTO.LoaiDTO;
import DTO.SanPhamDTO;
import GUI.Panel_DatHang_XemChiTiet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatHangDAL {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static ArrayList<DatHangDTO> loadDataDatHang() {

        ArrayList<DatHangDTO> datHangList = new ArrayList<>();

        try {
            String query = "SELECT * FROM cart_detail";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DatHangDTO datHang = new DatHangDTO(rs.getInt("id"), rs.getInt("cart_id"), rs.getInt("customer_id"), rs.getInt("product_id"), rs.getString("product_name"), rs.getString("image"), rs.getInt("quantity"), rs.getInt("price"));
                datHangList.add(datHang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datHangList;
    }

    public static void updateStateCart(String id){
        try {
            String query = "UPDATE `cart` SET `state`= 'Đã duyệt' WHERE `id` = '" + id + "'";
            ps = new MySQLConnect().conn.prepareStatement(query);
            int i = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Panel_DatHang_XemChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ArrayList<DatHangDTO> loadAmountCart(String id) {

        ArrayList<DatHangDTO> amountList = new ArrayList<>();

        try {
            String query = "SELECT * FROM cart_detail WHERE cart_id = '"+ id +"';";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DatHangDTO datHang = new DatHangDTO(rs.getInt("id"), rs.getInt("cart_id"), rs.getInt("customer_id"), rs.getInt("product_id"), rs.getString("product_name"), rs.getString("image"), rs.getInt("quantity"), rs.getInt("price"));
                amountList.add(datHang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amountList;
    }
    
//    public static ArrayList<DatHangDTO> getStateFormCart() {
//
//        ArrayList<Object> cartList = new ArrayList<>();
//
//        try {
//            String query = "SELECT * FROM cart";
//            ps = new MySQLConnect().conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                
//                cartList.add(cart);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return datHangList;
//    }
    public static String getStateFormCart(String id) {

//        ArrayList<Object> cartList = new ArrayList<>();
        String state = "";
        try {
            String query = "SELECT state FROM cart WHERE id = '" + id + "';";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                state = rs.getString("state");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }
}
