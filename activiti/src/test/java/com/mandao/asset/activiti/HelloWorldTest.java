package com.mandao.asset.activiti;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18.
 */
@Slf4j
public class HelloWorldTest {
    @Test
    public void processTest01() {
        // 创建流程引擎，使用内存数据库
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 部署流程定义文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("process/HelloWorld.bpmn20.xml").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
        log.info("ProcessDefinitionId:" + processDefinition.getId());
        log.info("ProcessDefinitionName:" + processDefinition.getName());
        log.info("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());

        // 启动流程并返回流程实例
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("who", "YYJ");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloworld", variables);

        // 查询已启动的流程 Verify that we started a new process instance
        log.info("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
        log.info("Instances ProcessDefinitionId: " + processInstance.getProcessDefinitionId());

    }
}
