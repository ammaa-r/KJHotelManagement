/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catering;

/**
 *
 * @author darsh
 */
class TotalPrice {
    
    String OrderID;
    String TableNum;
    String EmpName;
    String TotalPrice;
    
    
    public TotalPrice(){
        
    }
    
    
    public String getOrderID(){
          return OrderID;
      }
      public String getTableNum(){
          return TableNum;
      }

    public String getEmpName() {
        return EmpName;
    }

    
      
      public String getTotalPrice(){
          return TotalPrice;
      }
      
      public void setOrderId(String iOrderID){
          this.OrderID = iOrderID;
      }
      
      public void setTableNum(String iTableNum){
          this.TableNum = iTableNum;
      }
      public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }
      public void setTotalPrice(String iTotalPrice){
             
           this.TotalPrice = iTotalPrice;  
         }
}
