package reflex;

import reflex.pojo.Man;

import java.lang.reflect.Method;

public class ManMethodDemo {

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("reflex.pojo.Man");
            //获得所有的公有的方法   包括了从父类或借口集成过来的公有方法
            Method[] method = c.getMethods();
            for (int i = 0; i < method.length; i++) {
                System.out.println(method[i].toGenericString());
            }

            System.out.println("---------------------------------------------------");
            //获取该类的所有方法，不管私有还是公有，但不包括上级的方法
            Method[] methodsTatol = c.getDeclaredMethods();
            for (int i = 0; i < methodsTatol.length; i++) {
                System.out.println(methodsTatol[i].toGenericString());
            }

            System.out.println("---------------------------------------------------");
            //获取指定参数的公有方法
            Method m = c.getMethod("sayHi",new Class[]{});
            System.out.println(m.toGenericString());

            System.out.println("---------------------------------------------------");
            //获取指定参数的方法 不限公有私有
            Method mt = c.getDeclaredMethod("haha",new Class[]{});
            System.out.println(mt.toGenericString());


            //方法调用
            Man man = (Man) c.newInstance();

            /**
             * Java反射机制调用私有方法，是不是破坏了Java的封装性？
             　　答案是否定的。要探讨这个问题，就必须要知道什么是封装性，什么是安全？

             　　封装，是将具体的实现细节隐藏，而把功能作为整体提供给类的外部使用，也就是说，
                公有方法能够完成类所具有的功能。当别人使用这个类时，如果通过反射直接调用私有方法，
                可能根本实现不了类的功能，甚至可能会出错，因此通过反射调用私有方法可以说是没有任何用处的，
                开发人员没有必要故意去破坏封装好的类。从这点上看，封装性并没有被破坏。

             　　安全，如果意思是保护实现源码不被别人看见，那没有作用。不用反射也能轻易获取源码。

             　　我以为反射机制只是提供了一种强大的功能，使得开发者能在封装之外，按照特定的需要实现一些功能。

             　　Java语言是一个严谨的编程语言，语言本身是静态的。为了能让语言具有动态编程的特性，必须要有反射机制。
                而反射机制本身就是底层的处理，不可能按表层的封转特性来处理。也就是说不给调用私有方法的能力，很多程序受到局限，
                那么实现起来就麻烦了。
             　　举一个生活的例子，你家的电视机是要由外壳的，目的是不让普通人接触到电视中的电路。
                那么Java语言的基本面向对象特征正是这个层次的应用。也就是对于普通程序员的程序，
                是通过遥控器来操作电视的。但是，如果你是一个专业的电工的话，那么可以打开电视机的后盖，
                调整电视中的电路和结构，甚至如果是电工的话，那么调台可能都不使用遥控器，而是通过调整内部电路的电阻的阻值来实现。
                Java中的反射机制正是提供更高要求的编程来使用的，不需要考虑基本面向对象的特征，而是要考虑能否得到和控制代码中的一切，
                这样反射机制编程才有意义。
             */
            //将方法的accessible属性设置为true，则可以在类外调用该类的私有方法！！！
            mt.setAccessible(true);
            //注意，因为haha方法为私有的，所以只能在本类中调用
            mt.invoke(man,null);

            //调用带参数的方法
            Method m_sayHi = c.getMethod("sayHi", String.class, int.class);
            m_sayHi.invoke(man,"    black boss",2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
