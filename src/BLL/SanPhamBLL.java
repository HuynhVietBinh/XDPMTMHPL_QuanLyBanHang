/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SanPhamDAL;
import DTO.HieuDTO;
import DTO.LoaiDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author HUYNHVIETBINH
 */
public class SanPhamBLL {
    public static ArrayList<SanPhamDTO> loadDataSanPham(){
        return SanPhamDAL.loadDataSanPham();
    }
    
    public static ArrayList<LoaiDTO> loadDataLoai(){
        return SanPhamDAL.loadDataLoai();
    }
    
    public static ArrayList<HieuDTO> loadDataHieu(){
        return SanPhamDAL.loadDataHieu();
    }
    
    public static void addSanPham(SanPhamDTO sp){
        SanPhamDAL.addSanPham(sp);
    }
    
    public static void editSanPham(SanPhamDTO sp){
        SanPhamDAL.editSanPham(sp);
    }
    
    public static void removeSanPham(int maSP){
        SanPhamDAL.removeSanPham(maSP);
    }
    
    public static String findLoaiByID(int ml){
        return SanPhamDAL.findLoaiByID(ml);
    }
    
    public static String findHieuByID(int mh){
        return SanPhamDAL.findHieuByID(mh);
    }
    public static String finQuantityByID(String id){
        return SanPhamDAL.findQuantityByID(id);
    }
//    public static String finHieuByID(String id){
//        return SanPhamDAL.findQuantityByID(id);
//    }
    public static ArrayList<SanPhamDTO> loadNameSPById(String id){
        return new SanPhamDAL().loadDataNameSanPhamById(id);
    }
}
