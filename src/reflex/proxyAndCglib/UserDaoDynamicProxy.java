package reflex.proxyAndCglib;

//给所有的dao创建动态代理对象

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoDynamicProxy {
    //维护一个目标对象
    private Object targetObject;
    public UserDaoDynamicProxy(Object target){
        this.targetObject = target;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        // TODO Auto-generated method stub
                        System.out.println("我是动态代理，开启事务");

                        //执行目标对象方法
                        Object returnValue = method.invoke(targetObject, args);

                        System.out.println("我是动态代理，关闭事务");
                        return returnValue;
                    }
                });
    }
}
