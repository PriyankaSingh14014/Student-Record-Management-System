import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // Consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
