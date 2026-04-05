package service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import database.FileManage;
import model.Student;

public class StudentService {

    Scanner sc;

    public StudentService(Scanner sc) {
        this.sc = sc;
    }

    public int uid() {
        Random r = new Random();
        int id = r.nextInt(100000000, 999999999);

        // Possible infinite loop
        if (FileManage.map.containsKey(id))
            uid();

        return id;
    }

    public boolean addStudent() {
        System.out.println("\n\tENTER DETAILS\n");
        int studetnId = uid();
        System.out.print("\tEnter name: ");
        String name = sc.nextLine();
        System.out.print("\tEnter age: ");
        int age = sc.nextInt();
        System.out.print("\tEnter course: ");
        sc.nextLine();
        String course = sc.nextLine();
        System.out.print("\tEnter branch: ");
        String branch = sc.nextLine();
        System.out.print("\tEnter Enrollment year: ");
        int ennrolYear = sc.nextInt();
        System.out.print("\tEnter phone number: ");
        long phone = sc.nextLong();
        System.out.print("\tEnter email address: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.println();

        // Duplicate id check
        if (FileManage.map.containsKey(studetnId)) {
            System.out.println("Student already exist");

            return false;
        }

        // validate name string
        if (name.length() == 0 || name.equals(" ")) {
            System.out.println("Inavlid name");

            return false;
        }
        // Validate Email
        if (!EmailValidator.validate(email)) {
            System.out.println("Invalid email address");

            return false;
        }

        // Validate age
        if (age < 10 || age > 100) {
            System.out.println("In valid age");

            return false;
        }

        // Validate Phone
        if (phone == 0 || String.valueOf(phone).length() != 10) {
            System.out.println("Invalid phone number");

            return false;
        }

        Student newStudent = new Student(studetnId, name, age, course, branch, ennrolYear, phone, email);
        // Write the student to file

        try (FileWriter wr = new FileWriter("database/students.txt", true)) {

            if (FileManage.map.isEmpty()) {
                wr.write(studetnId + "," + name + "," + age + "," + course + "," + branch + "," + ennrolYear + ","
                        + phone
                        + "," + email);
            } else {

                wr.write(
                        "\n" + studetnId + "," + name + "," + age + "," + course + "," + branch + "," + ennrolYear + ","
                                + phone
                                + "," + email);
            }

        } catch (Exception e) {
            System.out.println("Could not write into students file: " + e.getMessage());

            return false;
        }

        // Update the map with new entry
        FileManage.map.put(studetnId, newStudent);

        return true;
    }

    public void printStudents(List<Student> students) {
        System.out.printf("%-12s %-15s %-5s %-10s %-10s %-6s %-15s %-25s\n",
                "Student ID", "Name", "Age", "Course", "Branch", "Year", "Phone", "Email");

        System.out.println(
                "---------------------------------------------------------------------------------------------");

        for (Student s : students) {

            System.out.printf("%-12s %-15s %-5s %-10s %-10s %-6s %-15s %-25s\n",
                    s.getStudetnId(), s.getName(), s.getAge(), s.getCourse(),
                    s.getBranch(), s.getEnnrolYear(), s.getPhone(), s.getEmail());
        }
    }

    public void viewAllStudents() {

        if (!FileManage.map.isEmpty()) {
            List<Student> list = new ArrayList<>();
            for (Student s : FileManage.map.values()) {
                list.add(s);
            }
            printStudents(list);
        } else {
            System.out.println("No record found");
        }

    }

    public void searchStudent(String name) {
        List<Student> list = new ArrayList<>();
        for (Student s : FileManage.map.values()) {
            if (name.equalsIgnoreCase(s.getName())) {
                list.add(s);
            }
        }

        if (list.isEmpty()) {
            System.out.println("No student found");
        } else {
            printStudents(list);
        }

    }

    public void searchStudent(int studetnId) {
        List<Student> list = new ArrayList<>();
        list.add(FileManage.map.get(studetnId));

        if (list.isEmpty()) {
            System.out.println("No student found");
        } else {
            printStudents(list);
        }

    }

    public boolean deleteStudent(int studetnId) {

        if (!FileManage.map.containsKey(studetnId) || FileManage.map.isEmpty()){
            System.out.println("No Record found");
            return false;
        }

        Student deleted = FileManage.map.remove(studetnId);
        File f = new File("database/students.txt");
        f.delete();

        try (FileWriter wr = new FileWriter("database/students.txt", true)) {

            boolean first = true;
            for (Student s : FileManage.map.values()) {
                if (first) {
                    wr.write(s.getStudetnId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse() + ","
                            + s.getBranch() + "," + s.getEnnrolYear() + "," + s.getPhone() + "," + s.getEmail());
                    first = false;
                } else {
                    wr.write("\n" + s.getStudetnId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse() + ","
                            + s.getBranch() + "," + s.getEnnrolYear() + "," + s.getPhone() + "," + s.getEmail());
                }
            }

        } catch (Exception e) {
            System.out.println("Could not delete the student: " + e.getMessage());
            FileManage.map.put(studetnId, deleted);
            return false;
        }

        System.out.println("Student deleted successfully");
        return true;
    }

}