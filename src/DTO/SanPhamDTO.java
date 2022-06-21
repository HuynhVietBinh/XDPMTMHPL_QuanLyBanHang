/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HUYNHVIETBINH
 */
public class SanPhamDTO {
    String tenSP, mota, image, keyword;
    int gia, id, maLoai, maHieu, sl;

    public SanPhamDTO() {
    }
    

    public SanPhamDTO(int id, int maLoai, int maHieu, String tenSP, int gia, String mota, int sl, String image, String keyword) {
        this.tenSP = tenSP;
        this.mota = mota;
        this.image = image;
        this.keyword = keyword;
        this.gia = gia;
        this.id = id;
        this.maLoai = maLoai;
        this.maHieu = maHieu;
        this.sl = sl;
    }

    public SanPhamDTO(int maLoai, int maHieu, String tenSP, int gia, String mota, int sl, String image, String keyword) {
        this.tenSP = tenSP;
        this.mota = mota;
        this.image = image;
        this.keyword = keyword;
        this.gia = gia;
        this.maLoai = maLoai;
        this.maHieu = maHieu;
        this.sl = sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getSl() {
        return sl;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public void setMaHieu(int maHieu) {
        this.maHieu = maHieu;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getMota() {
        return mota;
    }

    public String getImage() {
        return image;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getGia() {
        return gia;
    }

    public int getId() {
        return id;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public int getMaHieu() {
        return maHieu;
    }

}
