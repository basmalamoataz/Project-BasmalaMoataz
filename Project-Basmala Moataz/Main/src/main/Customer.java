/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Customer {
    private String name;
    private String address;
    private int customerId;
    public Customer(int cid, String n, String a) {
    this.address=a;
    this.customerId=cid;
    this.name=n;
    }
     public void SetcustomerId(int customerId) {
    this.customerId= Math.abs(customerId);
    }
      public void Setname(String name) {
    this.name= name; }
       public void Setaddress(String address) {
    this.address= address; }
       public String getaddress() {
    return address;
    }
    public String getname() {
    return name;
    }
    public int getcustomerId() {
    return customerId;
    }
}
