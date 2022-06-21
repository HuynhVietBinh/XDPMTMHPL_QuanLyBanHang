/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.HieuDTO;
import DTO.LoaiDTO;
import DTO.SanPhamDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUYNHVIETBINH
 */
public class SanPhamDAL {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static ArrayList<SanPhamDTO> loadDataSanPham() {

        ArrayList<SanPhamDTO> spList = new ArrayList<>();

        try {
            String query = "SELECT * FROM products";
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

    public static ArrayList<SanPhamDTO> loadDataNameSanPhamById(String id) {
        ArrayList<SanPhamDTO> listsp = new ArrayList<>();
        try {
            String query = "SELECT product_title FROM products WHERE product_id = '" + id + "';";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                SanPhamDTO sp = new SanPhamDTO();
                sp.setTenSP(rs.getString("product_title"));
                listsp.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    public static ArrayList<LoaiDTO> loadDataLoai() {

        ArrayList<LoaiDTO> loaiList = new ArrayList<>();

        try {
            String query = "SELECT * FROM loai";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                LoaiDTO l = new LoaiDTO(rs.getInt("loai_id"), rs.getString("tenloai"));
                loaiList.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiList;
    }

    public static ArrayList<HieuDTO> loadDataHieu() {

        ArrayList<HieuDTO> hieuList = new ArrayList<>();

        try {
            String query = "SELECT * FROM hieu";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HieuDTO h = new HieuDTO(rs.getInt("hieu_id"), rs.getString("tenhieu"));
                hieuList.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hieuList;
    }

    public static void addSanPham(SanPhamDTO sp) {
        String query = "INSERT INTO `products`(`product_id`, `product_cat`, `product_brand`, `product_title`, `product_price`, `product_desc`, `product_amount`, `product_image`, `product_keywords`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, sp.getId());
            ps.setInt(2, sp.getMaLoai());
            ps.setInt(3, sp.getMaHieu());
            ps.setString(4, sp.getTenSP());
            ps.setInt(5, sp.getGia());
            ps.setString(6, sp.getMota());
            ps.setInt(7, sp.getSl());
            ps.setString(8, sp.getImage());
            ps.setString(9, sp.getKeyword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void editSanPham(SanPhamDTO sp) {
        String query = "UPDATE `products` SET `product_cat`=?,`product_brand`=?,`product_title`=?,`product_price`=?,`product_desc`=?,`product_amount`=?,`product_image`=?,`product_keywords`=? WHERE `product_id`=?";
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
            ps.setInt(9, sp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void editAmount(SanPhamDTO sp, int sl) {
        String query = "UPDATE `products` SET `product_amount`=? WHERE `product_id`=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, sl);
            ps.setInt(2, sp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeSanPham(int maSP) {
        String query = "DELETE FROM products WHERE `product_id`=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, maSP);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String findLoaiByID(int ml) {
        String tenloai = "";
        String query = "SELECT `tenloai` FROM `loai` WHERE loai_id=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, ml);
            rs = ps.executeQuery();
            while (rs.next()) {
                tenloai = rs.getString("tenloai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenloai;
    }

    public static String findHieuByID(int mh) {
        String tenHieu = "";
        String query = "SELECT `tenhieu` FROM `hieu` WHERE hieu_id=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, mh);
            rs = ps.executeQuery();
            while (rs.next()) {
                tenHieu = rs.getString("tenhieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenHieu;
    }

    public static String findQuantityByID(String id) {
        String qty = "";
        String query = "SELECT `product_amount` FROM `products` WHERE product_id=?";
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

}
