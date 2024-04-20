/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Cart {
    private int customerId;
    private int nProducts;
     private Product[] products; 
    public Cart(int customerId, int maxProducts) {
    this.customerId = Math.abs(customerId);
    this.nProducts = 0;
     int maxproducts = 0;
    this.products = new Product[maxProducts];
}
       
   
      public void SetcustomerId(int customerId) {
    this.customerId= customerId;
    }
     public void SetnProducts(int nProducts) {
    this.nProducts= Math.abs(nProducts);
   
    }
    public int getcustomerId() {
    return customerId;
    }
       public int getnProducts() {
    return nProducts;
    }
       public Product[] getProducts() {
        return products;
    }
       public void addProduct(Product product) {
    if (nProducts < products.length) {
        products[nProducts] = product;
        nProducts++;
    } else {
        System.out.println("Cart is full. Cannot add more products.");
    }
}
    

   public void removeProduct(int index) {
    if (index >= 0 && index < nProducts) {
        for (int i = index; i < nProducts - 1; i++) {
            products[i] = products[i + 1];
        }
        nProducts--;
    } else {
        System.out.println("Invalid index.");
    }
}

   public double calculatePrice() {
    double totalPrice = 0.0;
    if (nProducts > 0) {
        for (int i = 0; i < nProducts; i++) {
            totalPrice += products[i].price;
        }
    }
    return Math.abs(totalPrice);

}

public Order placeOrder() {
    double totalPrice = calculatePrice();
    Product[] orderedProducts = new Product[nProducts];
    System.arraycopy(products, 0, orderedProducts, 0, nProducts);
    Order order = new Order(customerId, orderedProducts, nProducts, totalPrice);
    // Clear the cart after placing the order
    nProducts = 0;
    return order;
}
}
  