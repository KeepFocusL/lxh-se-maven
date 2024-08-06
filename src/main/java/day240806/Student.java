package day240806;

public class Student {
    //state
    String name;
    int age;

    //constructor
    public Student() {
    }

    public Student(String newName, int age) {
        this.name = newName;
        this.age = age;

    }

    //behavior

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
