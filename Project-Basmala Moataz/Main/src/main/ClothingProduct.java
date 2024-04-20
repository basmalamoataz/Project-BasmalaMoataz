/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class ClothingProduct extends Product {
    private String size;
    private String fabric;
    public ClothingProduct(int id, String N, double p, String S, String F) {
     super(id, p, N);                

        this.fabric= F;
        this.size=S;
    }


     public void Setsize(String size) {
    this.size= size; } 
    public void Setfabric(String fabric) {
    this.fabric= fabric; }
    public String getfabric() {
    return fabric;
    }
    public String getsize() {
    return size;
    }
}
