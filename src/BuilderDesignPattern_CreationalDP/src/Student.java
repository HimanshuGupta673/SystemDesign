import java.util.List;

public class Student {
    int rollNumber;
    String name;
    int age;
    String fatherName;
    String motherName;
    List<String> subjects;

    public Student(StudentBuilder builder){
        this.rollNumber=builder.rollNumber;
        this.name=builder.name;
        this.age=builder.age;
        this.fatherName=builder.fatherName;
        this.motherName=builder.motherName;
        this.subjects=builder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
