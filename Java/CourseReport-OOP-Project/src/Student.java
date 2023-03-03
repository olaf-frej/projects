public class Student extends Person
{
    //Extend PERSONS
    //Initialize Studentnumber
    private int studentNumber;

    //Inherit and initialize class
    public Student(String initialName, int initialStudentNumber)
    {
        super(initialName);
        studentNumber = initialStudentNumber;
    }

    //RESET STUDENT
    public void reset(String newName, int newStudentNumber)
    {
        setName(newName);
        studentNumber = newStudentNumber;
    }
    //GET STUDENT NUMBER
    public int getStudentNumber()
    {
        return studentNumber;
    }

    //SET STUDENT NUMBER
    public void setStudentNumber(int newStudentNumber)
    {
        studentNumber = newStudentNumber;
    }

    //DISPLAY STUDENT OUTPUT
    public void writeOutput()
    {
        System.out.println("Name: " + getName( ));
        System.out.println("Student Number: " + studentNumber);
    }
    //CHECK IF STUDENTS EQUAL
    public boolean equals(Student otherStudent)
    {
        return this.hasSameName(otherStudent) &&
                (this.studentNumber == otherStudent.studentNumber);
    }
}
