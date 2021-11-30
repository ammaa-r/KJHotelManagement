/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import java.util.regex.*;

/**
 *
 * @author ammaar
 */
public class Validations {
    public static boolean validateEmail(String email){
        boolean validStatus1=false;
        
        ///Regular Email Expression
        String emailPattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern=Pattern.compile(emailPattern);
        Matcher matcher=pattern.matcher(email);
        
        if(matcher.matches()){
            validStatus1=true;
        }else{
            validStatus1=false;
        }
        return validStatus1;  
    }
    
    public static boolean validatePhoneNo(String phoneNo){
        boolean validStatus2=false;
        
        ///Regular Phone No Expression - validation atleast 10 digits
        String phoneNoPattern="\\d{10}";
        Pattern pattern=Pattern.compile(phoneNoPattern);
        Matcher matcher=pattern.matcher(phoneNo);
        
        if(matcher.matches()){
            validStatus2=true;
        }else{
            validStatus2=false;
        }
        return validStatus2;  
    }
    
}
