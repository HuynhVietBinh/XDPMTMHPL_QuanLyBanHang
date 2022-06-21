/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.PhieuGiaoHangDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class PhieuGiaoHangDAL {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<PhieuGiaoHangDTO> loadDataPhieuGiaoHang() {
        ArrayList<PhieuGiaoHangDTO> listpgh = new ArrayList<>();
        String query = "SELECT * FROM cart_detail";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                PhieuGiaoHangDTO pgh = new PhieuGiaoHangDTO();
                pgh.setId(rs.getInt("id"));
                pgh.setCart_id(rs.getInt("cart_id"));
                pgh.setCustomer_id(rs.getInt("customer_id"));
                pgh.setProduct_id(rs.getInt("product_id"));
                pgh.setProduct_name(rs.getString("product_name"));
                pgh.setImage(rs.getString("image"));
                pgh.setQuantity(rs.getInt("quantity"));
                pgh.setPrice(rs.getInt("price"));
                listpgh.add(pgh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listpgh;
    }
    
    public ArrayList<PhieuGiaoHangDTO> loadDataPhieuGiaoHangByIdCus(String customer_id) {
        ArrayList<PhieuGiaoHangDTO> listpgh = new ArrayList<>();
        String query = "SELECT * FROM cart_detail WHERE customer_id=  '" + customer_id +"';";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                PhieuGiaoHangDTO pgh = new PhieuGiaoHangDTO();
                pgh.setId(rs.getInt("id"));
                pgh.setCart_id(rs.getInt("cart_id"));
                pgh.setCustomer_id(rs.getInt("customer_id"));
                pgh.setProduct_id(rs.getInt("product_id"));
                pgh.setProduct_name(rs.getString("product_name"));
                pgh.setImage(rs.getString("image"));
                pgh.setQuantity(rs.getInt("quantity"));
                pgh.setPrice(rs.getInt("price"));
                listpgh.add(pgh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listpgh;
    }

    public boolean loadCbByCartId(JComboBox cb) {
        String query = "SELECT id FROM cart";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                cb.addItem(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean loadCbByCustomerId(JComboBox cb) {
        String query = "SELECT customer_id FROM customers";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("customer_id"));
                cb.addItem(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean loadCbByProductId(JComboBox cb) {
        String query = "SELECT product_id FROM products";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("product_id"));
                cb.addItem(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPhieuGiaoHang(PhieuGiaoHangDTO pgh) {
        String query = "INSERT INTO cart_detail(id,cart_id,customer_id,product_id,product_name,image,quantity,price)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, pgh.getId());
            ps.setInt(2, pgh.getCart_id());
            ps.setInt(3, pgh.getCustomer_id());
            ps.setInt(4, pgh.getProduct_id());
            ps.setString(5, pgh.getProduct_name());
            ps.setString(6, pgh.getImage());
            ps.setInt(7, pgh.getQuantity());
            ps.setFloat(8, pgh.getPrice());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editPhieuGiaoHang(PhieuGiaoHangDTO pgh) {
        String query = "UPDATE cart_detail SET cart_id=?,customer_id=?,product_id=?,product_name=?,"
                + "image=?,quantity=?,price=? WHERE id=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, pgh.getCart_id());
            ps.setInt(2, pgh.getCustomer_id());
            ps.setInt(3, pgh.getProduct_id());
            ps.setString(4, pgh.getProduct_name());
            ps.setString(5, pgh.getImage());
            ps.setInt(6, pgh.getQuantity());
            ps.setFloat(7, pgh.getPrice());
            ps.setInt(8, pgh.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removePhieuGiaoHang(int data) {
        String query = "DELETE FROM cart_detail WHERE id=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, data);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
