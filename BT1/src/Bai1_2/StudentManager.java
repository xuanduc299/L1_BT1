package Bai1_2;

import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDAO studentDAO;

    public  StudentManager(){
        studentDAO = new StudentDAO();
        studentList = studentDAO.read();
    }
    private String inputName() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    private float inputPoint() {
        System.out.print("Input student name: ");
        while (true) {
            try {
                float point = Float.parseFloat((scanner.nextLine()));
                if (point < 0.0 && point > 10.0) {
                    throw new NumberFormatException();
                }
                return point;
            } catch (NumberFormatException ex) {
                System.out.println("invalid! Input student Id again: ");
            }
        }
    }


    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " + id);
        String name = inputName();
        String email = inputEmail();
        float point = inputPoint();
        Student student  = new Student(id,name,email,point);
        studentList.add(student);
        studentDAO.write(studentList);
    }

    public void show() {
        for (Student student : studentList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%10f | ", student.getPoint());
            System.out.format("%20s | ", student.getEmail());
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2.Show student");
        System.out.println("3. medium score student");
        System.out.println("4. Search by score student");
        System.out.println("5. Search by academics");
        System.out.println("6. Search by id");
        System.out.println("7. sort by academics");
        System.out.println("8. 5 academics max.");
        System.out.println("9. avg > 6.5 ");
        System.out.println("10. total number student academics performance.");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public static void Menu() {
        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.add();
                    break;
                case "2":
                    studentManager.show();
                    break;
                case  "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
            }
        }
    }
}
