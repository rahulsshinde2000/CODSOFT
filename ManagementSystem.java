
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> searchStudent(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(keyword) || Integer.toString(student.getRollNumber()).contains(keyword) || student.getGrade().contains(keyword)) {
                result.add(student);
            }
        }
        return result;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class ManagementSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StudentManagementSystem sms = new StudentManagementSystem();
        
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = br.readLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = Integer.parseInt(br.readLine());
                    System.out.print("Enter student grade: ");
                    String grade = br.readLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
		    						System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Enter the name or roll number of the student to remove: ");
                    String removeKeyword = br.readLine();
                    List<Student> studentsToRemove = sms.searchStudent(removeKeyword);
                    if (!studentsToRemove.isEmpty()) {
                        for (Student student : studentsToRemove) {
                            sms.removeStudent(student);
                            System.out.println("Removed: " + student);
			    									System.out.println("\n");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter search keyword: ");
                    String searchKeyword = br.readLine();
                    List<Student> searchResults = sms.searchStudent(searchKeyword);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search Results:");
                        for (Student student : searchResults) {
                            System.out.println(student);
			    									System.out.println("\n");
                        }
                    } else {
                        System.out.println("No matching students found.");
                    }
                    break;
                case 4:
                    System.out.println("All Students:");
                    sms.displayAllStudents();
										System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Exiting Student Management System.");
                    
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

