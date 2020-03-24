package com.plateer.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Lazy
@Configuration
@MapperScan(value = "com.plateer", lazyInitialization = "false")
public class MybatisConfiguration {

    private DataSource dataSource;

    public MybatisConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSession() throws Exception {
        //
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sessionFactory.setMapperLocations(resolver.getResources("classpath*:/io/namoosori/mapper/**/*.xml"));
        sessionFactory.setConfigLocation(resolver.getResource("classpath:/config/mybatis-config.xml"));
        return sessionFactory.getObject();
    }

    //트랜젝션매니저 빈 생성
    @Bean
    public DataSourceTransactionManager getTransactionManager() {
        //
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
        return manager;
    }
}
