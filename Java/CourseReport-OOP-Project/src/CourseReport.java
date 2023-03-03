import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CourseReport {
    //INVALID INPUTS THROW ERROR, MAKE SURE TO USE OPTIONS 0-13.
    //ENTER NAMES EXACTLY LIKE TXT DOC. (e.j "Ibarra, Jana" including capitals, spaces, and punctuation)
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner file input name
        Scanner sc = new Scanner(System.in);
        System.out.print("File must be located in /src of project directory (Do not enter file extension .txt [e.j 'CourseRecords'] & Case Sensitive) -Testing file already inserted\nPlease enter the file that stores the Course Information: ");
        //Save file input name as filename
        String filename = sc.nextLine();
        //Create new file structure with pathing to source
        File file = new File("src/" + filename + ".txt");

        //Starting Program
        System.out.println("\n\n==CourseReport successfully Started==\n");
        //Initialize new Course
        Course C = new Course(file);

        //Set boolean flag to trigger breakout
        boolean flag = false;
        //System menu display
        System.out.println("What would you like to know? Enter number for question: \n" +
                "1. Name of the course.\n" +
                "2. Number of the course.\n" +
                "3. How many employees?\n" +
                "4. Who are the instructors?\n" +
                "5. Who are the teaching assistants?\n" +
                "6. How many instructors are teaching?\n" +
                "7. How many teaching assistants?\n" +
                "8. How many students?\n"+
                "9. How many graduate students?\n" +
                "10. How many undergraduate students?\n" +
                "11. How many freshman/sophomore/juniors/seniors?\n"+
                "12. How many masters/doctoral students?\n"  +
                "13. Find a specific student, either based on the student’s name or student number.\n");
        //Loop in menu till flag is triggered to breakout
        while(!flag){
            //Scan for next menu integer input
            int option = sc.nextInt();
            //Return Correspond Options

            //Return Class Name
            if(option == 1){
                System.out.println("\nThe Class Name: ");
                System.out.println(C.getClassName());
            //Return Class Number
            } else if(option == 2) {
                System.out.println("\nThe Class Number: ");
                System.out.println(C.getClassNumber());
            //Return Number of Employees [Instructors + Staff/TAs]
            } else if(option == 3) {
                System.out.println("\nNumber of Employees: " + (C.getInstructors().size() + C.getTeachingAssistants().size()));
            //Return the Instructors
            } else if(option == 4) {
                System.out.println("\nThe Instructors are: ");
                C.returnInstructors();
            //Return the TeachingAssistants
            } else if(option == 5) {
                System.out.println("\nThe Staff(TA's) are: ");
                C.returnTAs();
            //Return the Number of Instructors
            } else if(option == 6) {
                System.out.println("\nNumber of Instructors: " + C.getInstructors().size());
            //Return the Number of TeachingAssistants
            }else if(option  == 7) {
                System.out.println("\nThe number of TAs/Staff students: " + C.getTeachingAssistants().size());
            //Return the Number of Students [Undergraduate + Graduate]
            }else if(option == 8) {
                System.out.println("\nThe number of Students: " + (C.getUndergrad().size() + C.getGraduates().size()));
           //Return the Number of Graduates
            }else if(option == 9){
                System.out.println("\nThe Number of Graduate Students: " + C.getGraduates().size());
                //RETURNING EXTRA INFORMATION
                //"\n\nThe Graduate Students are: ");
                //C.returnGraduates();
            //Return the Number of Undergraduates
            }else if(option == 10){
                System.out.println("\nThe Number of Undergraduate Students: " + C.getUndergrad().size());
                //RETURNING EXTRA INFORMATION
                //"\n\nThe Undergraduate Students are:");
                //C.returnUndergrad();
            //Return the Number of Undergraduate Students based upon ENUM Type
            //Return the Corresponding Undergraduate Student details based upon ENUM Type
            }else if(option == 11){
                //Print the grade level
                //System.out.println("FRESHMAN");
                //Create a count to store the # of FRESHMAN Students
                int count = 0;
                //Loop through all the Undergraduate Students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is FRESHMAN, increment the counter
                    if (student.getGradelevel() == Undergraduate.Gradelevel.FRESHMAN) {
                        count++;
                    }
                }
                // Print the number of students in the FRESHMAN grade level
                System.out.println("Number of Students in Grade Level [FRESHMAN]: " + count);

                // Loop through all the Undergraduate Students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is FRESHMAN, print the student's information
                    if (student.getGradelevel() == Undergraduate.Gradelevel.FRESHMAN) {
                        student.writeOutputUndergrad();
                    }
                }
                System.out.println("\n");
                //Set Count back to ZERO
                count = 0;
                 //Loop through all the undergraduate students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is SOPHOMORE, increment the counter
                    if (student.getGradelevel() == Undergraduate.Gradelevel.SOPHOMORE) {
                        count++;
                    }
                }
                //Print the number of students in the SOPHOMORE grade level
                System.out.println("Number of Students in Grade Level [SOPHOMORE]: " + count);
                //Loop through all the undergraduate students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is SOPHOMORE, print the student's information
                    if (student.getGradelevel() == Undergraduate.Gradelevel.SOPHOMORE) {
                        student.writeOutputUndergrad();
                    }
                }
                System.out.println("\n");
                // Print the grade level
                //System.out.println("JUNIOR");
                //Set Count back to ZERO
                count = 0;
                //Loop through all the undergraduate students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is JUNIOR, increment the counter
                    if (student.getGradelevel() == Undergraduate.Gradelevel.JUNIOR) {
                        count++;
                    }
                }
                //Print the number of students in the JUNIOR grade level
                System.out.println("Number of Students in Grade Level [JUNIOR]: " + count);
                //Loop through all the undergraduate students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is JUNIOR, print the student's information
                    if (student.getGradelevel() == Undergraduate.Gradelevel.JUNIOR) {
                        student.writeOutputUndergrad();
                    }
                }
                System.out.println("\n");
                //Print the grade level
                //System.out.println("SENIOR");
                //Set Count back to ZERO
                count = 0;
                //Loop through all the undergraduate students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is SENIOR, increment the counter
                    if (student.getGradelevel() == Undergraduate.Gradelevel.SENIOR) {
                        count++;
                    }
                }
                //Print the number of students in the SENIOR grade level
                System.out.println("Number of Students in Grade Level [SENIOR]: " + count);
                //Loop through all the undergraduate students
                for (Undergraduate student : C.getUndergrad()) {
                    //If Student is SENIOR, print the student's information
                    if (student.getGradelevel() == Undergraduate.Gradelevel.SENIOR) {
                        student.writeOutputUndergrad();
                    }
                }
                System.out.println("\n");
            //Return the Number of Graduate Students based upon ENUM Type
            //Return the Corresponding Graduate Student details based upon ENUM Type
            } else if (option == 12) {
                //Initialize Count for Graduate Student Programs
                int count = 0;
                //Loop through all the graduate students
                for (Graduate graduates : C.getGraduates()) {
                    //If the STUDENT program is MASTERS, increment the counter
                    if (graduates.getProgram() == Graduate.Program.MASTERS) {
                        count++;
                    }
                }
                //Print the count of STUDENTS in MASTERS program
                System.out.println("Number of Students in Program [MASTERS]: " + count);
                //Loop through all the graduate students
                for (Graduate student : C.getGraduates()) {
                    //If the STUDENT program is MASTERS, print the student's information
                    if (student.getProgram() == Graduate.Program.MASTERS) {
                        student.writeOutputGraduate();
                    }
                }
                System.out.println("\n");
                //Set Count back to ZERO
                count = 0;
                for (Graduate student : C.getGraduates()) {
                    //If the STUDENT program is DOCTORAL, increment the counter
                    if (student.getProgram() == Graduate.Program.DOCTORAL) {
                        count++;
                    }
                }
                //Print the count of students in the DOCTORAL program
                System.out.println("Number of Students in Program [DOCTORAL]: " + count);
                //Loop through all the graduate students
                for (Graduate student : C.getGraduates()) {
                    //If the STUDENT program is DOCTORAL, print the student's information
                        if (student.getProgram() == Graduate.Program.DOCTORAL) {
                            student.writeOutputGraduate();
                        }
                }
                //Find Students Option
                } else if(option == 13){
                    //Search for input, either ID or NAME
                    sc.nextLine();
                    System.out.println("Please Enter the Student Name (Case sensitive, include commas & spacing [e.j  'Ibarra, Jana') or Student Number [ID] you are looking for.");
                    String n = sc.nextLine();
                    //Use FindStudents to return if student present or not
                    C.equalsStudent(n);
                    //Display Output
                }
            //Breaking out of MENU
            System.out.print("\nDo you have more questions? (Enter number of next question, or 0 to exit!): ");
            if(option == 0){
                //Display Termination Message, and indicate flag to breakout
                System.out.println(" \n\n==CourseReport successfully terminated==\n ");
                flag = true;
            }
        }
    }
}
