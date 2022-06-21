/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ChiTietBillDAL;
import DTO.ChiTietBillDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChiTietBillBLL {
    public static ArrayList<ChiTietBillDTO> loadDataBillByBill_id(String mabill){
        return ChiTietBillDAL.loadDataBillByBill_id(mabill);
    }
    public static void addChiTietBill(ChiTietBillDTO bh) {
        ChiTietBillDAL.addChiTietBill(bh);
    }
}
