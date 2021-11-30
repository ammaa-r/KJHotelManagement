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
class PersonOrder {
    
    String OrderID;
    String Employee;
    String Drink;
    String Main;
    String Dessert;
    String Price;
    


public PersonOrder(){}


      public String getOrderID(){
          return OrderID;
      }

      public String getEmployee() {
        return Employee;
      }

      
      public String getDrink(){
      
         return Drink;
      
      }

      
      public String getMain(){
      
         return Main;
      
      }
      
      public String getDessert(){
      
         return Dessert;
      
      }
      
      public String getPrice(){
          return Price;
      }
      
      
      
      public void setOrderID(String iOrderID){
          this.OrderID = iOrderID;
      }

      public void setEmployee(String Employee) {
        this.Employee = Employee;
      }
      
      
      public void setDrink(String iStarter)
      {
         this.Drink = iStarter;
      }
      
      public void setMain(String iMain){
      
           this.Main = iMain;
      }
      
         public void setDessert(String iDessert){
      
           this.Dessert = iDessert;
      }
         
         public void setPrice(String iPrice){
             
           this.Price = iPrice;  
         }

    void setPrice(double RR) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}