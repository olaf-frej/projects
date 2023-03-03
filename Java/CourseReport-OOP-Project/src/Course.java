import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.naming.directory.InvalidAttributeValueException;

public class Course {
    //Initialize Variables
    // [Strings per Class Number/Name]
    // [ArrayLists per Person Type]
    private String ClassNumber;
    private String ClassName;
    private final ArrayList<Faculty> instructors = new ArrayList<>();
    private final ArrayList<Staff> teachingAssistants = new ArrayList<>();
    private final ArrayList<Graduate> graduates = new ArrayList<>();
    private final ArrayList<Undergraduate> undergraduates = new ArrayList<>();

    //THROW ERROR IF INPUT INVALID
    public Course(File file) throws FileNotFoundException {
        boolean found;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String initialValue = line.split(":")[0];
            //PARSE AND FIND COURSE NUMBER
            if (initialValue.equals("Number")) {
                String[] initialField = line.split(":");
                this.ClassNumber = initialField[1].substring(1);
            }
            //PARSE AND FIND COURSE NAME
            else if (initialValue.equals("Name")) {
                //SPLIT VIA DELIMITER & STORE IN CORRESPONDING ARRAY/SUBSTRING
                String[] initialField = line.split(":");
                this.ClassName = initialField[1].substring(1);
            }
            //PARSE AND FIND INSTRUCTORS [REMOVE DUPLICATES]
            else if (initialValue.equals("Instructor")) {
                //SPLIT VIA DELIMITER & STORE IN CORRESPONDING ARRAY/SUBSTRING
                String[] initialField = line.split(":");
                String[] initialAttributes = initialField[1].split(";");
                String name = initialAttributes[0].substring(1);
                String id = initialAttributes[1].substring(1);
                double salary = Double.parseDouble(initialAttributes[2].substring(1).replace(",", ""));
                int YOH = Integer.parseInt(initialAttributes[3].substring(1));
                String title = initialAttributes[4].substring(1);
                found = false;
                //SET LIMIT TO INSTRUCTORS [2 MAX]
                if (instructors.size() < 2) {
                    //REMOVING DUPLICATES
                    //ONLY ADDING INSTRUCTORS WHOSE ID IS NOT ALREADY PRESENT
                    for (Faculty instructors : instructors) {
                        //IF FOUND, SKIP
                        if (instructors.getEmployeeID().equals(id)) {
                            found = true;
                            break;
                        }
                    }
                    //IF NOT FOUND, ADD
                    if (!found) {
                        instructors.add(new Faculty(name, id, salary, YOH, title));
                    }
                }
            }
            //PARSE AND STORE STAFF [REMOVE DUPLICATES]
            else if (initialValue.equals("Staff")) {
                //SPLIT VIA DELIMITER & STORE IN CORRESPONDING ARRAY/SUBSTRING
                String[] initialField = line.split(":");
                String[] initialAttributes = initialField[1].split(";");
                String name = initialAttributes[0].substring(1);
                String id = initialAttributes[1].substring(1);
                double salary = Double.parseDouble(initialAttributes[2].substring(1).replace(",", ""));
                int YOH = Integer.parseInt(initialAttributes[3].substring(1));
                int payGrade = Integer.parseInt(initialAttributes[4].substring(1));
                found = false;
                //SET LIMIT TO TEACHINGASSISTANTS [5 MAX]
                if (teachingAssistants.size() < 5) {
                    //REMOVING DUPLICATES
                    //ONLY ADDING TEACHINGASSISTANTS WHOSE ID IS NOT ALREADY PRESENT
                    for (Staff ta : teachingAssistants) {
                        //IF FOUND, SKIP
                        if (ta.getStaffNumber().equals(id)) {
                            found = true;
                            break;
                        }
                    }
                    //IF NOT FOUND, ADD
                    if (!found) {
                        teachingAssistants.add(new Staff(name, id, salary, YOH, payGrade));
                    }
                }
            }
            //PARSE AND STORE UNDERGRADUATES [REMOVE DUPLICATES]
            else if (initialValue.equals("Undergraduate")) {
                String[] initialField = line.split(":");
                String[] initialAttributes = initialField[1].split(";");
                String name = initialAttributes[0].substring(1);
                int id = Integer.parseInt(initialAttributes[1].substring(1));
                Undergraduate.Gradelevel gradelevel = stringToLevel(initialAttributes[2].substring(1));
                //REMOVING DUPLICATES
                //ONLY ADDING INSTRUCTORS WHOSE ID IS NOT ALREADY PRESENT
                found = false;
                for (Undergraduate u : undergraduates) {
                    //IF FOUND, SKIP
                    if (u.getStudentNumber() == id) {
                        found = true;
                        break;
                    }
                }
                //IF NOT FOUND, ADD
                if (!found) {
                    undergraduates.add(new Undergraduate(name, id, gradelevel));
                }
            }
            //PARSE AND STORE GRADUATES [REMOVE DUPLICATES]
            else if (initialValue.equals("Graduate")) {
                String[] initialField = line.split(":");
                String[] initialAttributes = initialField[1].split(";");
                String name = initialAttributes[0].substring(1);
                int id = Integer.parseInt(initialAttributes[1].substring(1));
                Graduate.Program program = stringToProgram(initialAttributes[2].substring(1));
                //REMOVING DUPLICATES
                //ONLY ADDING GRADUATES WHOSE ID IS NOT ALREADY PRESENT
                found = false;
                for (Graduate grad : graduates) {
                    //IF FOUND, SKIP
                    if (grad.getStudentNumber() == id) {
                        found = true;
                        break;
                    }
                }
                //IF NOT FOUND, ADD
                if (!found) {
                    graduates.add(new Graduate(name, id, program));
                }
            }
        }
        //Close Scanner
        scanner.close();
    }

    //CONVERTING TO STRING//
    public Graduate.Program stringToProgram(String p) {
        return Graduate.Program.valueOf(p);
    }

    public Undergraduate.Gradelevel stringToLevel(String l) {
        return Undergraduate.Gradelevel.valueOf(l);
    }

    //RETURN FUNCTIONS [DISPLAYING OUTPUT]//
    public void returnInstructors() {
        //TRAVERSE THROUGH ALL INSTRUCTORS
        for (Faculty instructor : this.instructors) {
            instructor.writeOutputFaculty();
        }
    }

    public void returnGraduates() {
        //TRAVERSE THROUGH ALL GRADUATES
        for (Graduate graduates : this.graduates) {
            graduates.writeOutputGraduate();
        }
    }

    public void returnUndergrad() {
        //TRAVERSE THROUGH ALL UNDERGRADUATES
        for (Undergraduate undergraduate : this.undergraduates) {
            undergraduate.writeOutputUndergrad();
        }
    }

    public void returnTAs() {
        //TRAVERSE THROUGH ALL TAS
        for (Staff teachingAssistants : this.teachingAssistants) {
            teachingAssistants.writeOutputStaff();
        }
    }

    //GET FUNCTIONS// //RETURNING EACH ATTRIBUTE/CLASS//
    public String getClassNumber() { return this.ClassNumber; }

    public String getClassName() { return this.ClassName; }

    public ArrayList<Faculty> getInstructors() { return this.instructors; }

    public ArrayList<Staff> getTeachingAssistants() { return this.teachingAssistants; }

    public ArrayList<Graduate> getGraduates() { return this.graduates; }

    public ArrayList<Undergraduate> getUndergrad() { return this.undergraduates; }

    //FINDING STUDENTS//
    public String equalsStudent(String n) {
        //SEARCH THROUGH UNDERGRADUATES
        for (Undergraduate student : this.undergraduates) {
            try {
                //IF NUMBER FOUND
                int number = Integer.parseInt(n);
                if (student.getStudentNumber() == number) {
                    System.out.println("This Student is present in the class");
                    student.writeOutputUndergrad();
                    return "";
                }
            } catch (NumberFormatException ex) {
                //IF NAME FOUND
                if (student.getName().equals(n)) {
                    System.out.println("This Student is present in the class");
                    student.writeOutputUndergrad();
                    return "";
                }
            }
        }
        //SEARCH THROUGH GRADUATES
        for (Graduate student : this.graduates) {
            try {
                //IF NUMBER FOUND
                int number = Integer.parseInt(n);
                if (student.getStudentNumber() == number) {
                    System.out.println("This Student is present in the class");
                    student.writeOutputGraduate();
                    return "";
                }
            } catch (NumberFormatException ex) {
                //IF NAME FOUND
                if (student.getName().equals(n)) {
                    System.out.println("This Student is present in the class");
                    student.writeOutputGraduate();
                    return "";

                }
            }
        }
        //OTHERWISE NOT FOUND
        return "This Student is not present in the class";
    }
}