package com.tang.Config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.MultipartConfigElement;

/**
 * @author ASUS
 * @create 2019-01-30 16:26
 */
@ImportResource("classpath:public/spring/application-tx.xml")
@Configuration
public class Root {

//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocalResolver();
//    }

    @Bean
    public ServletRegistrationBean uploadFile(){

        ServletRegistrationBean uploadFileServlet = new ServletRegistrationBean();
        uploadFileServlet.setServlet(new UploadFile());
        uploadFileServlet.addUrlMappings("/uploadFile");
        uploadFileServlet.setMultipartConfig(new MultipartConfigElement(""));

        return uploadFileServlet;
    }

}
