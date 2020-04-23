package com.example.demo.thredcome;

import com.example.demo.thredcome.threadbo.TestBO;
import com.example.demo.thredcome.threadbo.ThreadCommonBO;
import com.example.demo.utils.SpringContextUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.scheduling.support.SimpleTriggerContext;

public class ThreadComme extends Thread {
    private String threaNmae;
    private String lantId;

    public String getThreaNmae() {
        return threaNmae;
    }

    public void setThreaNmae(String threaNmae) {
        this.threaNmae = threaNmae;
    }

    public String getLantId() {
        return lantId;
    }

    public void setLantId(String lantId) {
        this.lantId = lantId;
    }

    public ThreadComme(String threaNmae, String lantId) {
        this.threaNmae = threaNmae;
        this.lantId = lantId;
    }

    public void run(){
        ThreadCommonBO threadCommonBO= null;
        if ("TestBOImpl".equals(threaNmae)) {
            threadCommonBO= (TestBO) SpringContextUtils.getBean("testBOImpl");
        }
        while (true){
            if (threadCommonBO != null) {
                threadCommonBO.runTask(this);
            }
        }

    }
}
