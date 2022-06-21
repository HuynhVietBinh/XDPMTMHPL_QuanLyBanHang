/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.BillDTO;
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
public class BillDAL {
    
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    public static ArrayList<BillDTO> loadDataBill() {
        
        ArrayList<BillDTO> hdList = new ArrayList<>();
        MySQLConnect connect = new MySQLConnect();

        try {
            String query = "SELECT * FROM bill";          
            ps = connect.conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDTO bh = new BillDTO(rs.getInt("id_bill"),rs.getInt("discount"),
                        rs.getInt("price"),rs.getInt("customer_id"));
                hdList.add(bh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hdList;
    }
    
    public static void addBill(BillDTO bh) {
        MySQLConnect Connect = new MySQLConnect();
        try {
            String query = "insert into bill (discount,price,customer_id) values('";
            query += bh.getDiscount()+ "','" + bh.getPrice()+ "','" + bh.getCustomer_id() + "')";
            
            Connect.st = Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
