package reflex;

import reflex.pojo.Person;

import java.lang.reflect.Constructor;

public class PersonDynamicInstanceDemo {

    public static void main(String[] args) {
        Class<?> c = null;

        try {
            c = Class.forName("reflex.pojo.Person");
            Constructor constructor = c.getConstructor(new Class[]{String.class,int.class});
            //使用反射机制，动态实例化对象
            Person p = (Person) constructor.newInstance("黑老板",31);
            System.out.println(p);
            System.out.println(p.getAge());
            System.out.println(p.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
