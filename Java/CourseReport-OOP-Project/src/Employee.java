public class Employee extends Person
{   //instance variables: -- Name, ID, Salary, Year of Hire.
    private String EmployeeID; //Private Employee ID - Specific to employee
    private double Salary; //Private Employee Salary - Specific to employee
    private int Hire; //Private Employee Hire Year - Specific to Employee

    //Define New Employee Instance Variables
    public Employee(String initialName, String initialEmployeeID, double initialSalary, int initialHire)
    {
        //Inherit Initial Name
        super(initialName);
        //Set initial values of instances
        EmployeeID = initialEmployeeID;
        Salary = initialSalary;
        Hire = initialHire;
    }
    //Resetting, newName and newSalary
    public void reset(String newName, double newSalary)
    {
        setName(newName);
        Salary = newSalary;
    }
    //Accessor and Mutators for variable instances - ID, Salary, Year of Hire.
    //Accessor and Mutators for inherited from Person.java
    //Employee ID GET
    public String getEmployeeID()
    {
        return EmployeeID;
    }
    //Employee ID SET
    public void setEmployeeID(String newEmployeeID)
    {
        EmployeeID = newEmployeeID;
    }
    //Salary GET
    public double getSalary()
    {
        return Salary;
    }
    //Salary SET
    public void setSalary(double newSalary)
    {
        Salary = newSalary;
    }
    //Hire GET
    public int getHire()
    {
        return Hire;
    }
    //Hire SET
    public void setHire(int newHire)
    {
        Hire = newHire;
    }

        public void writeOutput()
    {   //Displaying all employee details
        System.out.println("Name: " + getName( ));
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Salary: " + getSalary());
        System.out.println("Year of Hire: " + getHire());
    }
    //Checking if employee contains the same ID
    public boolean hasSameEmployeeID(Employee otherPerson)
    {
        return this.EmployeeID.equalsIgnoreCase(otherPerson.EmployeeID);
    }
    //Checking if all employee details match
    public boolean equals(Employee otherEmployee)
    {
        //Returning boolean True or False. Using && operator to ensure all statements are true.
        return this.hasSameName(otherEmployee) &&
                this.hasSameEmployeeID(otherEmployee) &&
                (this.Salary == otherEmployee.Salary) &&
                (this.Hire == otherEmployee.Hire);
    }
}