package reflex.proxy.serviceimpl;

import reflex.proxy.service.DinnerService;

public class MyDinner implements DinnerService {
    @Override
    public String callDinner(String name) {
        System.out.println(name + "  要吃饭了");
        return name+"说：”知道了“";
    }
}
