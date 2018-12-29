package reflex.proxyAndCglib;

public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IUserDao userDao = new UserDao();
        //静态代理对象
//      1）可以做到在不修改目标对象的功能前提下，对目标对象功能扩展。
//      2）缺点：
//          --》  因为代理对象，需要与目标对象实现一样的接口。所以会有很多代理类，类太多。
//          --》  一旦接口增加方法，目标对象与代理对象都要维护。
        UserDaoStaticProxy proxy = new UserDaoStaticProxy(userDao);
        proxy.save();

        System.out.println("\n------------------------\n");
        //动态代理对象
//      1）代理对象，不需要实现接口；
//      2）代理对象的生成，是利用JDKAPI， 动态的在内存中构建代理对象(需要我们指定创建 代理对象/目标对象 实现的接口的类型；);
//      3)  动态代理， JDK代理， 接口代理；
//      代理对象不需要实现接口，但是目标对象一定要实现接口；否则不能用动态代理！
//      static Object newProxyInstance(
//              ClassLoader loader,       指定当前目标对象使用类加载器
//               Class<?>[] interfaces,     目标对象实现的接口的类型
//              InvocationHandler h       事件处理器
//              )
        IUserDao userDao2 = (IUserDao) new UserDaoDynamicProxy(userDao).getProxyInstance();
        userDao2.save();

        System.out.println("\n------------------------\n");
        //Cglib代理，也叫做子类代理。在内存中构建一个子类对象从而实现对目标对象功能的扩展。
//      JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。如果想代理没有实现接口的类，就可以使用CGLIB实现。
//      1) 需要引入cglib – jar文件， 但是spring的核心包中已经包括了cglib功能，所以直接引入spring-core-3.2.5.jar即可。
//      2）引入功能包后，就可以在内存中动态构建子类
//      3）代理的类不能为final， 否则报错。
//      4） 目标对象的方法如果为final/static, 那么就不会被拦截，即不会执行目标对象额外的业务方法
        IUserDao userDao3 = (IUserDao) new UserDaoCglibProxy(userDao).getProxyInstance();
        userDao3.save();
        //总结
//      在Spring的AOP编程中，
//      如果加入容器的目标对象有实现接口，用JDK代理；
//      如果目标对象没有实现接口，用Cglib代理；

    }

}
