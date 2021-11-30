package Catering;

import UI.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author darsh
 */
public final class Menue extends javax.swing.JFrame {

    
    database a = new database();

    WelcomeDrink w = new WelcomeDrink();
    Dessert d = new Dessert();
    MainMeal M = new MainMeal();
     
 
    DefaultTableModel Welcomedrinkmodel;
    DefaultTableModel MainMealmodel;
    DefaultTableModel Dessertmodel;
    
    public Menue() {
        this.a = new database();
        initComponents();
        
        Welcomedrinkmodel =  (DefaultTableModel) TblDrink.getModel();
        MainMealmodel =     (DefaultTableModel) TblMeal.getModel();
        Dessertmodel =  (DefaultTableModel) TblDessert.getModel();
        
        populateDrinkTable();
        populateMealTable();
        populateDessertTable();
        
        BtnDrinkAdd.setEnabled(false);
        BtnMealAdd.setEnabled(false);
        BtnDessertAdd.setEnabled(false);
        BtnDrinkDelete.setEnabled(false);
        BtnMealDelete.setEnabled(false);
        BtnDessertDelete.setEnabled(false);
        
        
        
        TxtDrink.getDocument().addDocumentListener(new DocumentListener() 
        {
        @Override
          
        public void changedUpdate(DocumentEvent e){
          WelcomeDrinklengthCheck();
         }
            @Override
        public void insertUpdate(DocumentEvent e) {
          WelcomeDrinklengthCheck();
         }
        @Override
        public void removeUpdate(DocumentEvent e) {
           WelcomeDrinklengthCheck();
         }
        });
        TxtDrinkPrice.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
          
        public void changedUpdate(DocumentEvent e){
          WelcomeDrinklengthCheck();
         }
            @Override
        public void insertUpdate(DocumentEvent e) {
          WelcomeDrinklengthCheck();
         }
        @Override
        public void removeUpdate(DocumentEvent e) {
           WelcomeDrinklengthCheck();
         }
        });
        TxtMainMeal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          MainMeallengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          MainMeallengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           MainMeallengthCheck();
        }
        });
        TxtMealPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          MainMeallengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          MainMeallengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           MainMeallengthCheck();
        }
        });
        TxtDessert.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override 
        public void changedUpdate(DocumentEvent e){
          DessertlengthCheck();
        }
            @Override
        public void insertUpdate(DocumentEvent e) {
          DessertlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DessertlengthCheck();
         }
        });
          
        TxtDessertPrice.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
          
        public void changedUpdate(DocumentEvent e){
          DessertlengthCheck();
        }
            @Override
        public void insertUpdate(DocumentEvent e) {
          DessertlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DessertlengthCheck();
        }
        });
        
    }
    
    public void populateDrinkTable()
    {
       
        String WelcomeDrink;
        String DrinkPrice;
        int r =0;
 
        try
        {
            a.createConnection();
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + database.WelcomeDrinkTable);
            

            while(results.next())
            {              
            WelcomeDrink = results.getString(1);
            DrinkPrice = results.getString(2);

            Welcomedrinkmodel.insertRow(Welcomedrinkmodel.getRowCount(), new Object[]{WelcomeDrink, DrinkPrice});
            r++;
            }
            
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        } 
              
    }
    
    private void insertWelcomeDrink(WelcomeDrink w)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.WelcomeDrinkTable + " values ('" +
                    w.getWelcomeDrink() + "','" + w.getDrinkPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    
    public void WelcomeDrinklengthCheck(){
        if(TxtDrink.getText().equals("") || TxtDrinkPrice.getText().equals("")){
            BtnDrinkAdd.setEnabled(false);
            BtnDrinkDelete.setEnabled(false);
        }
        else if(TxtDrink.getText().length()> 100 || TxtDrink.getText().length()>100){
            BtnDrinkAdd.setEnabled(false);
        }
        else{
            BtnDrinkAdd.setEnabled(true);
        }
      }
    
    @SuppressWarnings("unchecked")
    
    public void populateMealTable()
    {
       
        String MainMeal;
        String MealPrice;
        int r =0;
 
        try
        {
            a.createConnection();
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.MainMealTable);
            ResultSetMetaData rsmd = results.getMetaData();
            
            while(results.next())
            {              
            MainMeal = results.getString(1);
            MealPrice = results.getString(2);
           
            MainMealmodel.insertRow(MainMealmodel.getRowCount(), new Object[]{MainMeal, MealPrice});
            r++;
            }
            
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        } 
              
    }
    
    private void insertMainMeal(MainMeal M)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.MainMealTable + " values ('" +
                            M.getMainMeal() + "','" + M.getMealPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    
    public void MainMeallengthCheck(){
        if(TxtMainMeal.getText().equals("") || TxtMealPrice.getText().equals("")){
            BtnMealAdd.setEnabled(false);
            BtnMealDelete.setEnabled(false);
        }
        else if(TxtMainMeal.getText().length()> 100 || TxtMainMeal.getText().length()>100){
            BtnMealAdd.setEnabled(false);
        }
        else{
            BtnMealAdd.setEnabled(true);
        }
      }
    
    @SuppressWarnings("unchecked")

    public void populateDessertTable()
    {
       
        String Dessert;
        String DessertPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DessertTable);
            ResultSetMetaData rsmd = results.getMetaData();

            while(results.next())
            {              
            Dessert = results.getString(1);
            DessertPrice = results.getString(2);
          
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{Dessert, DessertPrice});
            r++;
            }
            
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
              
    }
    
    private void insertDessert(Dessert ds)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.DessertTable + " values ('" +
                    ds.getDessert() + "','" + ds.getDessertPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    
    public void DessertlengthCheck(){
          if(TxtDessert.getText().equals("") || TxtDessertPrice.getText().equals("")){
              BtnDessertAdd.setEnabled(false);
              BtnDessertDelete.setEnabled(false);
          }
          else if(TxtDessert.getText().length()> 100 || TxtDessert.getText().length()>100){
               BtnDessertAdd.setEnabled(false);
          }
          else{
               BtnDessertAdd.setEnabled(true);
          }
      }
    
    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDrink = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtDrinkPrice = new javax.swing.JTextField();
        TxtDrink = new javax.swing.JTextField();
        BtnDrinkAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDessert = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtDessert = new javax.swing.JTextField();
        TxtMealPrice = new javax.swing.JTextField();
        BtnMealAdd = new javax.swing.JButton();
        BtnMealDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtMainMeal = new javax.swing.JTextField();
        TxtDessertPrice = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblMeal = new javax.swing.JTable();
        BtnDessertAdd = new javax.swing.JButton();
        BtnDessertDelete = new javax.swing.JButton();
        BtnDrinkDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        TblDrink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WelcomeDrink", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblDrink.setColumnSelectionAllowed(true);
        TblDrink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDrinkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDrink);
        TblDrink.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("WelcomeDrink");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Drink Price");

        TxtDrinkPrice.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        TxtDrinkPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDrinkPriceActionPerformed(evt);
            }
        });

        TxtDrink.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        TxtDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDrinkActionPerformed(evt);
            }
        });

        BtnDrinkAdd.setText("Add");
        BtnDrinkAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDrinkAddActionPerformed(evt);
            }
        });

        TblDessert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MainMeal", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblDessert.setColumnSelectionAllowed(true);
        TblDessert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDessertMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblDessert);
        TblDessert.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Main Meal");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Meal Price");

        TxtDessert.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        TxtDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDessertActionPerformed(evt);
            }
        });

        TxtMealPrice.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        TxtMealPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMealPriceActionPerformed(evt);
            }
        });

        BtnMealAdd.setText("Add");
        BtnMealAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMealAddActionPerformed(evt);
            }
        });

        BtnMealDelete.setText("Delete");
        BtnMealDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMealDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Dessert");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Dessert Price");

        TxtMainMeal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        TxtMainMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMainMealActionPerformed(evt);
            }
        });

        TxtDessertPrice.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        TxtDessertPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDessertPriceActionPerformed(evt);
            }
        });

        TblMeal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MainMeal", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblMeal.setColumnSelectionAllowed(true);
        TblMeal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblMealMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblMeal);
        TblMeal.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        BtnDessertAdd.setText("Add");
        BtnDessertAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDessertAddActionPerformed(evt);
            }
        });

        BtnDessertDelete.setText("Delete");
        BtnDessertDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDessertDeleteActionPerformed(evt);
            }
        });

        BtnDrinkDelete.setText("Delete");
        BtnDrinkDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDrinkDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("To Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setForeground(new java.awt.Color(0, 0, 102));
        jButton5.setText("Back to Main Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(BtnDessertAdd)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtDessert, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDessertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(BtnDessertDelete)))
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(BtnDrinkAdd)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtDrinkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(BtnDrinkDelete)))
                            .addGap(124, 124, 124)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(BtnMealAdd)))
                            .addGap(39, 39, 39)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtMealPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtMainMeal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(BtnMealDelete)))
                            .addGap(124, 124, 124)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(TxtDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtDrinkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnDrinkAdd)
                                    .addComponent(BtnDrinkDelete)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtMainMeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtMealPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnMealAdd)
                            .addComponent(BtnMealDelete)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(TxtDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TxtDessertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnDessertAdd)
                            .addComponent(BtnDessertDelete))))
                .addContainerGap(334, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtDrinkPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDrinkPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDrinkPriceActionPerformed

    private void TxtDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDrinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDrinkActionPerformed

    private void TxtDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDessertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDessertActionPerformed

    private void TxtMealPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMealPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMealPriceActionPerformed

    private void TxtMainMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMainMealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMainMealActionPerformed

    private void TxtDessertPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDessertPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDessertPriceActionPerformed

    private void BtnDrinkAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDrinkAddActionPerformed
      
        try{
            
        Double.parseDouble(TxtDrinkPrice.getText());
        Welcomedrinkmodel.insertRow(Welcomedrinkmodel.getRowCount(), new Object[]{TxtDrink.getText(), TxtDrinkPrice.getText()});
        w.setWelcomeDrink(TxtDrink.getText());
        w.setDrinkPrice(TxtDrinkPrice.getText());
        TxtDrink.setText(null);
        TxtDrinkPrice.setText(null);
        insertWelcomeDrink(w);
    }//GEN-LAST:event_BtnDrinkAddActionPerformed
     catch(Exception c){
            
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            TxtDrink.setText(null);
            TxtDrinkPrice.setText(null);
            BtnDrinkAdd.setEnabled(false);
    }
    }
    private void BtnDrinkDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDrinkDeleteActionPerformed
        // TODO add your handling code here:
        int row =TblDrink.getSelectedRow();
        String selected =TblDrink.getValueAt(row, 0).toString();
        
        if (row >= 0) {
               
                Welcomedrinkmodel.removeRow(row);
        try{
            a.createConnection();
            
            PreparedStatement ps = a.conn.prepareStatement("delete from welcomedrink where welcomedrink='"+selected+"' ");
            ps.executeUpdate();
                    
            TxtDrink.setText(null);
            TxtDrinkPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
    }//GEN-LAST:event_BtnDrinkDeleteActionPerformed

    private void BtnMealAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMealAddActionPerformed
        // TODO add your handling code here:
        try{
        Double.parseDouble(TxtMealPrice.getText());
        MainMealmodel.insertRow(MainMealmodel.getRowCount(), new Object[]{TxtMainMeal.getText(), TxtMealPrice.getText()});
        M.setMainMeal(TxtMainMeal.getText());
        M.setMealPrice(TxtMealPrice.getText());
        
        TxtMainMeal.setText(null);
        TxtMealPrice.setText(null);
        
        insertMainMeal(M);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            TxtMainMeal.setText(null);
            TxtMealPrice.setText(null);
            BtnMealAdd.setEnabled(false);
        }
    }//GEN-LAST:event_BtnMealAddActionPerformed

    private void BtnMealDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMealDeleteActionPerformed
        // TODO add your handling code here:
        int row = TblMeal.getSelectedRow();
        String selected = TblMeal.getValueAt(row, 0).toString();
        if (row >= 0) {

                MainMealmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from mainmeal where mainmeal='"+selected+"' ");
            ps.executeUpdate();
                    
            TxtMainMeal.setText(null);
            TxtMealPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
    }//GEN-LAST:event_BtnMealDeleteActionPerformed

    private void BtnDessertAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDessertAddActionPerformed
        // TODO add your handling code here:
        try{
            Double.parseDouble(TxtDessertPrice.getText());
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{TxtDessert.getText(), TxtDessertPrice.getText()});
            d.setDessert(TxtDessert.getText());
            d.setDessertPrice(TxtDessertPrice.getText());
            TxtDessert.setText(null);
            TxtDessertPrice.setText(null);
            insertDessert(d);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            TxtDessert.setText(null);
            TxtDessertPrice.setText(null);
            BtnDessertAdd.setEnabled(false);
        }
    }//GEN-LAST:event_BtnDessertAddActionPerformed

    private void BtnDessertDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDessertDeleteActionPerformed
        // TODO add your handling code here:
        int row = TblDessert.getSelectedRow();
        
        String selected = TblDessert.getValueAt(row, 0).toString();
        if (row >= 0) {

            Dessertmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from dessert where Dessert='"+selected+"' ");
            ps.executeUpdate();
                    
            TxtDessert.setText(null);
            TxtDessertPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }   
        }
    }//GEN-LAST:event_BtnDessertDeleteActionPerformed

    private void TblDrinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDrinkMouseClicked
       
         int row = TblDrink.getSelectedRow();
         String selected = TblDrink.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)TblDrink.getModel();
        try{
            if(selected !=null ){
           
            TxtDrink.setText(String.valueOf(model.getValueAt(TblDrink.getSelectedRow(), 0)));
            TxtDrinkPrice.setText(String.valueOf(model.getValueAt(TblDrink.getSelectedRow(), 1)));
            
            BtnDrinkDelete.setEnabled(true);
            BtnDrinkAdd.setEnabled(false);
        }
    }//GEN-LAST:event_TblDrinkMouseClicked
       catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    } 
    private void TblMealMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblMealMouseClicked
       int row = TblMeal.getSelectedRow();
        
        String selected = TblMeal.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)TblMeal.getModel();
        try{
        if(selected !=null ){
            TxtMainMeal.setText(String.valueOf(model.getValueAt(TblMeal.getSelectedRow(), 0)));
            TxtMealPrice.setText(String.valueOf(model.getValueAt(TblMeal.getSelectedRow(), 1)));
            
            BtnMealDelete.setEnabled(true);
            BtnMealAdd.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_TblMealMouseClicked

    private void TblDessertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDessertMouseClicked
        int row = TblDessert.getSelectedRow();
        
        String selected = TblDessert.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)TblDessert.getModel();
        try{
        if(selected !=null ){
            TxtDessert.setText(String.valueOf(model.getValueAt(TblDessert.getSelectedRow(), 0)));
            TxtDessertPrice.setText(String.valueOf(model.getValueAt(TblDessert.getSelectedRow(), 1)));
            
            BtnDessertDelete.setEnabled(true);
            BtnDessertAdd.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_TblDessertMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        CateringOrder Cd = new CateringOrder();
            Cd.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new home().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDessertAdd;
    private javax.swing.JButton BtnDessertDelete;
    private javax.swing.JButton BtnDrinkAdd;
    private javax.swing.JButton BtnDrinkDelete;
    private javax.swing.JButton BtnMealAdd;
    private javax.swing.JButton BtnMealDelete;
    private javax.swing.JTable TblDessert;
    private javax.swing.JTable TblDrink;
    private javax.swing.JTable TblMeal;
    private javax.swing.JTextField TxtDessert;
    private javax.swing.JTextField TxtDessertPrice;
    private javax.swing.JTextField TxtDrink;
    private javax.swing.JTextField TxtDrinkPrice;
    private javax.swing.JTextField TxtMainMeal;
    private javax.swing.JTextField TxtMealPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
