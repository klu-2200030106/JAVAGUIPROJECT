# Electronic Billing System

## Project Overview
The **Electronic Billing System** is a Java-based GUI application designed to automate the billing process for a shop. The system provides a user-friendly interface where customers can select products from different categories, apply discounts, calculate the total bill, and save the invoice for future reference.

## Features
- **Graphical User Interface (GUI)**: Built using Java Swing for an interactive user experience.
- **Item Categories**: Includes multiple product categories such as Grocery, Electronics, and Clothing.
- **Dynamic Item Selection**: Customers can choose products from a drop-down menu.
- **Discount Management**: Displays applicable discounts for selected items.
- **Bill Calculation**: Automatically computes the final price, including discounts.
- **File Storage**: Saves bills to a text file for record-keeping.
- **Print and Save**: Allows users to generate and save invoices.

## Technologies Used
- **Programming Language**: Java
- **GUI Framework**: Swing
- **Development Environment**: Eclipse IDE
- **Operating System**: Windows (XP or later)

## System Requirements
### Software Requirements:
- Java Development Kit (JDK)
- Eclipse IDE (or any Java-compatible IDE)

### Hardware Requirements:
- **RAM**: 8 GB or more
- **Processor**: Intel Core i5 or higher

## Installation & Setup
1. Clone the repository from GitHub:
   ```sh
   git clone https://github.com/your-username/electronic-billing-system.git
   ```
2. Open the project in Eclipse or any Java-supported IDE.
3. Compile and run `ShopBillingSystem.java`.

## Usage Instructions
1. Launch the application.
2. Select a category from the drop-down menu.
3. Choose an item and specify the quantity.
4. View the discount and total price.
5. Click "Add to Cart" to store the item.
6. Click "Print and Save Bill" to generate an invoice.

## Class Diagram
```plaintext
ShopBillingSystem
    - JFrame frame
    - JPanel panel
    - JComboBox categoryDropdown
    - JComboBox itemDropdown
    - JTextField discountField
    - JTextField priceField
    - JButton addButton
    - JButton printButton
    - FileWriter writer
    + actionPerformed(ActionEvent e)
```



## Future Enhancements
- Implement database storage for improved data management.
- Integrate barcode scanning for faster item selection.
- Add analytics and reporting features.

## Contributors
- **K Rohith Kumar** (2200030106)
- **A Hemanth** (2200030180)
- **ALD Rishi** (2200030183)
- **M Tej Vardhan** (2200030202)

## License
This project is licensed under the MIT License.

---
**Supervisor:** T. Ganeshan, Assistant Professor, KL University
