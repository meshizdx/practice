package com.yyj.demo.activiti.delegate.helloworld;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;

/**
 * Created by 旷野龙腾 on 2017/2/28.
 */
@Slf4j
@Data
public class POJOExpressionBean {

    private String mode = "debug~";

    public String printMessage() throws Exception {
        log.info("PrinterBean.printMessage()");
        return "done";
    }

    public void printMessage(DelegateExecution execution, String var) throws Exception {
        log.info("Activiti:{}[{}]:", execution.getCurrentActivityId(), execution.getCurrentActivityName());
        log.info("Variable:{}", execution.getVariableInstances());
        log.info("PrinterBean.printMessage(DelegateExecution,{})", var);
//        execution.setVariable("input", var);
    }
}
