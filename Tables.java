/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ammaar
 */
public class Tables {
    public static void main(String[] args){
        Connection con=null;
        Statement st=null; 
        
        try{
            ///Creating Tables
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            
            //st.executeUpdate("create table users (name varchar(200), email varchar(200), password varchar(16), securityQuetion varchar(500), answer varchar(200), contact varchar(13), status varchar(20) )");
            
            //st.executeUpdate("create table room (roomNo varchar(10), roomType varchar(100), bed varchar(100), price int, status varchar(20))");
            
            //st.executeUpdate("create table Hotel_Customer (id int, name varchar(100), mobileNumber varchar(10), address  varchar(200), gender varchar(10), email varchar(100), idProof varchar(50), checkIn varchar(20), roomNo varchar(10), bed varchar(20), roomType varchar(20), pricePerDay int(10), numberOfDaysStay int(10), totalAmount varchar(200), checkOut varchar(50) )");
            
            JOptionPane.showMessageDialog(null, "Table Created Successfully!!");
            
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, e);
        }finally{
             try{
                 con.close();
                 st.close();
        }catch(Exception e){
            
        }
        }
    }
}
