# Project-1
![Screenshot 2024-04-20 133418](https://github.com/basmalamoataz/Project-BasmalaMoataz/assets/89751842/4d4ac55c-d1ea-4ec5-9783-ecd03c6bfc50)
![Screenshot 2024-04-20 133543](https://github.com/basmalamoataz/Project-BasmalaMoataz/assets/89751842/682c1b22-7c6e-45e6-afa0-7997cb18f719)
![Screenshot 2024-04-20 133617](https://github.com/basmalamoataz/Project-BasmalaMoataz/assets/89751842/7cf22dec-bf0c-4cfc-8091-5bf03ccc4bef)
![Screenshot 2024-04-20 134111](https://github.com/basmalamoataz/Project-BasmalaMoataz/assets/89751842/bf8421a8-0768-487a-81d2-592b38cf9622)
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



    
    

