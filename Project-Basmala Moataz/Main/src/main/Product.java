/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Product {
    protected int ProductId;
    protected String name;
    protected double price;
    public Product(int id, double p, String N ) {
    this.ProductId=id;
    this.name=N;
    this.price=p;
    }
    public void SetProductId(int ProductId) {
        this.ProductId= Math.abs(ProductId);
    }
    public void Setname(String name) {
    this.name= name;
    }
    public void Setprice(int price) {
    this.price= Math.abs(price);
   
    }
    public int getProductId() {
    return ProductId;
    }
    public String getname() {
    return name;
    }
    public double getprice() {
    return price;
    }
}
