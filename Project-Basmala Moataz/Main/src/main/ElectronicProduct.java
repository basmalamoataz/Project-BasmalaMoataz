/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;
    public ElectronicProduct(int id, String N, int WP, String b, double p) {
        super(id, p, N);
        this.brand=b;
        this.warrantyPeriod= WP;
    }
     public void Setbrand(String brand) {
    this.brand= brand;
    }
     public void SetwarrantyPeriod(int warrantyPeriod) {
    this.warrantyPeriod= Math.abs(warrantyPeriod);
   
    }
    public String getbrand() {
    return brand;
    }
       public int getwarrantyPeriod() {
    return warrantyPeriod;
    }
}
