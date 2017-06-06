package com.yyj.demo.activiti.support;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 旷野龙腾 on 2017/2/28.
 */
@Slf4j
public class SimpleDelegate implements JavaDelegate {
    public static AtomicInteger INSTANCE_COUNT = new AtomicInteger(0);
    private Expression text1;
    private Expression text2;
    private Expression text3;

    public void execute(DelegateExecution execution) throws Exception {
        log.info("Activiti:{}[{}]:", execution.getCurrentActivityId(), execution.getCurrentActivityName());
//        log.info("Variable:{}", execution.getVariableInstances());
        try {
            Expression text1 = DelegateHelper.getFieldExpression(execution, "text1");
            Expression text2 = DelegateHelper.getFieldExpression(execution, "text2");
            Expression text3 = DelegateHelper.getFieldExpression(execution, "text3");
            if (text1 != null && text2 != null && text3 != null) {
                log.info("text1:{}", ((String) text1.getValue(execution)));
                log.info("text2:{}", ((String) text2.getValue(execution)));
                log.info("text3:{}", ((String) text3.getValue(execution)));
            }
            execution.setVariable("DelegateResult", INSTANCE_COUNT.incrementAndGet());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BpmnError("BusinessExceptionOccurred");
        }
    }
}
