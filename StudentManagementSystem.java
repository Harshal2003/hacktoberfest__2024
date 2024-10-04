import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("Enter Student ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Student Age:");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Student Grade:");
        String grade = scanner.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void editStudent() {
        System.out.println("Enter Student ID to Edit:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                System.out.println("Enter new age:");
                int age = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.println("Enter new grade:");
                String grade = scanner.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);

                System.out.println("Student details updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.println("Enter Student ID to Delete:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
