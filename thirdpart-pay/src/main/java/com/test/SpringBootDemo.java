package com.test;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by xiaofengfu on 2017/6/6.
 */
@SpringBootApplication
@EnableTransactionManagement
public class SpringBootDemo {

//    @Bean
//    public PlatformTransactionManager jdbcTransactionManager(DataSource jdbcDataSource) {
//        return new DataSourceTransactionManager(jdbcDataSource);
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootDemo.class);//.run(args);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
