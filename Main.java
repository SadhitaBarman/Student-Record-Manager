import java.util.*;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit & Save");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: manager.addStudent(); break;
                case 2: manager.viewStudents(); break;
                case 3: manager.searchStudent(); break;
                case 4: manager.updateStudent(); break;
                case 5: manager.deleteStudent(); break;
                case 6: manager.saveToFile(); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }

    }
}
