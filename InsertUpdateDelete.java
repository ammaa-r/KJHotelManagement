/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ammaar
 */

///  To data Manipulaton this class is used.
public class InsertUpdateDelete {
    ///insignup page, we are going to pass setData mathod and pass Query and messege the  were are able to insert in out=r database
    public static void setData(String Query, String msg){
        Connection con=null;
        Statement st=null;
        
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            st.executeUpdate(Query);
            
            /*sometimes we dont want to display any messeges when user insert data in to database
            */
            if(!msg.equals("")){
                JOptionPane.showMessageDialog(null, msg);
            }
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
            try{
            
        }catch(Exception e){
            
        }
        }
    }
}
