/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author DELL
 */
public class Order {
   

        public Order() {
        }
    private int customerId;
    private int orderId;
    private Product[] products;
    private double totalPrice;

    public Order(int customerId, Product[] products, int nProducts, double totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = (int) (Math.random() * 10000); // Generate a random order ID
        this.products = new Product[nProducts];
        System.arraycopy(products, 0, this.products, 0, nProducts);
        this.totalPrice = Math.abs(totalPrice);
    }
    public int getOrderId() {
        return orderId;
    }


    public void printOrderInfo() {
        System.out.println("Order Information:");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.name + " ($" + product.price + ")");
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Information:\n");
        sb.append("Customer ID: ").append(customerId).append("\n");
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Products:\n");
        for (Product product : products) {
            sb.append("- ").append(product.name).append(" ($").append(product.price).append(")\n");
        }
        sb.append("Total Price: $").append(totalPrice);
        return sb.toString();
    }

    }


