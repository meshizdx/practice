package com.yyj.demo.activiti.delegate.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.*;

/**
 * Created by 旷野龙腾 on 2017/2/28.
 */
@Slf4j
public class ClassDelegate implements JavaDelegate {
    private Expression text1;
    private Expression text2;
    private Expression text3;

    public void execute(DelegateExecution execution) throws Exception {
        log.info("Activiti:{}[{}]:", execution.getCurrentActivityId(), execution.getCurrentActivityName());
        log.info("Variable:{}", execution.getVariableInstances());
        try {

            String who = (String) execution.getVariable("who");
            log.info("{} say: Hello World!", who);
            Expression text1 = DelegateHelper.getFieldExpression(execution, "text1");
            Expression text2 = DelegateHelper.getFieldExpression(execution, "text2");
            Expression text3 = DelegateHelper.getFieldExpression(execution, "text3");
            if (text1 != null && text2 != null && text3 != null) {
                log.info("text1:{}", ((String) text1.getValue(execution)));
                log.info("text2:{}", ((String) text2.getValue(execution)));
                log.info("text3:{}", ((String) text3.getValue(execution)));
            }
            execution.setVariable("world", "earth");
//        execution.setVariable("var", ((String)text.getValue(execution)).toUpperCase());
            String e = null;
            e.length();
        } catch (Exception e) {
            throw new BpmnError("BusinessExceptionOccurred");
        }
    }
}
