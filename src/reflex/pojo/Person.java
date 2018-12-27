package reflex.pojo;

public class Person {

    private String name;

    private int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    Person(String name){
        this.name = name;
    }

    private Person(int age){
        this.age = age;
    }

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

    public String toString(){
        return "姓名："+this.getName()+"年龄："+this.getAge();
    }
}
