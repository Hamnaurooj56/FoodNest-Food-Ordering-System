import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseListener;
 class Registration extends JFrame implements ActionListener, MouseListener{
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JPanel p5;
     JPanel homePanel;
     JPanel CartPanel;
     ImageIcon i1;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;
    JLabel l9;
    JLabel l10;
    JTextField usernameField;
    JTextField passwordField;
    JTextField emailField;
    JTextField phoneNoField;
    JTextField addressField;
    JButton loginButton;
    GridBagConstraints g1;
  Registration() {
        this.setSize(1200, 850);
        this.setTitle("FoodNest");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        p2 = new JPanel();
        p2.setSize(1200, 800);
        p2.setLayout(new GridBagLayout());
        p2.setBackground(new Color(211, 211, 211));

        g1 = new GridBagConstraints();
        g1.gridx = 0;
        g1.gridy = 0;
        g1.anchor = GridBagConstraints.CENTER;
        g1.insets = new Insets(20, 20, 20, 20);

        p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p2.add(p3, g1);
        p3.setSize(500, 650);
        p3.setPreferredSize(new Dimension(500, 650));
        p3.setBackground(Color.WHITE);
        p3.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 2));
        p4 = new JPanel();
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        p4.setBackground(Color.WHITE);
        p4.setSize(new Dimension(500, 150));
        l4 = new JLabel("           Create Your Account        ");
        l4.setFont(new Font("Arial", Font.BOLD, 24));
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        l5 = new JLabel("Register to Start Your Food Journey");
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
        p4.add(Box.createVerticalStrut(40));
        p4.add(l4);
        p4.add(Box.createVerticalStrut(10));
        p4.add(l5);
        p4.add(Box.createVerticalStrut(40));
        p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setBackground(Color.WHITE);
        p5.setMaximumSize(new Dimension(400, 500));
        l6 = new JLabel("Username: ");
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(380, 40));
        usernameField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        l7 = new JLabel("Email Address: ");
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(380, 40));
        emailField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        l8 = new JLabel("Phone Number: ");
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        phoneNoField = new JTextField();
        phoneNoField.setPreferredSize(new Dimension(380, 40));
        phoneNoField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        phoneNoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        l9 = new JLabel("Password: ");
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(380, 40));
        passwordField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        l10 = new JLabel("Delivery Address: ");
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(380, 40));
        addressField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        addressField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton = new JButton("Register");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(40, 167, 69));
        loginButton.setPreferredSize(new Dimension(380, 50));
        loginButton.setFocusable(false);
        loginButton.setBounds(400, 300, 380, 50);
        loginButton.addActionListener(this);
        p3.add(p4);
        p3.add(p5);
        p5.add(l6);
        p5.add(usernameField);
        p5.add(l7);
        p5.add(emailField);
        p5.add(l8);
        p5.add(phoneNoField);
        p5.add(l9);
        p5.add(passwordField);
        p5.add(l10);
        p5.add(addressField);
        p5.add(loginButton);
      SideBar sb = new SideBar();
      homePanel = sb.getHomePanel();
      CartPanel = sb.getCartPanel();
      homePanel.addMouseListener(this);
      CartPanel.addMouseListener(this);
      this.add(sb.getSidebar(), BorderLayout.WEST);
        this.add(p2, BorderLayout.CENTER);
        this.setVisible(true);
    }
     @Override
     public void mousePressed(MouseEvent e) {}
     @Override
     public void mouseReleased(MouseEvent e) {}
     public void mouseEntered(MouseEvent e) {
         if (e.getSource() == homePanel) {
             homePanel.setBackground(new Color(40, 167, 69));}
         else if (e.getSource() == CartPanel) {
             CartPanel.setBackground(new Color(40, 167, 69));}
     }
     @Override
     public void mouseExited(MouseEvent e) {
         if (e.getSource() == homePanel) {
             homePanel.setBackground(new Color(15, 42, 46));}
         else if (e.getSource() == CartPanel) {
             CartPanel.setBackground(new Color(15, 42, 46));}
     }
     @Override
     public void mouseClicked(MouseEvent e) {
         if (e.getSource() == CartPanel) {
             JOptionPane.showMessageDialog(null,
                     "Please login/register first to access cart!");}
         else if (e.getSource() == homePanel) {
             JOptionPane.showMessageDialog(null,
                     "Please complete registration first!");}
     }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = usernameField.getText();
            String mail = emailField.getText();
            String phone = phoneNoField.getText();    // Get phone
            String pass = passwordField.getText();
            String addr = addressField.getText();    // Get address
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodie_db", "root", "ummeruman895");
                String query = "INSERT INTO users (username, password, email, phone_number, delivery_address) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, user);
                pst.setString(2, pass);
                pst.setString(3, mail);
                pst.setString(4, phone);
                pst.setString(5, addr);
              int rows=  pst.executeUpdate();
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int userId = rs.getInt(1);
                    CartManager.setCurrentUserId(userId);
                    System.out.println("Logged in User ID: " + userId);
                }
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                this.dispose();
                new DashBoard();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }
}
class SideBar extends JPanel implements  MouseListener{
    JPanel p1;
    JPanel homePanel;
    JPanel CartPanel;
    JPanel Delievery;
    JLabel homeIcon;
    JLabel homeText;
    JLabel CartIcon;
    JLabel CartText;
    JLabel DelieveryText1;
    JLabel DelieveryText2;
    JLabel DelieveryIcon;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    ImageIcon i1;
SideBar(){
    buildSidebar();}
    public void buildSidebar() {
        p1 = new JPanel();
        p1.setSize(250, 800);
        p1.setPreferredSize(new Dimension(250, 800));
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setBackground(new Color(15, 42, 46));
        l1 = new JLabel();
        i1 = new ImageIcon("foodie icon.png");
        Image scaledImage = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        l1.setIcon(new ImageIcon(scaledImage));
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Foodie");
        l2.setFont(new Font("Arial", Font.BOLD, 25));
        l2.setForeground(Color.WHITE);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Good Food, Good Mood");
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setForeground(Color.WHITE);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homePanel.setBackground(new Color(15, 42, 46));
        homePanel.setMaximumSize(new Dimension(250, 50));
        ImageIcon homeIconimage = new ImageIcon("home.png");
        Image img1 = homeIconimage.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        homeIcon = new JLabel(new ImageIcon(img1));
        homeText = new JLabel("Home");
        homeText.setForeground(Color.WHITE);
        homeText.setFont(new Font("Arial", Font.BOLD, 16));
        homePanel.add(homeIcon);
        homePanel.add(Box.createHorizontalStrut(18)); // space
        homePanel.add(homeText);
        CartPanel = new JPanel();
        CartPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        CartPanel.setBackground(new Color(15, 42, 46));
        CartPanel.setMaximumSize(new Dimension(250, 50));
        ImageIcon MyOrderIconimage = new ImageIcon("Myorder.png");
        Image img3 = MyOrderIconimage.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        CartIcon = new JLabel(new ImageIcon(img3));
        CartText = new JLabel("Cart");
        CartText.setForeground(Color.WHITE);
        CartText.setFont(new Font("Arial", Font.BOLD, 16));
        CartPanel.add(CartIcon);
        CartPanel.add(Box.createHorizontalStrut(18));
        CartPanel.add(CartText);
        Delievery = new JPanel();
        Delievery.setLayout(new FlowLayout(FlowLayout.LEFT));
        Delievery.setBackground(new Color(40, 167, 69));
        Delievery.setMaximumSize(new Dimension(270, 450));
        DelieveryText1 = new JLabel("        Fast Delievery");
        DelieveryText1.setForeground(Color.WHITE);
        DelieveryText1.setFont(new Font("Arial", Font.BOLD, 18));
        DelieveryText1.setAlignmentX(Component.CENTER_ALIGNMENT);
        DelieveryText2 = new JLabel("      At Your Doorstep");
        DelieveryText2.setForeground(Color.WHITE);
        DelieveryText2.setFont(new Font("Arial", Font.BOLD, 18));
        DelieveryText1.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImageIcon delieveryIcon = new ImageIcon("delieveryBoy.png");
        Image img7 = delieveryIcon.getImage().getScaledInstance(270, 420, Image.SCALE_SMOOTH);
        DelieveryIcon = new JLabel(new ImageIcon(img7));
        Delievery.add(DelieveryText1);
        Delievery.add(DelieveryText2);
        Delievery.add(DelieveryIcon);
        p1.add(Box.createVerticalStrut(30));
        p1.add(l1);
        p1.add(Box.createVerticalStrut(10));
        p1.add(l2);
        p1.add(Box.createVerticalStrut(10));
        p1.add(l3);
        p1.add(Box.createVerticalStrut(20));
        p1.add(homePanel);
        p1.add(Box.createVerticalStrut(20));
        p1.add(CartPanel);
        p1.add(Box.createVerticalStrut(20));
        p1.add(Delievery);
        homePanel.addMouseListener(this);
        CartPanel.addMouseListener(this);
    }
    public JPanel getSidebar() {
        return p1;
    }
    public JPanel getHomePanel() {
        return homePanel;
    }
    public JPanel getCartPanel() {
        return CartPanel;
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==homePanel) {
            homePanel.setBackground(new Color(40, 167, 69));}
        if(e.getSource()==CartPanel){
            CartPanel.setBackground(new Color(40, 167, 69));}
    }
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==homePanel){
            homePanel.setBackground(new Color(15, 42, 46));
        }
        if(e.getSource()==CartPanel){
            CartPanel.setBackground(new Color(15, 42, 46));
        }}
}
class Session {
    private static String currentUser;
    public static void login(String username) {
        currentUser = username;
    }
    public static String getUser() {
        return currentUser;
    }
    public static void logout() {
        currentUser = null;
    }
}
public class RegistrationPage {
    public static  void main(String[] args){
        new Registration();}}