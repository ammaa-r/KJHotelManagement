package Code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Pasan
 */
public class EmpSalary {
    private String Employee_ID;
    private String Employee_Name;
    private String Basic_Salary;
    private String Total_Salary;
    private String Salary_Payement_Type;

    public EmpSalary(String Employee_ID, String Employee_Name, String Basic_Salary, String Total_Salary, String Salary_Payement_Type) {
        this.Employee_ID = Employee_ID;
        this.Employee_Name = Employee_Name;
        this.Basic_Salary = Basic_Salary;
        this.Total_Salary = Total_Salary;
        this.Salary_Payement_Type = Salary_Payement_Type;
    }
    
    
     public String getEmployee_ID(){
         return Employee_ID;
     }
     public String getEmployee_Name(){
         return Employee_Name;
     }
     public String getBasic_Salary(){
         return Basic_Salary;
     }
     public String getTotal_Salary(){
         return Total_Salary;
     }
     public String getSalary_Payement_Type(){
         return Salary_Payement_Type;
     }
}
