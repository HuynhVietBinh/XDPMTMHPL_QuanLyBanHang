/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Win 10
 */
public class KhachHangBLL {
    public static ArrayList<KhachHangDTO> loadDataKhachHang(){
        return KhachHangDAL.loadDataKhachHang();
    };
    public static KhachHangDTO getKhachHangByID(String id){
        return KhachHangDAL.getKhachHangByID(id);
    }
    public static ArrayList<KhachHangDTO> getKhachHangToNameByID(String id){
        return KhachHangDAL.getKhachHangToNameByID(id);
    }
}
