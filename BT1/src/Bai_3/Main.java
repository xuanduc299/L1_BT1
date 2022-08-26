package Bai_3;

import Bai1_2.StudentManager;

public class Main {
    public static void  main(String args[]) {
//        ThreadOne threadOne = new ThreadOne();
//        threadOne.start();

        ThreadTwo threadTwo = new ThreadTwo();
        Thread thread = new Thread(threadTwo);
        thread.start();
    }
}
