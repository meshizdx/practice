package com.yyj.demo.activiti.support;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 旷野龙腾 on 2017/2/28.
 */
@Slf4j
public class DubboDelegate implements JavaDelegate, Serializable {
    public static final String VAR_DUBBO_RESULT_SUCCESS = "dubboResultSuccess";
    public static final String VAR_DUBBO_RESULT_ERROR_CODE = "dubboResultErrorCode";
    public static final String VAR_DUBBO_RESULT_ERROR_MSG = "dubboResultErrorMsg";
    public static final String VAR_DUBBO_RESULT_DATA = "dubboResultData";
    public static final String PRE_DUBBO_INDTO = "dubboInDTO_";
    public static final String PRE_DUBBO_OUTDTO = "dubboOutDTO_";
    private Expression dubbo;
    private Expression interfaceName;
    private Expression version;
    private Expression methodName;
    private Expression parameterTypes;
    private Expression parameters;
    private Expression resultVar;

    public void execute(DelegateExecution execution) throws Exception {
        try {
            String currentActivityId = execution.getCurrentActivityId();
            log.info("Activiti:{}[{}]:", currentActivityId, execution.getCurrentActivityName());
//            log.info("Variable:{}", execution.getVariableInstances());
            //历史dubbo返回值清除
            cleanDubboResult(execution);

            // 0.dummy调试
            String debugMode = (String) execution.getVariable("debug");
            if (debugMode != null && "1".equals(debugMode)) {
                execution.setVariable(VAR_DUBBO_RESULT_SUCCESS, "true");
                return;
            }
            // 1.dubbo提供者配置信息获取
            DubboServiceDTO serviceDTO = null;
//            if (dubbo != null) {
//                String dubboValue = (String) dubbo.getValue(execution);
//                serviceDTO = JSONObject.parseObject(dubboValue, DubboServiceDTO.class);
//            } else {
            // dubboServiceDto数据封装
            serviceDTO = new DubboServiceDTO();
            serviceDTO.setInterfaceName(interfaceName.getValue(execution).toString());
            serviceDTO.setVersion(version.getValue(execution).toString());
            serviceDTO.setMethodName(methodName.getValue(execution).toString());
            serviceDTO.setParameterTypes(new String[]{parameterTypes.getValue(execution).toString()});
//            }

            Map request = new HashMap();
            request.put("requestNo", UUID.randomUUID().toString().replace("-", ""));
            request.put("requestSysCode", currentActivityId.length() > 16 ? currentActivityId.substring(0, 16) : currentActivityId);
            request.put("requestTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            request.put("traceLogNo", execution.getProcessInstanceId());

            Map param = JSONObject.parseObject(parameters.getValue(execution).toString(), HashMap.class);
            request.put("param", param);
            serviceDTO.setParameters(new Object[]{request});

            // 2.dubbo调用
            // debug判别
            Object result = null;
//            if ("true".equals(isDebug)) {
//            result = JSONObject.parse("{\"success\":\"true\",\"result\":{}}");
//            } else {
            result = DubboUtil.excute(serviceDTO);
//            }

            // 调用入出参记录
            execution.setVariable(PRE_DUBBO_INDTO + execution.getCurrentActivityId(), JSONObject.toJSONString(request));
            execution.setVariable(PRE_DUBBO_OUTDTO + execution.getCurrentActivityId(), JSONObject.toJSONString(result));

            if (result != null) {// 调用成功
                //  TODO not thread safe
                Map map = (Map) result;
                execution.setVariable(VAR_DUBBO_RESULT_SUCCESS, map.get("success"));
                execution.setVariable(VAR_DUBBO_RESULT_ERROR_CODE, map.get("errorCode"));
                execution.setVariable(VAR_DUBBO_RESULT_ERROR_MSG, map.get("errorMsg"));
                execution.setVariable(VAR_DUBBO_RESULT_DATA, JSONObject.toJSONString(map.get("result")));
                // 需要保存dubbo结果的变量
                if (resultVar != null) {
                    String resultVarStr = resultVar.getValue(execution).toString();
                    execution.setVariable(resultVarStr, map.get("result"));
                }
            } else {// 调用失败
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new BpmnError("DubboExceptionOccurred");
        }
    }

    private void cleanDubboResult(DelegateExecution execution) {
        execution.setVariable(VAR_DUBBO_RESULT_SUCCESS, null);
        execution.setVariable(VAR_DUBBO_RESULT_ERROR_CODE, null);
        execution.setVariable(VAR_DUBBO_RESULT_ERROR_MSG, null);
        execution.setVariable(VAR_DUBBO_RESULT_DATA, null);
    }
}
