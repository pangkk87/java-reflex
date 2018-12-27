package reflex.pojo;

public class Man {

    private String name;
    private int age;
    public String address;
    double salary; //工资

    public void sayHi(){
        System.out.println("hello  black boss");
    }

    public void sayHi(String name,int i){
        System.out.println("hello  black boss" + name +"再来一个参数" + i);
    }

    private void haha(){
        System.out.println("笑死我了！");
    }

    public Man(){

    }

    public Man(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Man(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    Man(String name){
        this.name = name;
    }

    private Man(int age){
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
        return "姓名："+this.getName()+"  年龄："+this.getAge();
    }
}
