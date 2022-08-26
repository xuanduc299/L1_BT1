package Bai_3;

import Bai1_2.Student;

import java.util.Queue;

public class ThreadTwo implements Runnable {

    private StudentDAO studentDAO;
    private Queue<Student> studentQueue;

    public Queue<Student> getStudentList() {
        return studentQueue;
    }
    public void setStudentList(Queue<Student> studentList) {
        this.studentQueue = studentList;
    }

    @Override
    public void run() {
        int count = 10;
        for (int i = count; i > 0; i--) {
            for (Student student : studentQueue) {
                System.out.format("%5d | ", student.getId());
                System.out.format("%20s | ", student.getName());
                System.out.format("%10f | ", student.getPoint());
                System.out.format("%20s | ", student.getEmail());
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Hết giờ");
    }
}
