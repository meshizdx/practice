package com.yyj.activiti.support;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/24.
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
public class HelloWorldTest {

    @Test
    public void processTest01() {
        // 创建流程引擎，使用内存数据库
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 部署流程定义文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("deployment/HelloWorld.bpmn20.xml").deploy();
        log.info("Number of process definitions:" + repositoryService.createProcessDefinitionQuery().count());

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
        log.info("ProcessDefinitionId:" + processDefinition.getId());
        log.info("ProcessDefinitionName:" + processDefinition.getName());

        // 启动流程并返回流程实例
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("input", "sth");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloWorld", variables);

        // 查询已启动的流程 Verify that we started a new process instance
        log.info("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
        log.info("Instances ProcessDefinitionId: " + processInstance.getProcessDefinitionId());

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskUnassigned().list();
        for (Task task : tasks) {
            log.info("Task:{}:{}", task.getAssignee(), task.getName());
            if (task.getAssignee() == null) {
                taskService.claim(task.getId(), "kermit");
            }
        }
//        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        List<Task> tasks1 = taskService.createTaskQuery().taskCandidateOrAssigned("kermit").list();
        for (Task task : tasks) {
            log.info("Task:{}:{}", task.getAssignee(), task.getName());
            Map<String, Object> taskVariables = new HashMap<String, Object>();
            taskVariables.put("target", "world1");
            taskService.complete(task.getId(), taskVariables);
        }
    }

    @Test
    public void processTest02() {

    }
}
