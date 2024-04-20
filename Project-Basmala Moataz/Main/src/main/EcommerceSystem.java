/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcommerceSystem extends JFrame {
    private JTextField customerIdField;
    private JTextField customerNameField;
    private JTextField customerAddressField;
    private JComboBox<Product> productComboBox;
    private JButton addToCartButton;
    private JButton placeOrderButton;
    private JTextArea cartArea;
    private JTextArea orderInfoArea;
    private Cart cart;
    private JLabel orderIdLabel;

    public EcommerceSystem() {
        setTitle("E-Commerce System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initializeComponents();
        setupUI();
        pack();
        setVisible(true);
    }

    private void initializeComponents() {
        customerIdField = new JTextField();
        customerNameField = new JTextField();
        customerAddressField = new JTextField();
        productComboBox = new JComboBox<>();
        addToCartButton = new JButton("Add to Cart");
        placeOrderButton = new JButton("Place Order");
        cartArea = new JTextArea();
        orderInfoArea = new JTextArea();
        orderIdLabel = new JLabel("Order ID: N/A");
    }

    private void setupUI() {
        // Create components for customer details
        JPanel customerPanel = new JPanel(new GridLayout(3, 2));
        customerPanel.add(new JLabel("Customer ID:"));
        customerPanel.add(customerIdField);
        customerPanel.add(new JLabel("Customer Name:"));
        customerPanel.add(customerNameField);
        customerPanel.add(new JLabel("Customer Address:"));
        customerPanel.add(customerAddressField);

        // Create components for product selection and cart
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.add(new JLabel("Select Product:"), BorderLayout.NORTH);
        productComboBox.addItem(new ElectronicProduct(1, "Smartphone", 1, "Samsung", 599.9));
        productComboBox.addItem(new ClothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton"));
        productComboBox.addItem(new BookProduct(3, "OOP", 39.99, "O'Reilly", "X Publications"));
        productPanel.add(productComboBox, BorderLayout.CENTER);
        productPanel.add(addToCartButton, BorderLayout.EAST);

        JScrollPane cartScrollPane = new JScrollPane(cartArea);
        JScrollPane orderScrollPane = new JScrollPane(orderInfoArea);

        // Add components to the frame
        add(customerPanel, BorderLayout.NORTH);
        add(productPanel, BorderLayout.CENTER);
        add(cartScrollPane, BorderLayout.WEST);
        add(orderScrollPane, BorderLayout.EAST);
        
        // Add place order button and order ID label to the south border
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(placeOrderButton, BorderLayout.WEST);
        southPanel.add(orderIdLabel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        // Set up event handlers
        addToCartButton.addActionListener(new AddToCartListener());
        placeOrderButton.addActionListener(new PlaceOrderListener());
    }

    private class AddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add the selected product to the cart
            Product selectedProduct = (Product) productComboBox.getSelectedItem();
            cart.addProduct(selectedProduct);
            cartArea.append(selectedProduct.name + " added to cart.\n");
        }
    }

    private class PlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get customer details
                int customerId = Integer.parseInt(customerIdField.getText());
                String customerName = customerNameField.getText();
                String customerAddress = customerAddressField.getText();

                // Create a customer instance
                Customer customer = new Customer(customerId, customerName, customerAddress);

                // Create a cart instance
                cart = new Cart(customerId, 10);  // Maximum of 10 products in the cart

                // Add products to the cart
                for (int i = 0; i < productComboBox.getItemCount(); i++) {
                    Product product = (Product) productComboBox.getItemAt(i);
                    cart.addProduct(product);
                }

                // Place the order
                Order order = cart.placeOrder();

                // Update the order ID label and print order information
                orderIdLabel.setText("Order ID: " + order.getOrderId());
                orderInfoArea.append("Order ID: " + order.getOrderId() + "\n");
                orderInfoArea.append(order.toString() + "\n");
            } catch (NumberFormatException ex) {
                orderInfoArea.append("Invalid customer ID.\n");
            } catch (Exception ex) {
                orderInfoArea.append("An error occurred while placing the order.\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EcommerceSystem());
    }
}


