/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhoDTO;
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
public class KhoDAL {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static ArrayList<KhoDTO> loadDataNhapKho() {

        ArrayList<KhoDTO> nhapKhoList = new ArrayList<>();

        try {
            String query = "SELECT * FROM kho";
            ps = new MySQLConnect().conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhoDTO don = new KhoDTO(rs.getInt("donhang_id"), rs.getInt("product_id"),
                        rs.getInt("soluong"), rs.getInt("hieu"), rs.getInt("loai"),
                        rs.getString("tenhang"), rs.getInt("gianhap"), rs.getString("lydonhap"), rs.getString("ngaynhap"));
                nhapKhoList.add(don);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhapKhoList;
    }

    public static void addKho(KhoDTO nhapKho) {
//        String query = "INSERT INTO `products`(`product_id`, `soluong`, `hieu`, `loai`, `tenhang`, `gianhap`, `lydonhap`) VALUES (?,?,?,?,?,?,?)";
//        try {
//            ps = new MySQLConnect().conn.prepareStatement(query);
////            ps.setInt(1, nhapKho.getDonhang_id());
//            ps.setInt(1, nhapKho.getProduct_id());
//            ps.setInt(2, nhapKho.getSoluong());
//            ps.setInt(3, nhapKho.getHieu());
//            ps.setInt(4, nhapKho.getLoai());
//            ps.setString(5, nhapKho.getTenhang());
//            ps.setInt(6, nhapKho.getGianhap());
//            ps.setString(7, nhapKho.getLydonhap());
////            ps.setString(8, nhapKho.getNgaynhap());
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        MySQLConnect Connect = new MySQLConnect();
        try {
            String query = "insert into kho (product_id,soluong,hieu,loai,tenhang,gianhap,lydonhap) values('";
            query += nhapKho.getProduct_id()+ "','" + nhapKho.getSoluong()+ "','" + nhapKho.getHieu()+ "','" + 
                    nhapKho.getLoai()+ "','" + nhapKho.getTenhang()+ "','" + nhapKho.getGianhap()+"','" + nhapKho.getLydonhap()+ "')";

            Connect.st = Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String findLoaiByID(int ml) {
        String tenloai = "";
        String query = "SELECT `tenloai` FROM `loai` WHERE loai_id=?";
        try {
            ps = new MySQLConnect().conn.prepareStatement(query);
            ps.setInt(1, ml);
            rs = ps.executeQuery();
            if (rs.next()) {
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
            if (rs.next()) {
                tenHieu = rs.getString("tenhieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenHieu;
    }

}
