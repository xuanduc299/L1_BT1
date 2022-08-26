package Bai1_2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    private StudentDAO studentDAO;

    public enum enum_Academics {
        POOR,BELOW_AVERAGE,AVERAGE ,GOOD, EXCELLENT;

    }
    public String Academics(float point){
        if(point < 3 ) {
            System.out.println(enum_Academics.POOR);
        } else if (point >= 3 && point <5 ) {
            System.out.println(enum_Academics.POOR);
        }
        else if (point >= 5 && point <6.5 ) {
            System.out.println(enum_Academics.BELOW_AVERAGE);
        }
        else if (point >= 6.5 && point < 7.5 ) {
            System.out.println(enum_Academics.AVERAGE);
        }else if (point >= 7.5 && point <9 ) {
            System.out.println(enum_Academics.GOOD);
        }
        else if (point >= 9 ) {
            System.out.println(enum_Academics.EXCELLENT);
        }
        return null;
    }

    public  StudentManager(){
        studentDAO = new StudentDAO();
        studentList = studentDAO.read();
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

//1
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
//2
    public void show() {
        for (Student student : studentList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%10f | ", student.getPoint());
            System.out.format("%20s | ", student.getEmail());
            Academics(student.getPoint());
        }
    }
//tìm kiếm học viên nhập từ khoang điểm nhập từ bàn phím
    public void sreachScore(float point) {
        for (Student student : studentList) {
            if(student.getPoint() >= point) {
                System.out.println(student);
            }
        }
    }
    //tìm kiếm học viên theo hoc luc nhập từ bàn phím
    public void sreachByAcademics(String rank){
        for (enum_Academics enum_academics : enum_Academics.values()) {
            for(Student student : studentList) {
                if (enum_academics.toString().equals(rank)) {
                    System.out.println(student);
                }
            }
        }
    }

    public void searchIDandUpdate(int id){
        for (Student student : studentList){
            if (student.getId() == id) {
                System.out.println(student);
                updateInfomation();
            }
        }
    }

    public void updateInfomation() {
        for (Student student : studentList) {
            System.out.println("Nhập id: ");
            student.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Nhập name: ");
            student.setName(scanner.nextLine());
            System.out.println("Nhập point: ");
            student.setPoint(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Nhập email: ");
            student.setEmail(scanner.nextLine());
        }
    }
    //sap xep hoc vien theo diem
    public void sortAcademics(){
        Collections.sort(this.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if(student1.getPoint() < student2.getPoint()){
                    return 1;
                } else if (student1.getPoint() > student2.getPoint()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
    }
    //xuat 5 hoc vien diem cao nhat
    public void fiveAcademicsMax() {
        Collections.sort(this.studentList,(a,b)-> (int) (b.getPoint()-a.getPoint()));
        for (int i=0; i < 5 && i < studentList.size(); i++){
            System.out.println(studentList.get(i).getPoint());
        }
    }
    //avg > 6.5
    public void avgAcademics(){
        for(Student student : studentList){
            if(student.getPoint() >= 6.5) {
                System.out.println(student);
            }
        }
    }
    //Tổng hợp số học viên theo học lực
    public void totolAcademics(){
        for(Student student : studentList){
            String rank = Academics(student.getPoint());
            if (rank.equals("POOR")) {
                System.out.println("POOR " + student);
            }
            if (rank.equals("BELOW_AVERAGE")) {
                System.out.println("BELOW_AVERAGE " + student);
            }
            if (rank.equals("AVERAGE")) {
                System.out.println("AVERAGE " +  student);
            }
            if (rank.equals("GOOD")) {
                System.out.println("GOOD " + student);
            }
            if (rank.equals("EXCELLENT")) {
                System.out.println("EXCELLENT" + student);
            }
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
                case "3":
                    System.out.println("Sreach score  ");
                    System.out.println("Nhap score: ");
                    float point = scanner.nextFloat();
                    studentManager.sreachScore(point);
                    break;
                case "4":
                    System.out.println("Sreach by academics  ");
                    System.out.println("Nhap hoc luc: ");
                    String rank = scanner.nextLine();
                    studentManager.sreachByAcademics(rank);
                    break;
                case "5":
                    System.out.println("Sreach by id  ");
                    System.out.println("Nhap id: ");
                    int id = scanner.nextInt();
                    studentManager.searchIDandUpdate(id);
                    break;
                case "6":
                    System.out.println("Sort Academics  ");
                    studentManager.sortAcademics();
                    studentManager.show();
                    break;
                case "7":
                    System.out.println("5 academics max ");
                    studentManager.fiveAcademicsMax();
                    break;
                case "8":
                    System.out.println("avg > 6.5  ");
                    studentManager.avgAcademics();
                case "9":
                    System.out.println("totol academics  ");
                    studentManager.totolAcademics();

                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
            }
        }
    }
}
