package com.yyj.activiti.support;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18.
 */
/*
   .--,       .--,
 ( (  \.---./  ) )
  '.__/o   o\__.'
     {=  ^  =}
      >  -  <
     /       \
    //       \\
   //|   .   |\\
   "'\       /'"_.-~^`'-.
      \  _  /--'         `
    ___)( )(___
   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。

*/
@Slf4j
public class HelloDubboTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void processTest01() {
        // 创建流程引擎，使用内存数据库
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 部署流程定义文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("deployment/HelloDubbo.bpmn20.xml").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
        log.info("ProcessDefinitionId:" + processDefinition.getId());
        log.info("ProcessDefinitionName:" + processDefinition.getName());
        log.info("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());

        // 启动流程并返回流程实例
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("dummyResult", "success");
//        variables.put("dubbo", "{\"interfaceName\":\"com.yyj.demo.facade.UserInfoService\",\"version\":\"1.0.0\",\"methodName\":\"updateUserInfo\",\"parameterTypes\":[\"com.yyj.demo.facade.indto.UpdateUserInfoInDTO\"],\"parameters\":[{\"id\":\"666\",\"accountName\":\"yyj0501\",\"loginPassword\":\"baofoo123\"}]}");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloDubbo", variables);

        // 查询已启动的流程 Verify that we started a new process instance
        log.info("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
        log.info("Instances ProcessDefinitionId: " + processInstance.getProcessDefinitionId());

    }
}
