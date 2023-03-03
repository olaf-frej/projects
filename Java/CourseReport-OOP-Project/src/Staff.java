public class Staff extends Employee {
    //Extend EMPLOYEE
    //Initialize StaffNumber & Paygrade
    private String StaffNumber;

    private int Paygrade;


    //Inherit and initialize class
    public Staff(String initialName, String initialStaffNumber, double initialSalary, int initialHire, int initialPaygrade)
    {
        super(initialName, initialStaffNumber, initialSalary, initialHire);
        StaffNumber = initialStaffNumber;
        Paygrade = initialPaygrade;
    }

    //SET STAFF NUMBER
    public void setStaffNumber(String newStaffNumber)
    {
        StaffNumber = newStaffNumber;
    }

    //GET STAFF NUMBER
    public String getStaffNumber()
    {
        return StaffNumber;
    }

    //SET PAYGRADE
    public void setPaygrade(int newPaygrade){
        Paygrade = newPaygrade;
    }

    //GET PAYGRADE
    public int getPaygrade(){
        return Paygrade;
    }

    //DISPLAY OUTPUT OF STAFF
    public void writeOutputStaff()
    {
        System.out.println("Staff: " + getName() + "; " + getStaffNumber() + "; "
                                     + getSalary() + "; " + getHire() + "; " + getPaygrade());
    }

    //CHECK IF STAFF ARE THE SAME
    public boolean EqualsStaff(Staff otherStaff)
    {
        return this.hasSameName(otherStaff) &&
                this.getStaffNumber() == otherStaff.getStaffNumber() &&
                this.getSalary() == otherStaff.getSalary() &&
                this.getHire() == otherStaff.getHire() &&
                this.getPaygrade() == otherStaff.getPaygrade();
    }
}

