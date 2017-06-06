package com.yyj.demo.activiti.support;

import lombok.Data;

@Data
public class DubboServiceDTO {
    private String interfaceName;
    private String version;
    private String methodName;
    private String[] parameterTypes;
    private Object[] parameters;
}
