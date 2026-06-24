import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 class DashBoard extends JFrame  implements ActionListener,MouseListener {
     CardLayout c1;
     JPanel sidebar;
     JPanel hpanel;
     JPanel cpanel;
     JPanel homePanel;
     JPanel CartPanel;
     JPanel contentArea;
     JPanel header;
     JPanel brands;
     JPanel cheezious;
     JPanel bundukhan;
     JPanel tahzeeb;
     JPanel optp;
     JButton b1;
     JButton b2;
     JButton b3;
     JButton b4;
     JLabel l4;
     JLabel l5;
     JLabel l6;
     JLabel l7;
     JLabel l8;
     JLabel l9;
     JLabel l10;
     JLabel l12;
     JLabel l13;
     JLabel l14;
     JLabel l15;
     JLabel l16;
     JLabel l17;
     JLabel l18;
     JLabel l19;
     JLabel l20;
     ImageIcon i2;
     ImageIcon i3;
     ImageIcon i4;
     ImageIcon i5;
     DashBoard() {
         setTitle("FoodNest");
         setSize(1200, 850);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
         setResizable(false);
         SideBar sb = new SideBar();
         sidebar = sb.getSidebar();
         homePanel = sb.getHomePanel();
         CartPanel = sb.getCartPanel();
         hpanel = new JPanel();
         hpanel.setLayout(new BorderLayout());
         cpanel = new CartPanel();
         contentArea = new JPanel();
         c1 = new CardLayout();
         contentArea.setLayout(c1);
         header = new JPanel();
         header.setPreferredSize(new Dimension(900, 140));
         header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
         l4 = new JLabel("FoodNest");
         l4.setFont(new Font("Arial", Font.BOLD, 31));
         l4.setForeground(Color.BLACK);
         l4.setAlignmentX(Component.CENTER_ALIGNMENT);
         l5 = new JLabel("Welcome to FoodNest");
         l5.setFont(new Font("Arial", Font.PLAIN, 27));
         l5.setForeground(new Color(46, 46, 46));
         l5.setAlignmentX(Component.CENTER_ALIGNMENT);
         l6 = new JLabel("Delicious food at your Doorstep");
         l6.setFont(new Font("Arial", Font.PLAIN, 20));
         l6.setForeground(new Color(119, 119, 119));
         l6.setAlignmentX(Component.CENTER_ALIGNMENT);
         l7 = new JLabel(" Top Restaurants");
         l7.setFont(new Font("Arial", Font.PLAIN, 20));
         l7.setForeground(new Color(119, 119, 119));
         header.add(Box.createVerticalStrut(10));
         header.add(l4);
         header.add(Box.createVerticalStrut(10));
         header.add(l5);
         header.add(Box.createVerticalStrut(10));
         header.add(l6);
         header.add(Box.createVerticalStrut(18));
         header.add(l7);
         brands = new JPanel();
         brands.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
         brands.setBackground(Color.WHITE);
         cheezious = new JPanel();
         cheezious.setPreferredSize(new Dimension(170, 220));
         cheezious.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
         cheezious.setBackground(Color.WHITE);
         l9 = new JLabel("Cheezious");
         l9.setFont(new Font("Arial", Font.BOLD, 20));
         l10 = new JLabel("Fast Food");
         l10.setFont(new Font("Arial", Font.PLAIN, 20));
         i2 = new ImageIcon("cheezious.jpg");
         Image Scaledi2 = i2.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
         l8 = new JLabel();
         l8.setIcon(new ImageIcon(Scaledi2));
         l8.setAlignmentX(Component.CENTER_ALIGNMENT);
         b1 = new JButton("View Menu");
         b1.setBackground(new Color(39, 174, 96));
         b1.setForeground(Color.WHITE);
         b1.setFont(new Font("Arial", Font.BOLD, 18));
         b1.setPreferredSize(new Dimension(150, 32));
         cheezious.add(l8);
         cheezious.add(l9);
         cheezious.add(l10);
         cheezious.add(b1);
         bundukhan = new JPanel();
         bundukhan.setPreferredSize(new Dimension(170, 220));
         bundukhan.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
         bundukhan.setBackground(Color.WHITE);
         l12 = new JLabel("Bundu Khan");
         l12.setFont(new Font("Arial", Font.BOLD, 20));
         l13 = new JLabel("Desi");
         l13.setFont(new Font("Arial", Font.PLAIN, 20));
         i3 = new ImageIcon("bundu khan.jpg");
         Image Scaledi3 = i3.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH);
         l14 = new JLabel();
         l14.setIcon(new ImageIcon(Scaledi3));
         l14.setAlignmentX(Component.CENTER_ALIGNMENT);
         b2 = new JButton("View Menu");
         b2.setBackground(new Color(39, 174, 96));
         b2.setForeground(Color.WHITE);
         b2.setFont(new Font("Arial", Font.BOLD, 18));
         b2.setPreferredSize(new Dimension(150, 32));
         bundukhan.add(l14);
         bundukhan.add(l12);
         bundukhan.add(l13);
         bundukhan.add(b2);
         optp = new JPanel();
         optp.setPreferredSize(new Dimension(170, 220));
         optp.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
         optp.setBackground(Color.WHITE);
         l15 = new JLabel("      Optp       ");
         l15.setFont(new Font("Arial", Font.BOLD, 20));
         l16 = new JLabel("  Fast Food ");
         l16.setFont(new Font("Arial", Font.PLAIN, 20));
         i4 = new ImageIcon("optp.png");
         Image Scaledi4 = i4.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
         l17 = new JLabel();
         l17.setIcon(new ImageIcon(Scaledi4));
         l17.setAlignmentX(Component.CENTER_ALIGNMENT);
         b3 = new JButton("View Menu");
         b3.setBackground(new Color(39, 174, 96));
         b3.setForeground(Color.WHITE);
         b3.setFont(new Font("Arial", Font.BOLD, 18));
         b3.setPreferredSize(new Dimension(150, 32));
         optp.add(l17);
         optp.add(l15);
         optp.add(l16);
         optp.add(b3);
         tahzeeb = new JPanel();
         tahzeeb.setPreferredSize(new Dimension(170, 220));
         tahzeeb.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
         tahzeeb.setBackground(Color.WHITE);
         l18 = new JLabel("   Tahzeeb   ");
         l18.setFont(new Font("Arial", Font.BOLD, 20));
         l19 = new JLabel("Bakery");
         l19.setFont(new Font("Arial", Font.PLAIN, 20));
         i5 = new ImageIcon("tahzeeb.jpg");
         Image Scaledi5 = i5.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
         l20 = new JLabel();
         l20.setIcon(new ImageIcon(Scaledi5));
         l20.setAlignmentX(Component.CENTER_ALIGNMENT);
         b4 = new JButton("View Menu");
         b4.setBackground(new Color(39, 174, 96));
         b4.setForeground(Color.WHITE);
         b4.setFont(new Font("Arial", Font.BOLD, 18));
         b4.setPreferredSize(new Dimension(150, 32));
         tahzeeb.add(l20);
         tahzeeb.add(l18);
         tahzeeb.add(l19);
         tahzeeb.add(b4);
         brands.add(cheezious);
         brands.add(bundukhan);
         brands.add(optp);
         brands.add(tahzeeb);
         hpanel.add(header, BorderLayout.NORTH);
         hpanel.add(brands, BorderLayout.CENTER);
         b1.addActionListener(this);
         contentArea.add(hpanel, "Home");
         contentArea.add(cpanel, "Cart");
         add(sb.getSidebar(), BorderLayout.WEST);
         add(contentArea, BorderLayout.CENTER);
         b2.addActionListener(this);
         b4.addActionListener(this);
         b3.addActionListener(this);
         homePanel.addMouseListener(this);
         CartPanel.addMouseListener(this);
         setVisible(true);
     }
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
         if (e.getSource() == homePanel) {
             c1.show(contentArea, "Home");}
         else if (e.getSource() == CartPanel) {
             ((CartPanel)cpanel).refreshCart();
             c1.show(contentArea,"Cart");}
     }
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == b1) {
             new CheeziousFrame();}
         else if (e.getSource() == b2) {
             new bundukhanFrame();}
         else if (e.getSource() == b3) {
             new optpFrame();}
         else if (e.getSource() == b4) {
             new tahzeebFrame();}
     }
 }
 class sidebar1{
     JPanel sidebar;
     JButton backBtn;
     sidebar1(){
         sidebar = new JPanel();
         sidebar.setPreferredSize(new Dimension(250, 800));
         sidebar.setBackground(new Color(15, 42, 46));
         sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
         ImageIcon logo = new ImageIcon("foodie icon.png");
         Image logoimg = logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
         JLabel logoLabel = new JLabel(new ImageIcon(logoimg));
         logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         JLabel title = new JLabel("Foodie");
         title.setForeground(Color.WHITE);
         title.setFont(new Font("Arial", Font.BOLD, 28));
         title.setAlignmentX(Component.CENTER_ALIGNMENT);
         JLabel slogan = new JLabel("Good Food, Good Mood");
         slogan.setForeground(Color.WHITE);
         slogan.setFont(new Font("Arial", Font.PLAIN, 18));
         slogan.setAlignmentX(Component.CENTER_ALIGNMENT);
         sidebar.add(Box.createVerticalStrut(30));
         sidebar.add(logoLabel);
         sidebar.add(Box.createVerticalStrut(10));
         sidebar.add(title);
         sidebar.add(Box.createVerticalStrut(10));
         sidebar.add(slogan);
         sidebar.add(Box.createVerticalStrut(30));
          backBtn = new JButton("← Back to Dashboard");
         backBtn.setBackground(new Color(40, 167, 69));
         backBtn.setForeground(Color.WHITE);
         backBtn.setFont(new Font("Arial", Font.BOLD, 14));
         backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
         sidebar.add(backBtn);
     }
     public JButton getBackButton() {
         return backBtn;
     }
 }
class CheeziousFrame extends JFrame implements ActionListener {
    String[] itemNames = {"Zinger Burger", "Malai Tikka Pizza", "Cheezy Sticks", "Zalmi Deal"};
    int[] itemPrices = {750, 1200, 350, 5000};
    String[] itemImages = {"burger chee.png", "malai tikka pizza chee.png", "cheezy sticks chee.png", "zalmi deal chee.png"};
    JButton[] addButtons = new JButton[4];
    JPanel contentPanel;
    JPanel headerPanel;
    JPanel foodItemPanel;
    JLabel totalLabel;
    CheeziousFrame() {
        setTitle("Cheezious Menu");
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        sidebar1 sb1=new sidebar1();
        sb1.getBackButton().addActionListener(e -> dispose());
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(900, 140));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel heading = new JLabel("Cheezious MENU");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel subHeading = new JLabel("Delicious Fast Food");
        subHeading.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeading.setForeground(Color.GRAY);
        subHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalLabel = new JLabel("Cart Total : Rs. 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 22));
        totalLabel.setForeground(new Color(40, 167, 69));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(Box.createVerticalStrut(15));
        headerPanel.add(heading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(subHeading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(totalLabel);
        foodItemPanel = new JPanel();
        foodItemPanel.setLayout(new GridLayout(2, 2, 20, 20));
        foodItemPanel.setBackground(Color.WHITE);
        foodItemPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Border cardBorder = BorderFactory.createLineBorder(new Color(220, 220, 220), 2);
        for (int i = 0; i < itemNames.length; i++) {
            JPanel card = new JPanel();
            card.setBackground(Color.WHITE);
            card.setBorder(cardBorder);
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            ImageIcon foodIcon = new ImageIcon(itemImages[i]);
            Image foodImg = foodIcon.getImage().getScaledInstance(180, 130, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(foodImg));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel nameLabel = new JLabel(itemNames[i]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel priceLabel = new JLabel("Price : Rs. " + itemPrices[i]);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            priceLabel.setForeground(new Color(40, 167, 69));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButtons[i] = new JButton("Add To Cart");
            addButtons[i].setBackground(new Color(40, 167,69 ));
            addButtons[i].setForeground(Color.WHITE);
            addButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            addButtons[i].setPreferredSize(new Dimension(150, 35));
            addButtons[i].addActionListener(this);
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(addButtons[i]);
            card.add(Box.createVerticalStrut(15));
            card.add(imageLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(nameLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(priceLabel);
            card.add(Box.createVerticalStrut(15));
            card.add(buttonPanel);
            card.add(Box.createVerticalStrut(15));
            foodItemPanel.add(card);
        }
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(foodItemPanel, BorderLayout.CENTER);
        add(sb1.sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < addButtons.length; i++) {
            if (e.getSource() == addButtons[i]) {
                CartManager.addItem("Cheezious", itemNames[i], itemPrices[i], 1);
                totalLabel.setText("Cart Total : Rs. " + CartManager.getSubtotal());
                JOptionPane.showMessageDialog(this, itemNames[i] + " added to cart!");}
        }
    }}
class tahzeebFrame extends JFrame implements ActionListener {
    String[] itemNames = {"Mousse Cake", "Sriracaha Pizza", "Brownie", "Vegetable Cheeze Sandwhich"};
    int[] itemPrices = {2500, 3000, 800, 800};
    String[] itemImages = {"mousse cake t.png", "siracaha pizza.png", "brownie.png", "vegetable cheese sandwhich.png"};
    JButton[] addButtons = new JButton[4];
    JPanel contentPanel;
    JPanel headerPanel;
    JPanel foodItemPanel;
    JLabel totalLabel;
    tahzeebFrame() {
        setTitle("Tahzeeb Menu");
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        sidebar1 sb2=new sidebar1();
        sb2.getBackButton().addActionListener(e -> dispose());
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(900, 140));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel heading = new JLabel("Tahzeeb MENU");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel subHeading = new JLabel("Delicious Bakery Item");
        subHeading.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeading.setForeground(Color.GRAY);
        subHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalLabel = new JLabel("Cart Total : Rs. 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 22));
        totalLabel.setForeground(new Color(40, 167, 69));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(Box.createVerticalStrut(15));
        headerPanel.add(heading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(subHeading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(totalLabel);
        foodItemPanel = new JPanel();
        foodItemPanel.setLayout(new GridLayout(2, 2, 20, 20));
        foodItemPanel.setBackground(Color.WHITE);
        foodItemPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Border cardBorder = BorderFactory.createLineBorder(new Color(220, 220, 220), 2);
        for (int i = 0; i < itemNames.length; i++) {
            JPanel card = new JPanel();
            card.setBackground(Color.WHITE);
            card.setBorder(cardBorder);
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            ImageIcon foodIcon = new ImageIcon(itemImages[i]);
            Image foodImg = foodIcon.getImage().getScaledInstance(180, 130, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(foodImg));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel nameLabel = new JLabel(itemNames[i]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel priceLabel = new JLabel("Price : Rs. " + itemPrices[i]);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            priceLabel.setForeground(new Color(40, 167, 69));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButtons[i] = new JButton("Add To Cart");
            addButtons[i].setBackground(new Color(40, 167,69 ));
            addButtons[i].setForeground(Color.WHITE);
            addButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            addButtons[i].setFocusPainted(false);
            addButtons[i].setPreferredSize(new Dimension(150, 35));
            addButtons[i].addActionListener(this);
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(addButtons[i]);
            card.add(Box.createVerticalStrut(15));
            card.add(imageLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(nameLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(priceLabel);
            card.add(Box.createVerticalStrut(15));
            card.add(buttonPanel);
            card.add(Box.createVerticalStrut(15));
            foodItemPanel.add(card);
        }
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(foodItemPanel, BorderLayout.CENTER);
        add(sb2.sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < addButtons.length; i++) {
            if (e.getSource() == addButtons[i]) {
                CartManager.addItem("Tahzeeb", itemNames[i], itemPrices[i],1);
                totalLabel.setText("Cart Total : Rs. " + CartManager.getSubtotal());
                JOptionPane.showMessageDialog(this, itemNames[i] + " added to cart!");}
        }}
}
class optpFrame extends JFrame implements ActionListener {
    String[] itemNames = {"Korean Loaded fries", "Loaded Bomber Fries", "Grilled Chicken Burger", "Crispy Finger Meal"};
    int[] itemPrices = {800, 700, 800, 990};
    String[] itemImages = {"loaded korean fries.png", "loaded bomber fries.png", "grilled chicken burger.png", "crispy finger meal.png"};
    JButton[] addButtons = new JButton[4];
    JPanel contentPanel;
    JPanel headerPanel;
    JPanel foodItemPanel;
    JLabel totalLabel;
    optpFrame() {
        setTitle("Optp Menu");
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        sidebar1 sb3=new sidebar1();
        sb3.getBackButton().addActionListener(e -> dispose());
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(900, 140));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel heading = new JLabel("Optp MENU");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel subHeading = new JLabel("Delicious Fast Food");
        subHeading.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeading.setForeground(Color.GRAY);
        subHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalLabel = new JLabel("Cart Total : Rs. 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 22));
        totalLabel.setForeground(new Color(40, 167, 69));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(Box.createVerticalStrut(15));
        headerPanel.add(heading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(subHeading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(totalLabel);
        foodItemPanel = new JPanel();
        foodItemPanel.setLayout(new GridLayout(2, 2, 20, 20));
        foodItemPanel.setBackground(Color.WHITE);
        foodItemPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Border cardBorder = BorderFactory.createLineBorder(new Color(220, 220, 220), 2);
        for (int i = 0; i < itemNames.length; i++) {
            JPanel card = new JPanel();
            card.setBackground(Color.WHITE);
            card.setBorder(cardBorder);
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            ImageIcon foodIcon = new ImageIcon(itemImages[i]);
            Image foodImg = foodIcon.getImage().getScaledInstance(180, 130, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(foodImg));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel nameLabel = new JLabel(itemNames[i]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel priceLabel = new JLabel("Price : Rs. " + itemPrices[i]);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            priceLabel.setForeground(new Color(40, 167, 69));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButtons[i] = new JButton("Add To Cart");
            addButtons[i].setBackground(new Color(40, 167,69 ));
            addButtons[i].setForeground(Color.WHITE);
            addButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            addButtons[i].setFocusPainted(false);
            addButtons[i].setPreferredSize(new Dimension(150, 35));
            addButtons[i].addActionListener(this);
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(addButtons[i]);
            card.add(Box.createVerticalStrut(15));
            card.add(imageLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(nameLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(priceLabel);
            card.add(Box.createVerticalStrut(15));
            card.add(buttonPanel);
            card.add(Box.createVerticalStrut(15));
            foodItemPanel.add(card);
        }
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(foodItemPanel, BorderLayout.CENTER);
        add(sb3.sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < addButtons.length; i++) {
            if (e.getSource() == addButtons[i]) {
                CartManager.addItem("Optp",itemNames[i],itemPrices[i],1);
                totalLabel.setText("Cart Total : Rs. " + CartManager.getSubtotal());
                JOptionPane.showMessageDialog(this, itemNames[i] + " added to cart!");}
        }}
}
class bundukhanFrame extends JFrame implements ActionListener {
    String[] itemNames = {"Chicken Shaslik", "Fried Fish", "BBQ Platter", "Beef Behari Kabab"};
    int[] itemPrices = {3000, 3000 , 6000, 5000};
    String[] itemImages = {"chicken shaslik.png", "fried fish.png", "bbq platter.png", "Beef kabab.png"};
    JButton[] addButtons = new JButton[4];
    JPanel contentPanel;
    JPanel headerPanel;
    JPanel foodItemPanel;
    JLabel totalLabel;
    bundukhanFrame() {
        setTitle("Bundu khan Menu");
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        sidebar1 sb4=new sidebar1();
        sb4.getBackButton().addActionListener(e -> dispose());
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(900, 140));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel heading = new JLabel("Bundu Khan MENU");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel subHeading = new JLabel("Delicious  Desi Food");
        subHeading.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeading.setForeground(Color.GRAY);
        subHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalLabel = new JLabel("Cart Total : Rs. 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 22));
        totalLabel.setForeground(new Color(40, 167, 69));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(Box.createVerticalStrut(15));
        headerPanel.add(heading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(subHeading);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(totalLabel);
        foodItemPanel = new JPanel();
        foodItemPanel.setLayout(new GridLayout(2, 2, 20, 20));
        foodItemPanel.setBackground(Color.WHITE);
        foodItemPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Border cardBorder = BorderFactory.createLineBorder(new Color(220, 220, 220), 2);
        for (int i = 0; i < itemNames.length; i++) {
            JPanel card = new JPanel();
            card.setBackground(Color.WHITE);
            card.setBorder(cardBorder);
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            ImageIcon foodIcon = new ImageIcon(itemImages[i]);
            Image foodImg = foodIcon.getImage().getScaledInstance(180, 130, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(foodImg));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel nameLabel = new JLabel(itemNames[i]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel priceLabel = new JLabel("Price : Rs. " + itemPrices[i]);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            priceLabel.setForeground(new Color(40, 167, 69));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButtons[i] = new JButton("Add To Cart");
            addButtons[i].setBackground(new Color(40, 167,69 ));
            addButtons[i].setForeground(Color.WHITE);
            addButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            addButtons[i].setFocusPainted(false);
            addButtons[i].setPreferredSize(new Dimension(150, 35));
            addButtons[i].addActionListener(this);
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(addButtons[i]);
            card.add(Box.createVerticalStrut(15));
            card.add(imageLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(nameLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(priceLabel);
            card.add(Box.createVerticalStrut(15));
            card.add(buttonPanel);
            card.add(Box.createVerticalStrut(15));
            foodItemPanel.add(card);
        }
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(foodItemPanel, BorderLayout.CENTER);
        add(sb4.sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < addButtons.length; i++) {
            if (e.getSource() == addButtons[i]) {
          CartManager.addItem("Bundu Khan",itemNames[i],itemPrices[i],1);
                totalLabel.setText("Cart Total : Rs. " + CartManager.getSubtotal());
                JOptionPane.showMessageDialog(this, itemNames[i] + " added to cart!");}
        }}
}
public class MainDashBoard{
    public static  void main(String[] args){
        new DashBoard();}}
