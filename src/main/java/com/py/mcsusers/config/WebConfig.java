package com.py.mcsusers.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan("com.py.mcsusers")
public class WebConfig implements WebMvcConfigurer {
    @Primary
    @Bean(name = "dataSourcePropertiesPrimary")
    public DataSourceProperties stlmDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Primary
    @Bean(name = "datasourcepostgres")
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        return stlmDataSourceProperties().initializeDataSourceBuilder().build();
    }

//    @Override
//    public void addInterceptors(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars");
//    }
}
