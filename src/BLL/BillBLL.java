/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BillDAL;
import DTO.BillDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BillBLL {
    public static ArrayList<BillDTO> loadDataBill(){
        return BillDAL.loadDataBill();
    }
    public static void addBill(BillDTO bh) {
        BillDAL.addBill(bh);
    }
}
