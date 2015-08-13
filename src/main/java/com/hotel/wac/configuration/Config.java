package com.hotel.wac.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 * Spring configuration class
 */
@Configuration
@ComponentScan("com.hotel.wac")
@PropertySource("classpath:cache.properties")
public class Config {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @EnableWebMvc
    @Configuration
//    @ComponentScan("com.hotel.wac")
    public static class WebConfiguration extends WebMvcConfigurerAdapter {

        @Bean
        public MultipartResolver multipartResolver() {
            return new CommonsMultipartResolver();
        }

        @Bean
        public UrlBasedViewResolver setupViewResolver() {
            UrlBasedViewResolver resolver = new UrlBasedViewResolver();
            resolver.setPrefix("/views/");
            resolver.setSuffix(".jsp");
            resolver.setViewClass(JstlView.class);
            return resolver;
        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            super.configureMessageConverters(converters);

            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            converter.setObjectMapper(objectMapper);
            converters.add(converter);
        }
    }

    @EnableTransactionManagement
    @Configuration
//    @ComponentScan(value = "com.hotel.wac")
    @EnableMongoRepositories("com.hotel.wac.repository")
    public static class JpaConfiguration {

        @Bean
        public MongoClient mongoClient() throws UnknownHostException {
            return new MongoClient();
        }

        @Bean
        public MongoTemplate mongoTemplate() throws UnknownHostException {
            return new MongoTemplate(mongoClient(), "db_mongo");
        }

    }
}
