/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.meroapp;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lfa.meroapp")
public class AppConfigurer  extends WebMvcConfigurerAdapter{
    
    @Bean
    public InternalResourceViewResolver viewResolver(){
       return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }
    
    @Bean
    public DataSource dataSource(){
        String url="jdbc:postgresql://ec2-54-235-252-23.compute-1.amazonaws.com/d2jm4thob2s9r8?sslmode=require";
        String user="pnpcqzihuppvtw";
        String password="9bde4a734ef825713836085b6537fdc95b6a6f54592ee7ba4839ef57775b59fe";
        return new DriverManagerDataSource(url, user, password);
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    
}
