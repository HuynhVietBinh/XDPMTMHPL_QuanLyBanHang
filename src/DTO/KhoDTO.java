/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Win 10
 */
public class KhoDTO {
    int donhang_id, product_id, soluong, hieu, loai;
    String tenhang;
    int gianhap;
    String lydonhap, ngaynhap;

    public KhoDTO(int donhang_id, int product_id, int soluong, int hieu, int loai, String tenhang, int gianhap, String lydonhap, String ngaynhap) {
        this.donhang_id = donhang_id;
        this.product_id = product_id;
        this.soluong = soluong;
        this.hieu = hieu;
        this.loai = loai;
        this.tenhang = tenhang;
        this.gianhap = gianhap;
        this.lydonhap = lydonhap;
        this.ngaynhap = ngaynhap;
    }

    public KhoDTO(int product_id, int soluong, int hieu, int loai, String tenhang, int gianhap, String lydonhap) {
        this.product_id = product_id;
        this.soluong = soluong;
        this.hieu = hieu;
        this.loai = loai;
        this.tenhang = tenhang;
        this.gianhap = gianhap;
        this.lydonhap = lydonhap;
    }
    
    public int getDonhang_id() {
        return donhang_id;
    }

    public void setDonhang_id(int donhang_id) {
        this.donhang_id = donhang_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getHieu() {
        return hieu;
    }

    public void setHieu(int hieu) {
        this.hieu = hieu;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public String getLydonhap() {
        return lydonhap;
    }

    public void setLydonhap(String lydonhap) {
        this.lydonhap = lydonhap;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
    
}
