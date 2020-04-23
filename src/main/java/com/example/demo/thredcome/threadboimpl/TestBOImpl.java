package com.example.demo.thredcome.threadboimpl;

import com.example.demo.thredcome.ThreadComme;
import com.example.demo.thredcome.threadbo.TestBO;
import org.springframework.stereotype.Component;

@Component
public class TestBOImpl implements TestBO {
    @Override
    public void runTask(ThreadComme threadComme) {
        System.out.println(threadComme.getThreaNmae());
    }
}
