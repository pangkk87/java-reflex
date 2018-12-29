package reflex;

import reflex.pojo.Woman;

import java.lang.reflect.Array;

public class WomanInterfaceDemo{

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            //获取反射类的接口信息
            c = Class.forName("reflex.pojo.Woman");
            Class[] classes = c.getInterfaces();
            for (int i = 0; i < classes.length; i++) {
                System.out.println(classes[i].toGenericString());
            }

            System.out.println("--------------------------------");

            //获取反射类的父类信息
            Class cs = c.getSuperclass();
            System.out.println(cs.toGenericString());
            System.out.println("--------------------------------");

            Woman[] women = new Woman[]{
                    new Woman("张曼玉", 20),
                    new Woman("李冰冰", 20),
                    new Woman("黑老板", 20),

            };

            System.out.println("对象数组的长度"+ Array.getLength(women));

            Class womenClass = women.getClass();
            System.out.println("是否是数组类型"+ womenClass.isArray());
            Class temp = Woman.class;
            System.out.println("是否是数组类型"+ temp.isArray());

            //使用Array对象来遍历数组
            for (int i = 0; i < Array.getLength(women); i++) {
                System.out.println(Array.get(women,i));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
