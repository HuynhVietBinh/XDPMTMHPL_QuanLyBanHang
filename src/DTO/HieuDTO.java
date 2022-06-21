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
public class HieuDTO {
    int id;
    String tenHieu;

    public HieuDTO(int id, String tenHieu) {
        this.id = id;
        this.tenHieu = tenHieu;
    }

    public HieuDTO(String tenHieu) {
        this.tenHieu = tenHieu;
    }
    

    public HieuDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTenHieu() {
        return tenHieu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenHieu(String tenHieu) {
        this.tenHieu = tenHieu;
    }
    
    
}
