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
public class BillDTO {
    int id_bill, discount, price, customer_id ;

    public BillDTO(int id_bill, int discount, int price, int customer_id) {
        this.id_bill = id_bill;
        this.discount = discount;
        this.price = price;
        this.customer_id = customer_id;
    }

     public BillDTO(int discount, int price, int customer_id) {
        this.discount = discount;
        this.price = price;
        this.customer_id = customer_id;
    }
    

    public int getId_bill() {
        return id_bill;
    }

    public int getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
        
}
