/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PhieuGiaoHangDAL;
import DTO.PhieuGiaoHangDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class PhieuGiaoHangBLL {

    public static ArrayList<PhieuGiaoHangDTO> loadDataPhieuGiaoHang() {
        return new PhieuGiaoHangDAL().loadDataPhieuGiaoHang();
    }
     public static ArrayList<PhieuGiaoHangDTO> loadDataPhieuGiaoHangByIdCus(String customer_id) {
        return new PhieuGiaoHangDAL().loadDataPhieuGiaoHangByIdCus(customer_id);
    }
    public static boolean addPhieuGiaoHang(PhieuGiaoHangDTO pgh){
        return new PhieuGiaoHangDAL().addPhieuGiaoHang(pgh);
    }
    public static boolean editPhieuGiaoHang(PhieuGiaoHangDTO pgh){
        return new PhieuGiaoHangDAL().editPhieuGiaoHang(pgh);
    }
    public static boolean removePhieuGiaoHang(int data){
        return new PhieuGiaoHangDAL().removePhieuGiaoHang(data);
    }
    public static boolean loadCbCartId(JComboBox cb){
        return new PhieuGiaoHangDAL().loadCbByCartId(cb);
    }
    public static boolean loadCbCustomerId(JComboBox cb){
        return new PhieuGiaoHangDAL().loadCbByCustomerId(cb);
    }
    public static boolean loadCbProductId(JComboBox cb){
        return new PhieuGiaoHangDAL().loadCbByProductId(cb);
    }
}
