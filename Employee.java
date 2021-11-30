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
public class Employee {
    private String Employee_ID;
    private String Employee_Name;
    private String NIC;
    private String Address;
    private String Date_of_Birth;
    private String Age;
    private String contact_number;
    private String Gender;
    private String salary; 
    
    public Employee(String Employee_ID, String Employee_Name, String NIC, String Address,
            String Date_of_Birth, String Age, String contact_number, String Gender, String Salary)
    {
        this.Employee_ID=Employee_ID;
        this.Employee_Name=Employee_Name;
        this.NIC=NIC;
        this.Address=Address;
        this.Date_of_Birth=Date_of_Birth;
        this.Age=Age;
        this.contact_number=contact_number;
        this.Gender=Gender;
        this.salary=Salary;
    }

    public String getEmployee_ID() {
        return Employee_ID;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public String getNIC() {
        return NIC;
    }

    public String getAddress() {
        return Address;
    }

    public String getDate_of_Birth() {
        return Date_of_Birth;
    }

    public String getAge() {
        return Age;
    }

    public String getContact_number() {
        return contact_number;
    }

    public String getGender() {
        return Gender;
    }

    public String getSalary() {
        return salary;
    }
    
    
}
