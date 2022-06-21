/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.ImageIcon;

/**
 *
 * @author Win 10
 */
public class DatHangDTO {
    int id, card_id, customer_id, quantity,  product_id;
    String product_name, image;
    double price;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DatHangDTO(int id,int card_id,int customer_id,int product_id,String product_name,String image,int quantity,double price) {
        this.id = id;
        this.card_id = card_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }
//    ImageIcon icon = new ImageIcon("src/image/" + product_image);
//                lblImgage.setIcon(icon);
}
