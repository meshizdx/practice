package com.mandao.asset.activiti;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by Administrator on 2017/5/18.
 */
@Slf4j
public class MyJavaDelegate implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        String var = (String) execution.getVariable("who");
        log.info("{} say: Hello {}!", var, "YYJ".equals(var) ? "World" : "Hell");
        execution.setVariable("cansay", "YYJ".equals(var) ? true : false);
    }
}
