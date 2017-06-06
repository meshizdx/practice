package com.spring.boot.mybatis.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by BF100177 on 2017/5/26.
 */
@Configuration
public class DatasourceConfiguration {

    @Bean(name = "dataSource")
    // @Qualifier使用 @Autowired 注释进行自动注入时，Spring 容器中匹配的候选 Bean 数目必须有且仅有一个
    @Qualifier(value = "dataSource")
    // @Primary 多实现类时 Spring在注入时优先选择
    @Primary
    // @ConfigurationProperties 将配置文件属性 与Bean中属性关联
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //设置c3p0数据源
        sqlSessionFactory.setDataSource(dataSource());
        //设置Mapper文件扫描路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/sql/*Mapper.xml"));
        return sqlSessionFactory;
    }

}
