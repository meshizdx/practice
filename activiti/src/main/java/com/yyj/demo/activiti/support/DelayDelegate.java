package com.yyj.demo.activiti.support;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 旷野龙腾 on 2017/2/28.
 */
@Slf4j
public class DelayDelegate implements JavaDelegate {
    public static AtomicInteger INSTANCE_COUNT = new AtomicInteger(0);

    public void execute(DelegateExecution execution) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("Activiti:{}[{}]:{}", execution.getCurrentActivityId(), execution.getCurrentActivityName(), end - begin);
    }
}
