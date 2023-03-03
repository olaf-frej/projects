public class Graduate extends Student{
    //Extend STUDENT
    //Initialize PROGRAM
    Program program;

    //ENUM REPRESENTS 2 PROGRAMS, MASTER & DOCTORAL.
    static enum Program {
        MASTERS,
        DOCTORAL
    }
    public Graduate(String initialName, int initialStudentNumber, Program program){
        super(initialName, initialStudentNumber);
        this.program = program;
    }

    //Read and Display API. Firstname, Lastname, & Program
    //Setting Program
    public void setProgram(Program program){
        this.program = program;
    }

    //Getting Program
    public Program getProgram(){
        return this.program;
    }

    //Display the output of Graduate
    public void writeOutputGraduate()
    {
        System.out.println("Graduate: " + getName() + "; " + getStudentNumber() + "; " + getProgram());
    }

    //Check if the graduates are equal
    public boolean EqualsGraduate(Graduate otherGraduate)
    {
        return this.hasSameName(otherGraduate) && (this.getStudentNumber() == otherGraduate.getStudentNumber()) &&
                (this.program == otherGraduate.program);
    }

}
