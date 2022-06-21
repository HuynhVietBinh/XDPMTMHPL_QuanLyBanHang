/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Win 10
 */
import DAL.DatHangDAL;
import DTO.DatHangDTO;
import java.sql.SQLException;
import java.util.ArrayList;
public class DatHangBLL {
    public static ArrayList<DatHangDTO> loadDataDatHang(){
        return DatHangDAL.loadDataDatHang();
    }
    public static void updateStateCart(String id) throws SQLException{
        DatHangDAL.updateStateCart(id);
    }
    public static void Cart(String id) throws SQLException{
        DatHangDAL.updateStateCart(id);
    }
    public static String getStateFormCart(String id) throws SQLException{
        return DatHangDAL.getStateFormCart(id);
    }
    public static ArrayList<DatHangDTO> loadAmountCart(String id){
        return DatHangDAL.loadAmountCart(id);
    }
}
