package com.spring.boot.base;

import com.spring.boot.base.properties.BaseProperties;
import com.spring.boot.base.properties.BasePropertiesByBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by BF100177 on 2017/5/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BaseTest {

    @Autowired
    private BaseProperties baseProperties;

    @Autowired
    private BasePropertiesByBean basePropertiesByBean;

    @Test
    public void testProperties() {
        //配置文件自定义属性注入测试
        System.out.println("userName：" + baseProperties.getUserName());
        System.out.println("password：" + baseProperties.getPassword());

        //配置文件自定义属性通过Bean注入
        System.out.println("userName：" + basePropertiesByBean.getName());
        System.out.println("password：" + basePropertiesByBean.getPassword());
    }

}
