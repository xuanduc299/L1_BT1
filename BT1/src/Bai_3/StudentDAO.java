package Bai_3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class StudentDAO {
    private static final String STUDENT_FILE_NAME = "student.txt";

    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try{
                inputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream outputStream) {
        if (outputStream != null)
            try {
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    public void Write (Queue<Student> studentQueue) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(new File(STUDENT_FILE_NAME));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentQueue);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Queue<Student> Read() {
        Queue<Student> studentQueue = new PriorityQueue<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try{
            fileInputStream = new FileInputStream(new File(STUDENT_FILE_NAME));
            objectInputStream = new ObjectInputStream(fileInputStream);
            studentQueue = (Queue<Student>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeStream(fileInputStream);
            closeStream(objectInputStream);
        }
        return studentQueue;
    }


}
