package demo;
abstract class Person {
   protected String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void getAll();

    public void add(){
        System.out.println("bbbbbbbbb");
    }
}
