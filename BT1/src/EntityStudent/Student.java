package EntityStudent;

public class Student {
    private int id;
    private String name, email;
    private float point;

    public Student(){}

    public Student(int id,String name, String email, float point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.point = point;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                '}';
    }
}
