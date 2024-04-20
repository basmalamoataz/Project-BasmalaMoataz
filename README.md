# Project-1
The Application:
![Screenshot 2024-04-20 165143](https://github.com/basmalamoataz/Project-BasmalaMoataz/assets/89751842/67bf75d1-776b-413c-8e91-bcdd7dc76f27)

Constructor (EcommerceSystem())
Sets up the frame:
Sets the title.
Sets default close operation to exit on close.
Initializes all components and sets up the UI.
Finally, makes the frame visible.

initializeComponents()
This method initializes all the components needed for the UI:
customerIdField, customerNameField, customerAddressField: Text fields for customer information.
productComboBox: A combo box to select products.
addToCartButton: Button to add selected product to the cart.
placeOrderButton: Button to place the order.
cartArea: Text area to display cart contents.
orderInfoArea: Text area to display order information.
orderIdLabel: Label to display the order ID.

setupUI()
This method sets up the UI layout:
Creates panels for customer info, product selection, cart display, and order info.
Adds labels, text fields, combo box, and buttons to the panels.
Sets up event listeners for addToCartButton and placeOrderButton.

AddToCartListener Class
This is an ActionListener implementation for the "Add to Cart" button:
When the button is clicked, it gets the selected product from the combo box.
Adds the selected product to the cart.
Updates the cartArea to display the added product.

PlaceOrderListener Class
This is an ActionListener implementation for the "Place Order" button:
When the button is clicked, it tries to create a Customer object using the entered customer information.
Creates a new Cart object with the customer ID and a default cart size.
Iterates through all items in the product combo box and adds them to the cart.
Calls cart.placeOrder() to place the order and get an Order object.
Updates the orderIdLabel and orderInfoArea with the order ID and order details.
Catches exceptions for invalid customer ID or any other errors during order placement.

main() Method
This is the entry point of the program.
It schedules the creation of the EcommerceSystem frame on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater().



    
    

