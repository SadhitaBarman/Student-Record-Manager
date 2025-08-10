import java.util.*;
import java.io.*;
public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, age, course, marks));
        System.out.println("Student added succesfully!");
    }

    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No students found");
            return;
        }

        for(Student s: students){
            s.display();
        }
    }

    public void searchStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to search: ");

        String id = sc.nextLine();

        for(Student s: students){
            if(s.getId().equalsIgnoreCase(id)){
                s.display();
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void updateStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to be updated: ");
        String id = sc.nextLine();

        for(Student s: students){
            if(s.getId().equalsIgnoreCase(id)){
                while(true){
                    System.out.println("""
                    What do you want to Update?
                    1. Name
                    2. Age
                    3. Course
                    4. Marks
                    5. Return back to main menu
                    """);

                    System.out.println("Enter Choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice){
                        case 1:
                            System.out.println("New Name: ");
                            s.setName(sc.nextLine());
                            System.out.println("Name Updated!");
                            break;
                        case 2:
                            System.out.println("New Age: ");
                            s.setAge(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Age Updated");
                            break;
                        case 3:
                            System.out.println("New Course: ");
                            s.setCourse(sc.nextLine());
                            System.out.println("Course Updated!");
                            break;
                        case 4:
                            System.out.println("New Marks: ");
                            s.setMarks(sc.nextDouble());
                            sc.nextLine();
                            System.out.println("Marks Updated!");
                            break;
                        case 5:
                            System.out.println("Returning back to main menu... ");
                            return;
                        default:
                            System.out.println("Invalid Choice! Try again.");
                    }

                }
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID to be deleted: ");
        String id = sc.nextLine();

        Iterator<Student> itr = students.iterator();
        while(itr.hasNext()){
            Student s = itr.next();
            if(s.getId().equalsIgnoreCase(id)){
                itr.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void saveToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Student s: students){
                bw.write(s.toString());
                bw.newLine();
            }
            System.out.println("Data Saved to file.");
        } catch(Exception e){
            System.out.println("Error saving file" + e.getMessage());
        }
    }

    public void loadFromFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split("//|");

                if(parts.length == 5){
                    students.add(new Student(
                            parts[0].trim(),
                            parts[1].trim(),
                            Integer.parseInt(parts[2].trim()),
                            parts[3].trim(),
                            Double.parseDouble(parts[4].trim())
                    ));
                }
            }
        } catch (Exception e){
            System.out.println("No data found");
        }
    }
}






