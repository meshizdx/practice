package com.yyj.demo.activiti.delegate.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateHelper;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/5/18.
 */
@Slf4j
public class DelegateExpressionBean implements JavaDelegate {
    public static AtomicInteger INSTANCE_COUNT = new AtomicInteger(0);
    private Expression someField;

    public DelegateExpressionBean() {
        INSTANCE_COUNT.incrementAndGet();
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Activiti:{}[{}]:", execution.getCurrentActivityId(), execution.getCurrentActivityName());
        log.info("Variable:{}", execution.getVariableInstances());
        String who = (String) execution.getVariable("who");
        log.info("{} say: Hello BUG!@#", who);

        Expression someField = DelegateHelper.getFieldExpression(execution, "someField");

        if (someField != null) {
            log.info("someField:{}", ((String) someField.getValue(execution)));
        }
        execution.setVariable("world", "BUG");
    }
}
