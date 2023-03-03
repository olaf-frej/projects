public class Faculty extends Employee {
    //Extend EMPLOYEE
    //Initialize EmployeeNumber & Paygrade
    private String EmployeeNumber;
    private int Paygrade;

    //Inherit and initialize class
    public Faculty(String initialName, String initialEmployeeID, double initialSalary, int initialHire, String initialNumber){
        super(initialName, initialEmployeeID, initialSalary, initialHire);
        EmployeeNumber = initialNumber;
    }

    //Inherited
    //  -Setting Name    -Setting EmployeeNumber
    //  -Setting Salary  -Setting EmployeeID

    //Setting Employee
    public void setEmployeeNumber(String newEmployeeNumber){
         EmployeeNumber = newEmployeeNumber;
    }

    //Getting Program
    public String getEmployeeNumber(){
        return EmployeeNumber;
    }

    //Write Faculty Output
    public void writeOutputFaculty()
    {
        System.out.println("Instructor: " + getName() + "; " + getSalary() + "; "
                           + getHire() + "; " + getEmployeeID());
    }

    //Check if Faculty are equivalent
    public boolean EqualsFaculty(Faculty otherFaculty)
    {
        return this.hasSameName(otherFaculty) &&
                this.EmployeeNumber == otherFaculty.EmployeeNumber &&
                this.getSalary() == otherFaculty.getSalary() &&
                this.getHire() == otherFaculty.getHire() &&
                this.hasSameEmployeeID(otherFaculty);
    }
}
