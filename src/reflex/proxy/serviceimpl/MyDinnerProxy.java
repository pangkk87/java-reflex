package reflex.proxy.serviceimpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDinnerProxy implements InvocationHandler{

    //维护一个目标对象  被代理的对象
    private Object targetObject;
    public Object bind(Object target){
        this.targetObject = target;
        /**
         * 3个参数
         * 第一个参数是  类加载器（可以自定义，默认为 Application ClassLoader）
         * 第二个参数是
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    /**
     * 切面逻辑 可以是预处理方法 比如事务开始
     * 比如被代理对象使用了命令模式 则需要开启事务
     * 也可以是统计调用被代理方法的时间，作为效率参考
     */
    //可以接受参数，返回参数，但是这样对业务方法破坏性太强，不建议
    public void before(){
        System.out.println("开启事务");
    }

    public void after(){
        System.out.println("关闭事务");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        before();

        result = method.invoke(this.targetObject,args);

        after();
        return result;
    }
}
