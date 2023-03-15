package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Creating Singleton Bean !!!!!!");
    }

    public String getMyScope(){
        return "This a is a Singleton Bean";
    }
}
