package com.yyj.activiti.support;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:activiti.spring.xml")
public class HelloWorldSpringTest {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

//    @Autowired
//    @Rule
//    public ActivitiRule activitiSpringRule = new ActivitiRule();;

    @Test
//    @Deployment(resources = {"deployment/auto/HelloWorldSpring.bpmn20.xml"})
    public void simpleProcessTest1() {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("who", "YYJ");
        variables.put("input", "12");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloSpringWorld", variables);
    }

    @Test
    @Deployment
    public void simpleProcessTest() {

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("tradeNo", "1234567890");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simpleProcess", variables);
    }

    @Test
    public void deploy() {
        /*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring-activiti.xml");
        RepositoryService repositoryService =
                (RepositoryService) applicationContext.getBean("repositoryService");*/
        String deploymentId = repositoryService
                .createDeployment()
                .addClasspathResource("deployment/auto/SimpleProcess.bpmn20.xml")
                .deploy()
                .getId();
        System.out.println(deploymentId);
    }
}
