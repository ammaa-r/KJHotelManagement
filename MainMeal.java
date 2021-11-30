package Catering;

class MainMeal {
    
    public MainMeal()
    {
        
    }
    
    private String MainMeal, MealPrice;
    

    public String getMainMeal()
      {
         return MainMeal;
      }
     
    public String getMealPrice()
      {
         return MealPrice;
      }
        protected void setMainMeal(String iMainMeal)
      {
         this.MainMeal = iMainMeal;
      }
     
     protected void setMealPrice(String iMealPrice)
      {
         this.MealPrice = iMealPrice;
      }
}
