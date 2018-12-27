package reflex;

import java.lang.reflect.Constructor;

public class ConstructorDemo {
    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName("reflex.pojo.Person");

            //获得所有共有的构造方法
            System.out.println("所有公有的构造方法：");
            Constructor[] constructors = c.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println(constructors[i].toGenericString());

            }
            //获得指定参数类型的公有的构造方法
            System.out.println("获得指定参数类型的公有的构造方法：");
            Constructor constru = c.getConstructor(new Class[]{String.class,int.class});
            //参数类型为int 和 Integer 被识别为2个构造方法
            //Constructor constru = c.getConstructor(new Class[]{String.class,Integer.class});
            System.out.println(constru.toGenericString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("指定参数类型的构造方法不存在");
        }
    }
}
