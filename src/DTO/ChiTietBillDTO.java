/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author phatdat
 */
public class ChiTietBillDTO {
    int billchitiet_id, product_id, quantity, price, bill_id;
    
    public ChiTietBillDTO(int product_id, int quantity, int price, int bill_id) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.bill_id = bill_id;
    }
       
    public ChiTietBillDTO(int product_id, int quantity, int price) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBillchitiet_id() {
        return billchitiet_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBillchitiet_id(int billchitiet_id) {
        this.billchitiet_id = billchitiet_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }
    
    
}
