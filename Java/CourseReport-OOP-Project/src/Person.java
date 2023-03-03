//DEFAULT MAIN CLASS - PERSON
public class Person
{
    //INITIALIZE, NAME
    private String name;
    public Person(String initialName) { name = initialName; }
    //SET NAME
    public void setName(String newName) { name = newName; }
    //GET NAME
    public String getName() { return name; }
    //DISPLAY OUTPUT OF PERSON
    public void writeOutput() { System.out.println("Name: " + name); }
    //CHECK IF PEOPLE HAVE SAME NAME
    public boolean hasSameName(Person otherPerson) { return this.name.equalsIgnoreCase(otherPerson.name);}
}
