package database;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import model.Student;

public class FileManage {

    public static HashMap<Integer, Student> map = new HashMap<>();
    

    public static void fillStudentMap() {
        try {
            File file = new File("database/students.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                // System.out.println(sc.nextLine());
                String studentInfo[] = sc.nextLine().split(",");
                // System.out.println(studentInfo[0] + " " + studentInfo[1]);

                int studetnId = Integer.parseInt(studentInfo[0]);
                String name = studentInfo[1];
                int age = Integer.parseInt(studentInfo[2]);
                String course = studentInfo[3];
                String branch = studentInfo[4];
                int ennrolYear = Integer.parseInt(studentInfo[5]);
                long phone = Long.parseLong(studentInfo[6]);
                String email = studentInfo[7];

                Student s = new Student(studetnId, name, age, course, branch, ennrolYear, phone, email);

                map.put(studetnId, s);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Cannot read from student file: " + e.getMessage());
        }
    }
    
}
