package reflex;

import reflex.pojo.Person;

public class reflex {

    public static void main(String[] args) {
        Class<?> c1 =null;
        Class<?> c2 =null;
        Class<?> c3 =null;
        Class<?> c4 =null;

        //方法一 使用对象的getClass（）
        Person p = new Person();
        c1 = p.getClass();

        //方法二 使用 Class.forName()
        try {
            c2 = Class.forName("reflex.pojo.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方法三 使用.class
        c3 = Person.class;

        //方法四 如果JAVA封装类型，使用TYPE语法
        c4 = Integer.TYPE;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c4.getName());

    }
}
