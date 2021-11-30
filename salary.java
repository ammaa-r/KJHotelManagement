/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author Pasan
 */
public class salary extends javax.swing.JFrame {

    /**
     * Creates new form salary
     */
    public salary() {
        initComponents();
        Connect();
    }
    Connection con;
    PreparedStatement pst;
     public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kjenterprise?", "root","");
            
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtemp_name = new javax.swing.JTextField();
        txtempid = new javax.swing.JTextField();
        txt_b_salary = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_task = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_ot_salary = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jButton_back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabele_payment = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addbtn = new javax.swing.JButton();
        updateBTN = new javax.swing.JButton();
        jComboBox1_salary = new javax.swing.JComboBox<>();
        clear = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        days = new javax.swing.JTextField();
        jLabel_days = new javax.swing.JLabel();
        jLabel_OT = new javax.swing.JLabel();
        othours = new javax.swing.JTextField();
        jButton_cal = new javax.swing.JButton();
        jButton_search_name = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Employee Salary System");

        jLabel2.setText("Employee ID");

        jLabel3.setText("Employee Name");

        jLabel4.setText("Employee Task");

        jComboBox_task.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kitchen Operator", "Cashier", "Hotel Manager", "Waiter", " " }));

        jLabel5.setText("Over Time Salary");

        txt_ot_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ot_salaryActionPerformed(evt);
            }
        });

        jLabel6.setText("Total Salary");

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jLabel7.setText("Basic Salary");

        jLabele_payment.setText("Salary Payment Type");

        jCheckBox1.setText("Payment Collected By Employee");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Employee Task", "Basic Salary", "Over Time Salary", "Total Salary", "Salary Payement Typel"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        updateBTN.setText("Update");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        jComboBox1_salary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash Payment", "Bank Payment", " " }));

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysActionPerformed(evt);
            }
        });

        jLabel_days.setText("Number Of Days");

        jLabel_OT.setText("Over Time Hours");

        jButton_cal.setText("Calculate");
        jButton_cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calActionPerformed(evt);
            }
        });

        jButton_search_name.setText("Search_Name");
        jButton_search_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_search_nameActionPerformed(evt);
            }
        });

        jButton1.setText("Print Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(363, 363, 363))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(addbtn)
                        .addGap(124, 124, 124)
                        .addComponent(updateBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(clear)
                        .addGap(101, 101, 101))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_days)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_b_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel_OT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ot_salary, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(othours))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jButton_cal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addComponent(searchbtn)
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54)
                        .addComponent(txtemp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(jLabele_payment))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_task, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtempid, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(jButton_search_name)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtemp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabele_payment)
                    .addComponent(jComboBox1_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtempid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_search_name)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox_task, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_b_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_ot_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_days)
                    .addComponent(jLabel_OT)
                    .addComponent(othours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addbtn)
                            .addComponent(updateBTN)
                            .addComponent(clear)
                            .addComponent(searchbtn))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton_back)
                        .addGap(375, 375, 375))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ot_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ot_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ot_salaryActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        // TODO Back here:
        emp v=new emp();
            v.setVisible(true);
            this.setVisible(false);
            
    }//GEN-LAST:event_jButton_backActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO Update here:
        try {
           // TODO add your handling code here:
           String EmpID=txtemp_name.getText();
           String sqlupdate="UPDATE `salary` SET `Employe_ID`='"+txtemp_name.getText()+"',`Employee_Name`='" + txtempid.getText() + "',`Basic_Salary`='" + txt_b_salary.getText() + "',`Total_Salary`='" + txt_total.getText() + "',`Salary_Payement_Type`='" + jComboBox1_salary.getSelectedItem() + "',`Employee_Task`='" + jComboBox_task.getSelectedItem() + "',`Over_Time_Salary`='"+txt_ot_salary.getText()+"' WHERE `Employe_ID`='" + EmpID + "'";
           PreparedStatement pstmt = con.prepareStatement(sqlupdate);
           pstmt.executeUpdate();
           
           String sql1 = "Select * from salary";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs = pst1.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       } catch (SQLException ex) {
           Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_updateBTNActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO addnew values here:
        String Salary_Payment_Type=(String) jComboBox1_salary.getSelectedItem();
        if("Cash Payment".equals(Salary_Payment_Type)){
        if (jCheckBox1.isSelected()==true ){
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Please tick the 'Payment Collected by Employee' checkbox");
        }
        }
        
        if(!"".equals(txtemp_name.getText())){
            if(txtemp_name.getText().length()>=3){
                
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect ID,should be 3 digits");
            }
        }
        if(!"".equals(txtemp_name.getText()) && !"".equals(txtempid.getText())&& !"".equals(txt_b_salary.getText())&& !"".equals(days.getText())&&txtemp_name.getText().length()>=3)
        {
            try {
            String Employee_ID=txtemp_name.getText();
            String Employee_Name=txtempid.getText();
            String Employee_Task=(String) jComboBox_task.getSelectedItem();
            String Basic_Salary=txt_b_salary.getText();
            String Over_Time_Salary=txt_ot_salary.getText();
            String Total_Salary=txt_total.getText();
            Salary_Payment_Type=(String) jComboBox1_salary.getSelectedItem();
            String Employe_Task=(String) jComboBox_task.getSelectedItem();
            
             
            pst=con.prepareStatement("insert into salary(Employe_ID,Employee_Name,Basic_Salary,Total_Salary,Salary_Payement_Type,Employee_Task,Over_Time_Salary)values(?,?,?,?,?,?,?)");
            pst.setString(1,Employee_ID);
            pst.setString(2, Employee_Name);
            pst.setString(3, Basic_Salary);
            pst.setString(4,Total_Salary);
            pst.setString(5,Salary_Payment_Type);
            pst.setString(6,Employee_Task);
            pst.setString(7,Over_Time_Salary);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "EMP added");
            
            
           txtemp_name.setText("");
           txtempid.setText("");
           jComboBox_task.setSelectedItem("");
           jComboBox1_salary.setSelectedItem("");
           txt_b_salary.setText("");
           txt_ot_salary.setText("");
           txt_total.setText("");

            String sql1 = "Select * from salary";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs = pst1.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            {

            }

        }  catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            JOptionPane.showMessageDialog(this, "Some values are left blank,please enter all");
        }

    }                                              

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        

    }//GEN-LAST:event_addbtnActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO clear code here:
                   txtemp_name.setText("");
           txtempid.setText("");
           jComboBox_task.setSelectedItem("");
           jComboBox1_salary.setSelectedItem("");
           txt_b_salary.setText("");
           txt_ot_salary.setText("");
           txt_total.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
                  String EmpID=txtemp_name.getText();
           String sql2 = "Select `Employee_Name` from `salary` where `Employe_ID`='" + EmpID + "'";
           String result2="";
           PreparedStatement pst2;
           String sql11="";
        try {                                          
           // TODO Search code here:

           if(EmpID.equals("")){
               sql11 = "select * from salary";
           }
           else{
               sql11= "Select * from salary where `Employe_ID`='" + EmpID + "' ";
           }
           
           PreparedStatement pst11 = con.prepareStatement(sql11);
           ResultSet rs11 = pst11.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs11));
           
           try {
               pst2 = con.prepareStatement(sql2);
               
               ResultSet rs2 = pst2.executeQuery();
               
               if (rs2.next()) {
                   result2 = rs2.getString(1);
                   txtempid.setText(result2);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           String sql3 = "Select `Basic_Salary` from `salary` where `Employe_ID`='" + EmpID + "'";
           String result3="";
           PreparedStatement pst3;
           try {
               pst3= con.prepareStatement(sql3);
               
               ResultSet rs3 = pst3.executeQuery();
               
               if (rs3.next()) {
                   result3 = rs3.getString(1);
                   txt_b_salary.setText(result3);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
           String sql4 = "Select `Total_Salary` from `salary` where `Employe_ID`='" + EmpID + "'";
           String result4="";
           PreparedStatement pst4;
           try {
               pst4= con.prepareStatement(sql4);
               
               ResultSet rs4 = pst4.executeQuery();
               
               if (rs4.next()) {
                   result4 = rs4.getString(1);
                   txt_total.setText(result4);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           String sql5 = "Select `Salary_Payement_Type` from `salary` where `Employe_ID`='" + EmpID + "'";
           String result5="";
           PreparedStatement pst5;
           try {
               pst5= con.prepareStatement(sql5);
               
               ResultSet rs5 = pst5.executeQuery();
               
               if (rs5.next()) {
                   result5 = rs5.getString(1);
                   jComboBox1_salary.setSelectedItem(result5);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
           
           
           
           
           
           String sql7 = "Select `Employee_Task` from `salary` where `Employe_ID`='" + EmpID + "'";
           String result7="";
           PreparedStatement pst7;
           try {
               pst7= con.prepareStatement(sql7);
               
               ResultSet rs7 = pst7.executeQuery();
               
               if (rs7.next()) {
                   result7 = rs7.getString(1);
                   jComboBox_task.setSelectedItem(result7);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
           String sql8 = "Select `Over_Time_Salary` from `salary` where `Employe_ID`='" + EmpID + "'";
           String result8="";
           PreparedStatement pst8;
           try {
               pst8= con.prepareStatement(sql8);
               
               ResultSet rs8 = pst8.executeQuery();
               
               if (rs8.next()) {
                   result8 = rs8.getString(1);
                   txt_ot_salary.setText(result8);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
       } catch (SQLException ex) {
           Logger.getLogger(salary.class.getName()).log(Level.SEVERE, null, ex);
       }


    }//GEN-LAST:event_searchbtnActionPerformed

    private void daysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daysActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void jButton_calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calActionPerformed
        // TODO Cal Salary code here:
        Integer otsalary=(int) ((Integer.parseInt(txt_b_salary.getText())/240)*1.5*Integer.parseInt(othours.getText()));

        txt_ot_salary.setText(otsalary.toString());
        Integer total=otsalary+(Integer.parseInt(days.getText())*(Integer.parseInt(txt_b_salary.getText())/30));
        txt_total.setText(total.toString());
    }//GEN-LAST:event_jButton_calActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton_search_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_search_nameActionPerformed
        // TODO Search Emp Name here:
        String EmpID=txtemp_name.getText();
           String sql2 = "Select `Emp_Name` from `employee` where `Emp_ID`='" + EmpID + "'";
           String result2="";
           PreparedStatement pst2;
                   
           try {
               pst2 = con.prepareStatement(sql2);
               
               ResultSet rs2 = pst2.executeQuery();
               
               if (rs2.next()) {
                   result2 = rs2.getString(1);
                   txtempid.setText(result2);
               }
           } catch (SQLException ex) {
               Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
           }
           
    }//GEN-LAST:event_jButton_search_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JasperDesign jdesign;
        try {
            jdesign = JRXmlLoader.load("C:\\Users\\ammaa\\Downloads\\employee_PPA\\employee_PPA\\src\\main\\java\\GUI\\salary2.jrxml");
            String query="select * from salary";
        
        JRDesignQuery updateQuery=new JRDesignQuery();
        updateQuery.setText(query);
        
        jdesign.setQuery(updateQuery);
        
        JasperReport jreport=JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint=JasperFillManager.fillReport(jreport,null,con);
        
        JasperViewer.viewReport(jprint);
        
        
        } catch (JRException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton clear;
    private javax.swing.JTextField days;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_cal;
    private javax.swing.JButton jButton_search_name;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1_salary;
    private javax.swing.JComboBox<String> jComboBox_task;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_OT;
    private javax.swing.JLabel jLabel_days;
    private javax.swing.JLabel jLabele_payment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField othours;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField txt_b_salary;
    private javax.swing.JTextField txt_ot_salary;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txtemp_name;
    private javax.swing.JTextField txtempid;
    private javax.swing.JButton updateBTN;
    // End of variables declaration//GEN-END:variables
}
