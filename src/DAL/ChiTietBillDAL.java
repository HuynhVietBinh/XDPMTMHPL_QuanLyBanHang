/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChiTietBillDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phatdat
 */
public class ChiTietBillDAL {
    
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    
    public static ArrayList<ChiTietBillDTO> loadDataBillByBill_id(String mabill) {
        
        ArrayList<ChiTietBillDTO> hdList = new ArrayList<>();
        MySQLConnect connect = new MySQLConnect();

        try {
            String query = "SELECT bct.billchitiet_id, bct.product_id, bct.quantity, bct.price FROM bill_chitiet bct, bill b WHERE b.id_bill = bct.bill_id and b.id_bill = " + mabill;;          
            ps = connect.conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietBillDTO bh = new ChiTietBillDTO(rs.getInt("billchitiet_id"),rs.getInt("product_id"),
                        rs.getInt("quantity"),rs.getInt("price"));
                hdList.add(bh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hdList;
    }
    
    public static void addChiTietBill(ChiTietBillDTO bh) {
        MySQLConnect Connect = new MySQLConnect();
        try {
            String query = "insert into bill_chitiet (product_id,quantity,price,bill_id) values('";
            query += bh.getProduct_id()+ "','" + bh.getQuantity()+ "','" + bh.getPrice()+ "','"
                    + bh.getBill_id()+ "')";
            
            Connect.st = Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        String query2 = "UPDATE products SET product_amount = product_amount - " + bh.getQuantity() + " WHERE product_id = " + bh.getProduct_id();
        try {
            ps = new MySQLConnect().conn.prepareStatement(query2);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
}
