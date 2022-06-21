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
public class LoaiDTO {
    int id;
    String tenLoai;

    public LoaiDTO(int id, String tenLoai) {
        this.id = id;
        this.tenLoai = tenLoai;
    }

    public LoaiDTO(String tenLoai) {
        this.tenLoai = tenLoai;
    }
 
    public int getId() {
        return id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
    
}
