public class Undergraduate extends Student{
    //Extend STUDENT
    //Initialize GRADELEVEL
    Gradelevel gradelevel;

    //ENUM REPRESENTS 4 LEVELS, FRESHMAN, SOPHOMORE, JUNIOR, & SENIOR.
    static enum Gradelevel {
        FRESHMAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    }

    //Inherit and initialize class
    public Undergraduate(String initialName, int initialStudentNumber, Gradelevel gradelevel)
    {
        super(initialName, initialStudentNumber);
        this.gradelevel = gradelevel;

    }
    //Read and Display API. Firstname, Lastname, & Gradelevel
    public void setGradelevel(Gradelevel gradelevel)
    {
        this.gradelevel = gradelevel;
    }
    public Gradelevel getGradelevel(){
        return this.gradelevel;
    }

    //Displaying Undergrad information
    public void writeOutputUndergrad()
    {
        System.out.println("Undergraduate: " + getName() + "; " + getStudentNumber()
                            + "; " + getGradelevel());
    }

    //Checking if Same Name, Number, and Gradelevel
    public boolean EqualsUndergrad(Undergraduate otherUndergrad){
        return this.hasSameName(otherUndergrad) &&
                (this.getStudentNumber() == otherUndergrad.getStudentNumber()) &&
                (this.gradelevel == otherUndergrad.gradelevel);
    }

}
//CRUD API- Create, Read, Update, Delete