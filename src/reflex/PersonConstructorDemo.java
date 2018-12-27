package reflex;

import java.lang.reflect.Constructor;

public class PersonConstructorDemo {
    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName("reflex.pojo.Person");

            //1 获得所有共有的构造方法
            System.out.println("所有公有的构造方法：");
            Constructor[] constructors = c.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println(constructors[i].toGenericString());

            }
            System.out.println("-------------------------------------------------------");
            //2 获得指定参数类型的公有的构造方法
            System.out.println("获得指定参数类型的公有的构造方法：");
            Constructor constru = c.getConstructor(new Class[]{String.class,int.class});
            //参数类型为int 和 Integer 被识别为2个构造方法
            //Constructor constru = c.getConstructor(new Class[]{String.class,Integer.class});
            System.out.println(constru.toGenericString());
            System.out.println("-------------------------------------------------------");

            //3 获得使用特定参数类型的构造方法-- 不限制访问级别（访问级别指的 public private 的方法修饰符）
            System.out.println("获得使用特定参数类型的构造方法：");
            Constructor constru2 = c.getDeclaredConstructor(new Class[]{int.class});
            System.out.println(constru2.toGenericString());
            System.out.println("-------------------------------------------------------");

            //4 获取所有的构造方法
            System.out.println("获取所有的构造方法：");
            Constructor[] constructorsTotal = c.getDeclaredConstructors();
            for (int i = 0; i < constructorsTotal.length; i++) {
                System.out.println(constructorsTotal[i].toGenericString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("指定参数类型的构造方法不存在");
        }
    }
}
