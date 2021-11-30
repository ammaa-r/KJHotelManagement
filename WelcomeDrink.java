package Catering;

public class WelcomeDrink {
    
    public WelcomeDrink(){
        
    }
    
    private String WelcomeDrink, DrinkPrice;
    
    
    public String getWelcomeDrink()
      {
         return WelcomeDrink;
      }
     
     public String getDrinkPrice()
      {
         return DrinkPrice;
      }
     
     protected void setWelcomeDrink(String iWelcomeDrink)
      {
         this.WelcomeDrink = iWelcomeDrink;
      }
     
     protected void setDrinkPrice(String iDrinkPrice)
      {
         this.DrinkPrice = iDrinkPrice;
      }
}
