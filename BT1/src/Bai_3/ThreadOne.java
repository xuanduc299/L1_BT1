package Bai_3;

import Bai1_2.StudentManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ThreadOne extends Thread {
    public static Scanner scanner = new Scanner(System.in);

    private StudentDAO studentDAO;
    private Queue<Student> studentQueue;

    public Queue<Student> getStudentList() {
        return studentQueue;
    }
    public void setStudentList(Queue<Student> studentList) {
        this.studentQueue = studentList;
    }

    public ThreadOne() {
        studentDAO = new StudentDAO();
        studentQueue = studentDAO.Read();
    }
    private String inputName() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Input student Email: ");
        return scanner.nextLine();
    }

    private float inputPoint() {
        System.out.print("Input student Point: ");
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
        int  id = (studentQueue.size() > 0 ) ? (studentQueue.size() + 1) : 1;
        System.out.println("student id = " + id);
        String name = inputName();
        String email = inputEmail();
        float point = inputPoint();
        Student student  = new Student(id,name,email,point);
        studentQueue.add(student);
        studentDAO.Write(studentQueue);
    }

    public void show() {
        for (Student student : studentQueue) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%10f | ", student.getPoint());
            System.out.format("%20s | ", student.getEmail());

        }
    }

    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2.Show student");
        System.out.println("3. Search by score student");
        System.out.println("4. Search by academics");
        System.out.println("5. Search by id");
        System.out.println("6. sort by academics");
        System.out.println("7. 5 academics max.");
        System.out.println("8. avg > 6.5");
        System.out.println("9.  total number student academics performance ");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public void run() {
        String choose = null;
        boolean exit = false;
        ThreadOne threadOne = new ThreadOne();
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    threadOne.add();
                    break;
                case "2":
                    threadOne.show();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
            }
        }
    }

}