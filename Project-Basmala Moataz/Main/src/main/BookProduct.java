/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class BookProduct extends Product{
    private String author;
    private String publisher;
    public BookProduct(int id, String N, double p, String a, String pl) {
        super(id, p, N);
        this.author= a;
        this.publisher=pl;
    }
     public void Setauthor(String author) {
    this.author= author; } 
    public void Setpublisher(String publisher) {
    this.publisher= publisher; }
    public String getauthor() {
    return author;
    }
    public String getpublisher() {
    return publisher;
    }
}
