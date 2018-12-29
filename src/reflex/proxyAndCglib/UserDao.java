package reflex.proxyAndCglib;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("我是原始方法，不要改变我哈");
    }

}
