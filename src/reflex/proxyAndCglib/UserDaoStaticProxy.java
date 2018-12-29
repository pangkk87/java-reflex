package reflex.proxyAndCglib;

public class UserDaoStaticProxy  implements IUserDao{
    private IUserDao userDao;
    public UserDaoStaticProxy (IUserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("我是静态代理，启动前");
        this.userDao.save();
        System.out.println("我是静态代理，关闭前");
    }

}
