import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import  java.io.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
class CartItem {
    private String resturantName;
    private String itemName;
    private int price;
    private int quantity;
    public CartItem(String resturantName, String itemName, int price, int quantity) {
        this.resturantName = resturantName;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getResturantName() {
        return resturantName;   }
    public String getItemName() {
        return itemName;   }
    public int getPrice() {
        return price;   }
    public int getQuantity() {
        return quantity;    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;   }
    public void setPrice(int price) {
        this.price = price;   }
    public int getTotalprice() {
        return price * quantity;   }
}
class CartManager {
    static ArrayList<CartItem> cart = new ArrayList<>();
    private static int currentUserId = -1;
    public static void setCurrentUserId(int userId) {
        currentUserId = userId;
        System.out.println("Current User ID set to: " + userId);
    }
    public static int getCurrentUserId() {
        return currentUserId;     }
    public static void addItem(String resturant, String name, int pr, int qty) {
        for (CartItem existingItem : cart) {
            if (existingItem.getResturantName().equals(resturant) && existingItem.getItemName().equals(name)) {
                existingItem.setQuantity(existingItem.getQuantity() + qty);
                System.out.println("Update: " + name + "quantity now: " + existingItem.getQuantity());
                return;  }
        }
        CartItem newItem = new CartItem(resturant, name, pr, qty);
        cart.add(newItem);
        System.out.println("Addeds new item: " + name + " from " + resturant);
    }
    public static void removeItem(int index) {
        if(index >= 0 && index < cart.size()) {
            CartItem removedItem = cart.get(index);
            cart.remove(index);
            System.out.println("Removed: "+removedItem.getItemName());}
    }
    public static void clearCart() {
        cart.clear();   }
    public static void updateQuantity(int index,int newQuantity){
        if(index>=0 && index< cart.size()){
            CartItem item3=cart.get(index);
            if(newQuantity <=0){
                cart.remove(index);
                System.out.println("Removed: "+item3.getItemName() +" quantity: "+newQuantity);}
        }
    }
    public static int getSubtotal() {
        int subtotal = 0;
        for (CartItem item : cart) {
            subtotal += item.getTotalprice();}
        return subtotal;
    }
    public static double getDelieveryFee() {
        if (getSubtotal() == 0) {
            return 0;   }
        return 100;   }
    public static double getTax() {
        if(getSubtotal()>0){
        return  30;   }
        return 0;    }
    public static double getGrandTotal() {
        return getSubtotal() + getTax() + getDelieveryFee();    }
    public static boolean saveOrderToDatabase() {
        if (currentUserId == -1) {
            JOptionPane.showMessageDialog(null, "Please login first!");
            return false;  }
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return false;   }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodie_db", "root", "ummeruman895")) {
            String orderSQL = "INSERT INTO orders (user_id, total_amount, status, payment_method) VALUES (?, ?, ?, ?)";
            PreparedStatement orderStmt = con.prepareStatement(orderSQL, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, currentUserId);
            orderStmt.setInt(2, (int) getGrandTotal());
            orderStmt.setString(3, "Pending");
            orderStmt.setString(4, "Cash on Delivery");
            orderStmt.executeUpdate();
            ResultSet rs = orderStmt.getGeneratedKeys();
            int orderId = -1;
            if (rs.next()) {
                orderId = rs.getInt(1);    }
            String itemSQL = "INSERT INTO order_items (order_id, restaurant, item_name, price, quantity, total_price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement itemStmt = con.prepareStatement(itemSQL);
            for (CartItem item : cart) {
                itemStmt.setInt(1, orderId);
                itemStmt.setString(2, item.getResturantName());
                itemStmt.setString(3, item.getItemName());
                itemStmt.setInt(4, item.getPrice());
                itemStmt.setInt(5, item.getQuantity());
                itemStmt.setInt(6, item.getTotalprice());
                itemStmt.executeUpdate();   }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            return false;   }
    }
}
    class CartPanel extends JPanel{
    private JPanel cartItemsPanel;
    private JLabel subtotalLabel;
    private JLabel taxLabel;
    private  JLabel delieveryLabel;
    private JLabel grandTotalLabel;
    CartPanel(){
        setSize(1200,800);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        createHeader();
        createCartItemsArea();
        createSummaryPanel();
        refreshCart();
    }
    private void createHeader(){
        JPanel header =new JPanel();
        header.setLayout(new FlowLayout());
        header.setBackground(new Color(40,167,69));
        header.setPreferredSize(new Dimension(900,80));
        JLabel title =new JLabel("YOUR SHOPPING CART");
        title.setFont(new Font("Arial",Font.BOLD,28));
        title.setForeground(Color.WHITE);
        header.add(title);
        add(header,BorderLayout.NORTH);
    }
    private void createCartItemsArea(){
        cartItemsPanel=new JPanel();
        cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel,BoxLayout.Y_AXIS));
        cartItemsPanel.setBackground(Color.WHITE);
        JScrollPane scrollPane=new JScrollPane(cartItemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane,BorderLayout.CENTER);
    }
    private void createSummaryPanel(){
        JPanel summaryPanel=new JPanel();
        summaryPanel.setLayout(new BoxLayout(summaryPanel,BoxLayout.Y_AXIS));
        summaryPanel.setPreferredSize(new Dimension(300,400));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JLabel summaryTitle = new JLabel("ORDER SUMMARY");
        summaryTitle.setFont(new Font("Arial" , Font.BOLD,20));
        summaryTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtotalLabel=new JLabel("Subtotal: Rs.0");
        subtotalLabel.setFont(new Font("Arial",Font.PLAIN,16));
        subtotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        taxLabel=new JLabel("Tax (%5): Rs. 0");
        taxLabel.setFont(new Font("Arial",Font.PLAIN,16));
        taxLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        delieveryLabel=new JLabel("Delivery Fee: Rs. 150");
        delieveryLabel.setFont(new Font("Arial",Font.PLAIN,16));
        delieveryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        grandTotalLabel =new JLabel("Grand Total: Rs. 0");
        grandTotalLabel.setFont(new Font("Arial",Font.BOLD,20));
        grandTotalLabel.setForeground(new Color(40, 167, 69));
        grandTotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton checkoutButton=new JButton("PROCEED TO CHECKOUT");
        checkoutButton.setBackground(new Color(40,167,69));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setFont(new Font("Arial",Font.BOLD,16));
        checkoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkoutButton.addActionListener(e->checkout());
        JButton clearButton = new JButton("CLEAR CART");
        clearButton.setBackground(new Color(220,53,69));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial",Font.BOLD,14));
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.addActionListener(e -> clearCart());
        summaryPanel.add(summaryTitle);
        summaryPanel.add(Box.createVerticalStrut(20));
        summaryPanel.add(subtotalLabel);
        summaryPanel.add(Box.createVerticalStrut(10));
        summaryPanel.add(taxLabel);
        summaryPanel.add(Box.createVerticalStrut(10));
        summaryPanel.add(delieveryLabel);
        summaryPanel.add(Box.createVerticalStrut(20));
        summaryPanel.add(Box.createVerticalStrut(20));
        summaryPanel.add(grandTotalLabel);
        summaryPanel.add(Box.createVerticalStrut(30));
        summaryPanel.add(checkoutButton);
        summaryPanel.add(Box.createVerticalStrut(10));
        summaryPanel.add(clearButton);
        add(summaryPanel,BorderLayout.EAST);
    }
        private JPanel createCartITRow(CartItem item, int index) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER));
            row.setBackground(Color.WHITE);
            row.setPreferredSize(new Dimension(800, 50));
            row.setMaximumSize(new Dimension(800, 50));
            JLabel restaurantLabel = new JLabel(item.getResturantName());
            restaurantLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            restaurantLabel.setForeground(Color.GRAY);
            JLabel nameLabel = new JLabel(item.getItemName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            JPanel qtyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            qtyPanel.setBackground(Color.WHITE);
            JButton minusButton = new JButton("-");
            minusButton.setPreferredSize(new Dimension(30, 25));
            minusButton.setBackground(new Color(220, 53, 69));
            minusButton.setForeground(Color.WHITE);
            JLabel qtyLabel = new JLabel(String.valueOf(item.getQuantity()));
            qtyLabel.setFont(new Font("Arial", Font.BOLD, 14));
            qtyLabel.setPreferredSize(new Dimension(30, 25));
            qtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JButton plusBtn = new JButton("+");
            plusBtn.setPreferredSize(new Dimension(30, 25));
            plusBtn.setBackground(new Color(40, 167, 69));
            plusBtn.setForeground(Color.WHITE);
            qtyPanel.add(minusButton);
            qtyPanel.add(qtyLabel);
            qtyPanel.add(plusBtn);
            JLabel priceLabel = new JLabel("Rs. " + item.getTotalprice());
            priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
            priceLabel.setForeground(new Color(40, 167, 69));
            row.add(restaurantLabel);
            row.add(nameLabel);
            row.add(qtyPanel);
            row.add(priceLabel);
            minusButton.addActionListener(e -> {
                int newQty = item.getQuantity() - 1;
                if (newQty > 0) {
                    item.setQuantity(newQty);
                    refreshCart(); }
                else {
                    CartManager.cart.remove(index);
                    refreshCart();}
            });
            plusBtn.addActionListener(e -> {
                int newQty = item.getQuantity() + 1;
                item.setQuantity(newQty);
                refreshCart();
            });
            return row;
        }
    public  void refreshCart(){
        cartItemsPanel.removeAll();
        if(!CartManager.cart.isEmpty()){
            for(int i=0;i<CartManager.cart.size();i++){
                cartItemsPanel.add(createCartITRow(CartManager.cart.get(i),i));
                cartItemsPanel.add(Box.createVerticalStrut(10));  }
        }
        int subtotal = CartManager.getSubtotal();
        double tax=CartManager.getTax();
        double delievery=CartManager.getDelieveryFee();
        double grandTotal=CartManager.getGrandTotal();
        subtotalLabel.setText(String.format("Subtotal: Rs. %.0f" , (double) subtotal));
        taxLabel.setText(String .format("Tax (5%%): Rs.%.0f",tax));
        delieveryLabel.setText(String.format("Delivery Fee: Rs. %.0f",delievery));
        grandTotalLabel.setText(String.format("Grand Total: Rs. %.0f",grandTotal));
        cartItemsPanel.revalidate();
        cartItemsPanel.repaint();
    }
    private void checkout() {
        System.out.println("Current User ID: " + CartManager.getCurrentUserId());
        int userId = CartManager.getCurrentUserId();
        if (userId == -1) {
            JOptionPane.showMessageDialog(this, "Please login first!");
            return;   }
        int confirm = JOptionPane.showConfirmDialog(this, "Proceed to checkout?\nTotal: Rs. " + CartManager.getGrandTotal(), "Checkout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean dbSuccess = CartManager.saveOrderToDatabase();
            if (dbSuccess) {
                CartManager.cart.clear();
                refreshCart();
                JOptionPane.showMessageDialog(this, "Order placed successfully!");}
            else {
                JOptionPane.showMessageDialog(this, "Order failed!");}}}
    private void clearCart(){
        int confirm=JOptionPane.showConfirmDialog(this,"Clear entire cart? ","Confirm",JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            CartManager.cart.clear();
            refreshCart();}}}
public class Main {
    public static void main(String[] args) {
        new DashBoard();}}