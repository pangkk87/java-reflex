package reflex;

import java.lang.reflect.Field;

public class ManFieldDmo {

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("reflex.pojo.Man");
            //获得所有的公有属性信息
            Field[] fields = c.getFields();
            System.out.println("获取所有公有属性");
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].toGenericString());
            }
            System.out.println("------------------------------------------");
            fields = c.getDeclaredFields();
            System.out.println("获取所有属性");
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].toGenericString());
            }
            System.out.println("------------------------------------------");

            //获取 指定名称的公有属性
            Field feild = c.getField("address");
            System.out.println(feild.toGenericString());
            System.out.println("------------------------------------------");

            //获取 指定名称的属性  不管私有还是公有
            Field feildEverTyoe = c.getDeclaredField("name");
            System.out.println(feildEverTyoe.toGenericString());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
