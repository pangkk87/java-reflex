package reflex.proxy;

import reflex.proxy.service.DinnerService;
import reflex.proxy.serviceimpl.MyDinner;
import reflex.proxy.serviceimpl.MyDinnerProxy;

public class DinnerServiceTest {

    public static void main(String[] args) {
        DinnerService service = new MyDinner();

        //service.callDinner("小明");

        MyDinnerProxy myDinnerProxy = new MyDinnerProxy();
        service = (DinnerService)myDinnerProxy.bind(service);
        service.callDinner("小明");
    }
}
