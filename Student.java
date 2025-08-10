public class Student {
    private String id;
    private String name;
    private int age;
    private String course;
    private double marks;

    //this is a parameterized constructor
    public Student(String id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    /*here we have pvt variables for which a=we are
    * using getter setter methods
    * getter returning variables
    * setter providing memory and access as per
    * pvt variables */
    public String getId() {return id; }
    public String getName() {return name; }
    public int getAge() {return age; }
    public String getCourse() {return course; }
    public double getMarks() {return marks; }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    //called to convert obj to its string equi
    public String toString(){
        return id+" | "+name+" | "+age+" | "+course+" | "+marks;
    }

    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("------------------------");
    }

}
