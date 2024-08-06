package day240806;

public class Student {
    //state
    String name;
    int age;

    //constructor
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    //behavior

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
