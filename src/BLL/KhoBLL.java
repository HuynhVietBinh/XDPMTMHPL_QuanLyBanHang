/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.KhoDTO;
import java.util.ArrayList;

/**
 *
 * @author Win 10
 */
public class KhoBLL {
    public static ArrayList<KhoDTO> loadDataNhapKho(){
        return DAL.KhoDAL.loadDataNhapKho();
    }
    public static void addKho(KhoDTO kho){
        DAL.KhoDAL.addKho(kho);
    }
    public static String findLoaiByID(int ml) {
        return DAL.KhoDAL.findLoaiByID(ml);
    }
    public static String findHieuByID(int mh) {
        return DAL.KhoDAL.findHieuByID(mh);
    }
    
}
