/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catering;

import static Catering.database.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author darsh
 */
public class CateringOrder extends javax.swing.JFrame {

    public double RunningCost;
    public double RowCost;
    public double dprice1;
    
    
    WelcomeDrink w = new WelcomeDrink();
    Dessert d = new Dessert();
    MainMeal M = new MainMeal();
    TotalPrice p = new TotalPrice();
    PersonOrder o = new PersonOrder();
    
    database a = new database();
    
    Random rand = new Random();
    int x = rand.nextInt(10000);
    public String xx = Integer.toString(x);
    
    DefaultTableModel model;
    DefaultTableModel Welcomedrinkmodel;
    DefaultTableModel MainMealmodel;
    DefaultTableModel Dessertmodel;
    DefaultTableModel Ordermodel;
    
    public CateringOrder() {
        initComponents();
        
        
        TxtRowCost.setVisible(false);
        
        Welcomedrinkmodel =  (DefaultTableModel) TblDrink.getModel();
        MainMealmodel =     (DefaultTableModel) TblMeal.getModel();
        Dessertmodel =  (DefaultTableModel) TblDessert.getModel();
        Ordermodel = (DefaultTableModel) TblOrder.getModel();
        BtnFinishOrder.setEnabled(false);
        
        
        model = (DefaultTableModel) TblOrder.getModel();
        
        populateDrinkTable();
        populateMealTable();
        populateDessertTable();
        
        TxtTable.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lengthCheck();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lengthCheck();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lengthCheck();
            }
        });
        TxtCost.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lengthCheck();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lengthCheck();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lengthCheck();
            }
        });
    }
    
    public void lengthCheck(){
        if(TxtCost.getText().equals("")||TxtTable.getText().equals("")||TxtCost.getText().equals("0.0")){
            BtnFinishOrder.setEnabled(false);
        }
        else{
            BtnBack.setEnabled(false);
            BtnFinishOrder.setEnabled(true);
        }
    }
    
    private void InsertOrder(PersonOrder O)
    {
        
        
        a.createConnection();
        try {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into ORDER_TABLE values ('" +
                    o.getOrderID() +  "','" + o.getEmployee() + "','" + o.getDrink() + "','" + o.getMain() + "','" + o.getDessert() + "','" + o.getPrice() + "')");
            a.stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
       
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblOrder = new javax.swing.JTable();
        TxtDrinkValue = new javax.swing.JTextField();
        TxtDessertValue = new javax.swing.JTextField();
        TxtMainValue = new javax.swing.JTextField();
        TxtDrinkPrice = new javax.swing.JTextField();
        TxtMainPrice = new javax.swing.JTextField();
        TxtDessertPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtTable = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();
        TxtCost = new javax.swing.JTextField();
        TxtRowCost = new javax.swing.JTextField();
        BtnBack = new javax.swing.JButton();
        BtnFinishOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDrink = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblMeal = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblDessert = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TxtEmpName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        TblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Employee Name", "Welcome Drink", "Main Meal", "Dessert", "Price"
            }
        ));
        TblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblOrderMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TblOrder);

        TxtDrinkValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDrinkValueActionPerformed(evt);
            }
        });

        TxtDessertValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDessertValueActionPerformed(evt);
            }
        });

        TxtMainValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMainValueActionPerformed(evt);
            }
        });

        TxtDrinkPrice.setText("0.0");

        TxtMainPrice.setText("0.0");

        TxtDessertPrice.setText("0.0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Employee Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total Number");

        BtnAdd.setText("Add Order");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        TxtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCostActionPerformed(evt);
            }
        });

        TxtRowCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRowCostActionPerformed(evt);
            }
        });

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        BtnFinishOrder.setText("Finish Order");
        BtnFinishOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinishOrderActionPerformed(evt);
            }
        });

        TblDrink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WelcomeDrink", "Price"
            }
        ));
        TblDrink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDrinkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDrink);

        TblMeal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MainMeal", "Price"
            }
        ));
        TblMeal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblMealMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblMeal);

        TblDessert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dessert", "Price"
            }
        ));
        TblDessert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDessertMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblDessert);

        jButton1.setText("Check Plate Price");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setText("Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(BtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtMainValue, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDessertValue, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDrinkValue, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDrinkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDessertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtMainPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BtnAdd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(134, 134, 134)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtRowCost, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTable, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(192, 192, 192)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnFinishOrder)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtDrinkValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDrinkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtMainValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMainPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtDessertValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDessertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(TxtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnBack)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(BtnFinishOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtRowCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TxtTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)))
                        .addGap(46, 46, 46)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TblDessertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDessertMouseClicked
        // TODO add your handling code here:
        int row = TblDessert.getSelectedRow();

        String selected = TblDessert.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)TblDessert.getModel();
        try {
            if(selected !=null ){
                TxtDessertValue.setText(String.valueOf(model.getValueAt(TblDessert.getSelectedRow(), 0)));
                TxtDessertPrice.setText(String.valueOf(model.getValueAt(TblDessert.getSelectedRow(), 1)));
            }
        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_TblDessertMouseClicked

    private void TblMealMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblMealMouseClicked
        // TODO add your handling code here:
        int row = TblMeal.getSelectedRow();

        String selected = TblMeal.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)TblMeal.getModel();

        try {
            if(selected !=null ){
                TxtMainValue.setText(String.valueOf(model.getValueAt(TblMeal.getSelectedRow(), 0)));
                TxtMainPrice.setText(String.valueOf(model.getValueAt(TblMeal.getSelectedRow(), 1)));
            }
        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_TblMealMouseClicked

    private void TblDrinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDrinkMouseClicked
        // TODO add your handling code here:
        int row = TblDrink.getSelectedRow();

        String selected = TblDrink.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)TblDrink.getModel();
        try {
            if(selected !=null){
                TxtDrinkValue.setText(String.valueOf(model.getValueAt(TblDrink.getSelectedRow(), 0)));
                TxtDrinkPrice.setText(String.valueOf(model.getValueAt(TblDrink.getSelectedRow(), 1)));
            }
        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_TblDrinkMouseClicked

    private void BtnFinishOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinishOrderActionPerformed
        // TODO add your handling code here:
        
        InsertOrder(o);
        
            Menue Mn = new Menue();
            Mn.setVisible(true);
            this.setVisible(false);
        
    }//GEN-LAST:event_BtnFinishOrderActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // TODO add your handling code here:
        Menue Me = new Menue();
        Me.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_BtnBackActionPerformed

    private void TxtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCostActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        // TODO add your handling code here:
        
        
        String Total = TxtTable.getText();
        dprice1 = Double.parseDouble(Total);
        double RR;
        RR= RunningCost*dprice1;
        
        String TotalP = Double.toString(RR);

        BtnBack.setEnabled(false);
        
        String EmpName = TxtEmpName.getText();
        o.setEmployee(EmpName);
        


        o.setOrderID(xx);
        o.setDrink(TxtDrinkValue.getText());
        o.setMain(TxtMainValue.getText());
        o.setDessert(TxtDessertValue.getText());

        o.setPrice(TotalP);
       

        model.insertRow(model.getRowCount(), new Object[]{xx,TxtEmpName.getText(), TxtDrinkValue.getText(), TxtMainValue.getText(),TxtDessertValue.getText(),RR});
        TxtDrinkValue.setText("-");
        TxtMainValue.setText("-");
        TxtDessertValue.setText("-");
        TxtRowCost.setText("-");
        TxtDrinkPrice.setText("-");
        TxtMainPrice.setText("-");
        TxtDessertPrice.setText("-");
        RowCost = 0;
        TxtCost.setText("-");
    }//GEN-LAST:event_BtnAddActionPerformed

    private void TxtMainValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMainValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMainValueActionPerformed

    private void TxtDessertValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDessertValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDessertValueActionPerformed

    private void TxtDrinkValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDrinkValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDrinkValueActionPerformed

    private void TblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblOrderMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TblOrderMouseClicked

    private void TxtRowCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRowCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRowCostActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
      
      String Drink = TxtDrinkPrice.getText();
        RunningCost += Double.parseDouble(Drink);
        RowCost += Double.parseDouble(Drink);
        TxtCost.setText(String.valueOf(RunningCost));
        TxtRowCost.setText(String.valueOf(RowCost));

        String Main = TxtMainPrice.getText();
        RunningCost += Double.parseDouble(Main);
        RowCost += Double.parseDouble(Main);
        TxtCost.setText(String.valueOf(RunningCost));
        TxtRowCost.setText(String.valueOf(RowCost));

        String Dessert = TxtDessertPrice.getText();
        RunningCost += Double.parseDouble(Dessert);
        RowCost += Double.parseDouble(Dessert);
        TxtCost.setText(String.valueOf(RunningCost));
        TxtRowCost.setText(String.valueOf(RowCost));
        
        

        BtnBack.setEnabled(false);
        String rowCost1 = Double.toString(RowCost);
        
        o.setPrice(rowCost1);
       
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
        JasperDesign jdesign;
        try {
            jdesign = JRXmlLoader.load("D:\\SLIIT\\YEAR 02\\SEMESTER 02\\PPA\\PROJECT\\KJEnterprises\\src\\main\\java\\Catering\\Cateringreport2.jrxml");
            String query="select * from order_table";
        
        JRDesignQuery updateQuery=new JRDesignQuery();
        updateQuery.setText(query);
        
        jdesign.setQuery(updateQuery);
        
        JasperReport jreport=JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint=JasperFillManager.fillReport(jreport,null,conn);
        
        JasperViewer.viewReport(jprint);

    }//GEN-LAST:event_jButton2ActionPerformed
    
        
         catch (JRException ex) {
            Logger.getLogger(CateringOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(CateringOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CateringOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CateringOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CateringOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CateringOrder().setVisible(true);
            }
        });
    }
    private void populateDrinkTable() {
        String Starter;
        String StarterPrice;
       
        int r =0;
        try {
             a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.WelcomeDrinkTable);
            ResultSetMetaData rsmd = results.getMetaData();
            
            while(results.next()){
            Starter = results.getString(1);
            StarterPrice = results.getString(2);
          
            Welcomedrinkmodel.insertRow(Welcomedrinkmodel.getRowCount(), new Object[]{Starter, StarterPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
            
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateMealTable() {
        String Main;
        String MainPrice;
       
        int r =0;
        
        try {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.MainMealTable);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                //System.out.print(rsmd.getColumnLabel(i)+"\t");  
            }
            //System.out.println();
            
            while(results.next()){
            Main = results.getString(1);
            MainPrice = results.getString(2);
          
            MainMealmodel.insertRow(MainMealmodel.getRowCount(), new Object[]{Main, MainPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
            
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }catch(IllegalArgumentException a) {
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateDessertTable() {
        String Dessert;
        String DessertPrice;
       
        int r =0;
        
        try {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DessertTable);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                
            }
           
           while(results.next()){
            Dessert = results.getString(1);
            DessertPrice = results.getString(2);
          
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{Dessert, DessertPrice});
            r++;
           }
            results.close();
            a.stmt.close();
            a.shutdown();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }catch (IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public String extractDigits(String src)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < src.length(); i++){
            char c = src.charAt(i);
        if (Character.isDigit(c)) {
            builder.append(c);
        }
        }
        return builder.toString();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnFinishOrder;
    private javax.swing.JTable TblDessert;
    private javax.swing.JTable TblDrink;
    private javax.swing.JTable TblMeal;
    private javax.swing.JTable TblOrder;
    private javax.swing.JTextField TxtCost;
    private javax.swing.JTextField TxtDessertPrice;
    private javax.swing.JTextField TxtDessertValue;
    private javax.swing.JTextField TxtDrinkPrice;
    private javax.swing.JTextField TxtDrinkValue;
    private javax.swing.JTextField TxtEmpName;
    private javax.swing.JTextField TxtMainPrice;
    private javax.swing.JTextField TxtMainValue;
    private javax.swing.JTextField TxtRowCost;
    private javax.swing.JTextField TxtTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    
}
