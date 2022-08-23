package EntityStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> student = new ArrayList<>();
    int n;
    public void addStudent(Student students) {
        this.student.add(students);
    }
    public void showStudent() {
        for (Student student1 : student){
            System.out.println(student1);
        }
    }
    public double avgScore() {
        int sum=0, avg;
        for(int i= 0; i< n;i++) {
            sum += student.get(i).getPoint();
        }
        return avg = sum/ n;
    }

    public String Academics(float point){
            if(point < 3 ) {
                return  "yeu";
            } else if (point >= 3 && point <5 ) {
                return  "yeu";
            }
            else if (point >= 5 && point <6.5 ) {
                return  "trung binh";
            }
            else if (point >= 6.5 && point < 7.5 ) {
                return  "kha ";
            }else if (point >= 7.5 && point <9 ) {
                return  "gioi";
            }
            else if (point >= 9 ) {
                return  "xuat sac";
            }
          return null;
    }
    //tìm kiếm học viên nhập từ khoang điểm nhập từ bàn phím
    public void sreachScore(float point) {
        for(Student student1 : student) {
            if (student1.getPoint() >= point ){
                System.out.println(student1);
            }
        }
    }
    //tìm kiếm học viên theo hoc luc nhập từ bàn phím
    public void sreachByAcademics(String hocluc) {
        for (Student student1 : student) {
            String rank = Academics(student1.getPoint());
            if (rank.equals(hocluc)) {
                System.out.println(student1);
            }
        }
    }

    public void searchIDandUpdate(int id){
        for(Student student1 : student) {
            if (student1.getId() == id ){
                System.out.println(student1);
                updateInfomation();
            }
        }
    }

    public void updateInfomation() {
        for(Student student1 : student) {
            System.out.println("Nhập id: ");

            System.out.println("Nhập name: ");

            System.out.println("Nhập point: ");

            System.out.println("Nhập email: ");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choose=0;

        do{
            System.out.println("----------------Menu------------");
            System.out.println("please select funtion");
            System.out.println("1. Add. \n" +
                                "2. Show student \n"+
                                "3. medium score student \n" +
                                "4. Search by score student \n"+
                                "5. Search by academics \n" +
                                "6. Search by id \n");
            choose = sc.nextInt();
            sc.nextLine();

            if(choose == 1){
                System.out.println("enter n list student: ");
                n = sc.nextInt();
                sc.nextLine();
                for (int i=0;i<n;i++) {
                    System.out.println("Nhập id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập name: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập point: ");
                    Float point = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Nhập email: ");
                    String email = sc.nextLine();

                    Student students = new Student(id,name,email,point);
                    addStudent(students);
                }

            }else if (choose ==2){
                showStudent();
            }else if (choose ==3){
                System.out.println("Medium score: ");
                System.out.println(avgScore());
                for (Student student1 : student) {
                    System.out.println(Academics(student1.getPoint()));
                }
            } else if (choose ==4) {
                System.out.println("Sreach score  ");
                System.out.println("Nhap score: ");
                Float point = sc.nextFloat();
                sreachScore(point);
            }else if (choose ==5) {
                System.out.println("Sreach by academics  ");
                System.out.println("Nhap hoc luc: ");
                String hocluc = sc.nextLine();
                sreachByAcademics(hocluc);
            }else if (choose ==6) {
                System.out.println("Sreach by id  ");
                System.out.println("Nhap id: ");
                int id = sc.nextInt();
                searchIDandUpdate(id);
            }

            else {
                break;
            }

        }while (choose!=10);
    }

}
