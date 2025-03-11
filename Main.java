package PROJECTTEST;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
public class ShopBillingSystem implements ActionListener
{
    JFrame f;
    JLabel categoryLabel, itemLabel, discountLabel, priceLabel, totalLabel,quantityLabel;
	JTextField discountField, priceField, totalField;
	JButton addButton, printButton;
	JComboBox<String> categoryDropdown, itemDropdown;
	JComboBox<String>Quantity;
	 // Data
	 // Data
		String[] categories = {"GROCERY", "ELECTRONICS", "CLOTHING"};
	    String[][] items = {{"BREAD", "MILK", "EGGS"}, {"TV", "LAPTOP", "PHONE"}, {"SHIRT", "PANTS", "DRESS"}};
	    String q2[]= {"1","2","3","4","5","6","7","8","9","10"};
	    double[][] prices = {{1.99, 2.99, 3.99}, {399.99, 799.99, 999.99}, {24.99, 34.99, 49.99}};
	    double[] discounts = {0.1, 0.15, 0.2}; // Discounts as a percentage
	    double[] quantity= {1,2,3,4,5,6,7,8,9,10};
        double total = 0.0;
        FileWriter wr;
 		PrintWriter writer;
 		 static double tp=0;
	   public ShopBillingSystem()
    {
    	JFrame f=new JFrame("GROCERY BILLING SYSTEM");
    	f.setSize(900,900);
    	f.setLayout(null);
    	categoryLabel = new JLabel("CATEGORY:");
    	categoryLabel.setBounds(100,100,100,70);
    	f.add(categoryLabel);
    	itemLabel = new JLabel("  ITEM:");
    	itemLabel.setBounds(100,200,100,70);
    	f.add(itemLabel);
    	discountLabel = new JLabel("DISCOUNT:");
    	discountLabel.setBounds(100,300,100,70);
    	f.add(discountLabel);
   	    priceLabel = new JLabel("  PRICE:");
   	    priceLabel.setBounds(100,400,100,70);
   	    f.add(priceLabel);
   	    totalLabel = new JLabel(" TOTAL:");
   	    totalLabel.setBounds(100,500,100,70);
   	    f.add(totalLabel);
   	    categoryDropdown = new JComboBox<String>(categories);
   	    categoryDropdown.setBounds(300,100,400,80);
   	    categoryDropdown.addActionListener(this);
   	    f.add(categoryDropdown);
   	    itemDropdown = new JComboBox<String>();
   	    itemDropdown.setBounds(300,200,400,80);
   	    itemDropdown.addActionListener(this);
   	    f.add(itemDropdown);
   	    quantityLabel=new JLabel("QUANTITY:");
   	    quantityLabel.setBounds(750,200,100,70);
   	    f.add(quantityLabel);
   	    Quantity=new JComboBox<String>(q2);
   	    Quantity.setBounds(850,200,400,80);
   	    Quantity.addActionListener(this);
   	    f.add(Quantity);
    	discountField = new JTextField();
    	discountField.setBounds(300,300,400,80);
    	f.add(discountField);
    	priceField = new JTextField();
    	priceField.setBounds(300,400,400,80);
    	f.add(priceField);
	    totalField = new JTextField();
	    totalField.setBounds(300,500,400,80);
	    f.add(totalField);
   	    addButton = new JButton("ADD TO CART");
   	    addButton.setBounds(150,650,250,90);
   	    addButton.addActionListener(this);
   	    f.add(addButton);
	    printButton = new JButton("PRINT AND SAVE BILL");
	    printButton.setBounds(450,650,250,90);
	    printButton.addActionListener(this);
	    f.add(printButton);
	    f.getContentPane().setBackground(Color.CYAN);
    	f.setVisible(true);
    }
	public static void main(String[] args) 
	{
	   new ShopBillingSystem();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == categoryDropdown) 
		{
   		 int categoryIndex = categoryDropdown.getSelectedIndex();
   		 itemDropdown.removeAllItems();
   		 for (String item : items[categoryIndex]) 
   		 {
   		 itemDropdown.addItem(item);
   		 Quantity.addItem(item);
   		 }
   		} 
		else if (e.getSource() == Quantity ) 
   		 {
   		 int categoryIndex1 = categoryDropdown.getSelectedIndex();
   		 int itemIndex = itemDropdown.getSelectedIndex();
   		 int quanityIndex=Quantity.getSelectedIndex();
   		 double price = prices[categoryIndex1][itemIndex];
   		 double discount = discounts[categoryIndex1];
   		 double q1 =quantity[quanityIndex];
   		 double discountedPrice =q1* price * (1 - discount);
  		 priceField.setText(String.format("$%.2f", price));
  		 discountField.setText(String.format("%.0f%%", discount * 100));
  		 totalField.setText(String.format("$%.2f", discountedPrice));
   		 } 
		else if (e.getSource() == addButton) 
		{
   		 double price = Double.parseDouble(priceField.getText().substring(1));
   		 double discountedPrice = Double.parseDouble(totalField.getText().substring(1));
   		 total += discountedPrice;
   		 tp+=total;
   		try 
  		 {
  		   wr = new FileWriter("C:\\Users\\kandu\\OneDrive\\Desktop\\CTOODJAVA\\Project.txt.txt",true);
  		   writer=new PrintWriter(wr,true);
  		 //writer.write("\n");
  		 writer.print("Item:"+itemDropdown.getSelectedItem().toString());
  		 writer.write("\t");
  		 writer.print("Quantity:"+Quantity.getSelectedItem().toString());
  		 writer.write("\t");
  		 writer.println(String.format("TOTALCOST: $%.2f", total));
  		 writer.write("\n");
  		priceField.setText("");
		 discountField.setText("");
		 totalField.setText("");
		 itemDropdown.setSelectedItem(null);
  		 }
  		 	catch (IOException ex)
  		 {
  		 		JOptionPane.showMessageDialog(f, "ERROR: UNABLE TO SAVE BILL.");		 
  		 }
   		 } 
		else if (e.getSource() == printButton)
		{
			 writer.println(String.format("TOTAL BILL COSTED: $%.2f", tp));
	  		 writer.close();
	  		 JOptionPane.showMessageDialog(f, "BILL PRINTED and SAVED SUCESSFULLY!");
	  		 total = 0.0;
	  		 writer.flush();
		}
	}
}