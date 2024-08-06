package day240806;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setXxx("小红");
        student1.setAge(18);
        Student student2 = new Student("老黑", 19);
        System.out.println(student2.getXxx());
        System.out.println(student2.getAge());
    }
}
