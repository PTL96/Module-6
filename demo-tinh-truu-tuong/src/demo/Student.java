package demo;

public class Student extends Person {


    public Student(String name) {
        super(name);
    }

    @Override
    public void getAll() {
        System.out.println("Abc");
    }
}
