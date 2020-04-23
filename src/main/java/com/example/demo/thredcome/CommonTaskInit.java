package com.example.demo.thredcome;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Component
public class CommonTaskInit {
    private String  threadName;
    private String lantId;

     void CommonTaskInit(){
        this.lantId="891";
        this.threadName="TestBOImpl";
    }

    //@PostConstruct
    public void init() {
        CommonTaskInit();
            ExecutorService pool = Executors.newFixedThreadPool(10);
               ThreadComme threadComme= new ThreadComme(threadName,lantId);
                pool.execute(threadComme);

    }

}
