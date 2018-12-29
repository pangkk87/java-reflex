package reflex.proxyAndCglib;

import java.lang.reflect.Method;

public class UserDaoCglibProxy implements MethodInterceptor{
    //维护目标对象
    private Object targetObject;
    public UserDaoCglibProxy(Object target){
        this.targetObject = target;
    }

    //给目标对象创建代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(targetObject.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy arg3) throws Throwable {
        System.out.println("我是CGLIB代理对象，启动事务");
        Object returnValueObject = method.invoke(targetObject, args);
        System.out.println("我是CGLIB代理对象，关闭事务");
        return returnValueObject;
    }


}