/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.SanPhamDTO;
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
public class StorageDAL {
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    public static String findQuantityByID(String id) {
        String qty = "";
        String query = "SELECT `product_amount` FROM `storage` WHERE product_id=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                qty = rs.getString("product_amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qty;
    }
    public static void editStorage(String id, int amount) {
        String query = "UPDATE `storage` SET `product_amount`=? WHERE `product_id`=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<SanPhamDTO> loadDataSanPham() {

        ArrayList<SanPhamDTO> spList = new ArrayList<>();

        try {
            String query = "SELECT * FROM storage";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO(rs.getInt("product_id"), rs.getInt("product_cat"),
                        rs.getInt("product_brand"), rs.getString("product_title"), rs.getInt("product_price"),
                        rs.getString("product_desc"), rs.getInt("product_amount"), rs.getString("product_image"), rs.getString("product_keywords"));
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return spList;
    }
    public static void addToStorage(SanPhamDTO sp) {
        String query = "INSERT INTO `storage`(`product_cat`, `product_brand`, `product_title`, `product_price`, `product_desc`, `product_amount`, `product_image`, `product_keywords`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, sp.getMaLoai());
            ps.setInt(2, sp.getMaHieu());
            ps.setString(3, sp.getTenSP());
            ps.setInt(4, sp.getGia());
            ps.setString(5, sp.getMota());
            ps.setInt(6, sp.getSl());
            ps.setString(7, sp.getImage());
            ps.setString(8, sp.getKeyword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
