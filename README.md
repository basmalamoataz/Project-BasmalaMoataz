# Project-1
//I will explain first what is the importance of the code and why did i use it, below my explaination you will find the code itself.. in the end, i will write for you the whole code. Thank you.
// EcommerceSystem class extends JFrame, making it a Swing GUI application:
public class EcommerceSystem extends JFrame {
    // Components for the UI
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
    
    /* Constructor (EcommerceSystem())
Sets up the frame:
Sets the title.
Sets default close operation to exit on close.
Initializes all components and sets up the UI.
Finally, makes the frame visible : */  
public EcommerceSystem() {
        setTitle("E-Commerce System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initializeComponents();
        setupUI();
        pack();
        setVisible(true);
    }
    
/* customerIdField, customerNameField, customerAddressField: Text fields for customer information.
productComboBox: A combo box to select products.
addToCartButton: Button to add selected product to the cart.
placeOrderButton: Button to place the order.
cartArea: Text area to display cart contents.
orderInfoArea: Text area to display order information.
orderIdLabel: Label to display the order ID.   */
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
    /* setupUI()
This method sets up the UI layout:

Creates panels for customer info, product selection, cart display, and order info.
Adds labels, text fields, combo box, and buttons to the panels.
Sets up event listeners for addToCartButton and placeOrderButton. : */
private void setupUI() {
   
        JPanel customerPanel = new JPanel(new GridLayout(3, 2));
        customerPanel.add(new JLabel("Customer ID:"));
        customerPanel.add(customerIdField);
        customerPanel.add(new JLabel("Customer Name:"));
        customerPanel.add(customerNameField);
        customerPanel.add(new JLabel("Customer Address:"));
        customerPanel.add(customerAddressField);

        
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.add(new JLabel("Select Product:"), BorderLayout.NORTH);
        productComboBox.addItem(new ElectronicProduct(1, "Smartphone", 1, "Samsung", 599.9));
        productComboBox.addItem(new ClothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton"));
        productComboBox.addItem(new BookProduct(3, "OOP", 39.99, "O'Reilly", "X Publications"));
        productPanel.add(productComboBox, BorderLayout.CENTER);
        productPanel.add(addToCartButton, BorderLayout.EAST);
        JScrollPane cartScrollPane = new JScrollPane(cartArea);
        JScrollPane orderScrollPane = new JScrollPane(orderInfoArea);

        
        add(customerPanel, BorderLayout.NORTH);
        add(productPanel, BorderLayout.CENTER);
        add(cartScrollPane, BorderLayout.WEST);
        add(orderScrollPane, BorderLayout.EAST);
 
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(placeOrderButton, BorderLayout.WEST);
        southPanel.add(orderIdLabel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        addToCartButton.addActionListener(new AddToCartListener());
        placeOrderButton.addActionListener(new PlaceOrderListener());
    }
/* AddToCartListener Class
This is an ActionListener implementation for the "Add to Cart" button:
When the button is clicked, it gets the selected product from the combo box.
Adds the selected product to the cart.
Updates the cartArea to display the added product. : */
private class AddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add the selected product to the cart
            Product selectedProduct = (Product) productComboBox.getSelectedItem();
            cart.addProduct(selectedProduct);
            cartArea.append(selectedProduct.name + " added to cart.\n");
        }
    }
/* PlaceOrderListener Class
This is an ActionListener implementation for the "Place Order" button:
When the button is clicked, it tries to create a Customer object using the entered customer information.
Creates a new Cart object with the customer ID and a default cart size.
Iterates through all items in the product combo box and adds them to the cart.
Calls cart.placeOrder() to place the order and get an Order object.
Updates the orderIdLabel and orderInfoArea with the order ID and order details.
Catches exceptions for invalid customer ID or any other errors during order placement. */
private class PlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
          
                int customerId = Integer.parseInt(customerIdField.getText());
                String customerName = customerNameField.getText();
                String customerAddress = customerAddressField.getText();
                Customer customer = new Customer(customerId, customerName, customerAddress);
                cart = new Cart(customerId, 10);  

                for (int i = 0; i < productComboBox.getItemCount(); i++) {
                    Product product = (Product) productComboBox.getItemAt(i);
                    cart.addProduct(product);
                }
                Order order = cart.placeOrder();

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
/* main() Method
This is the entry point of the program.
It schedules the creation of the EcommerceSystem frame on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater().*/
  public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EcommerceSystem());
    }
} 
// The whole code:
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
   
        JPanel customerPanel = new JPanel(new GridLayout(3, 2));
        customerPanel.add(new JLabel("Customer ID:"));
        customerPanel.add(customerIdField);
        customerPanel.add(new JLabel("Customer Name:"));
        customerPanel.add(customerNameField);
        customerPanel.add(new JLabel("Customer Address:"));
        customerPanel.add(customerAddressField);

        
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.add(new JLabel("Select Product:"), BorderLayout.NORTH);
        productComboBox.addItem(new ElectronicProduct(1, "Smartphone", 1, "Samsung", 599.9));
        productComboBox.addItem(new ClothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton"));
        productComboBox.addItem(new BookProduct(3, "OOP", 39.99, "O'Reilly", "X Publications"));
        productPanel.add(productComboBox, BorderLayout.CENTER);
        productPanel.add(addToCartButton, BorderLayout.EAST);
        JScrollPane cartScrollPane = new JScrollPane(cartArea);
        JScrollPane orderScrollPane = new JScrollPane(orderInfoArea);

        
        add(customerPanel, BorderLayout.NORTH);
        add(productPanel, BorderLayout.CENTER);
        add(cartScrollPane, BorderLayout.WEST);
        add(orderScrollPane, BorderLayout.EAST);
 
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(placeOrderButton, BorderLayout.WEST);
        southPanel.add(orderIdLabel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

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
          
                int customerId = Integer.parseInt(customerIdField.getText());
                String customerName = customerNameField.getText();
                String customerAddress = customerAddressField.getText();
                Customer customer = new Customer(customerId, customerName, customerAddress);
                cart = new Cart(customerId, 10);  

                for (int i = 0; i < productComboBox.getItemCount(); i++) {
                    Product product = (Product) productComboBox.getItemAt(i);
                    cart.addProduct(product);
                }
                Order order = cart.placeOrder();

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




    
    

