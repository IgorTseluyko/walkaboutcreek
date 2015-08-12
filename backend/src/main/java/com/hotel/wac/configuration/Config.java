package com.hotel.wac.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 * Spring configuration class
 */
@Configuration
public class Config {

    @EnableWebMvc
    @Configuration
    @ComponentScan("com.hotel.wac.controller")
    public static class WebConfiguration extends WebMvcConfigurerAdapter {

        @Bean
        public MultipartResolver multipartResolver() {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
            multipartResolver.setMaxUploadSize(500000000);
            multipartResolver.setMaxInMemorySize(500000000);
            return multipartResolver;
        }

        @Bean
        public UrlBasedViewResolver setupViewResolver() {
            UrlBasedViewResolver resolver = new UrlBasedViewResolver();
            resolver.setPrefix("/pages/");
            resolver.setSuffix(".jsp");
            resolver.setViewClass(JstlView.class);
            return resolver;
        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            super.configureMessageConverters(converters);

            final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            converter.setObjectMapper(objectMapper);
            converters.add(converter);
        }
    }


    @EnableTransactionManagement
    @Configuration
    @PropertySource("classpath:database.properties")
    @ComponentScan("com.hotel.wac.repository")
    @EnableJpaRepositories("com.hotel.wac.repository")
    public static class JpaConfiguration {

        @Value("${postgres.driver}") private String driver;
        @Value("${postgres.url}") private String url;
        @Value("${postgres.user}") private String user;
        @Value("${postgres.password}") private String password;
        @Value("${hibernate.dialect}") private String dialect;
        @Value("${hibernate.hbm2ddl.auto}") private String hbm2ddl;
        @Value("${connection_pool_size}") private String poolSize;
        @Value("${hibernate.default_schema}") private String defaultSchema;
        @Value("${hibernate.temp.use_jdbc_metadata_defaults}") private String jdbcMetadataDefaults;
        @Value("${hibernate.show_sql}") private String showSql;
        @Value("${hibernate.format_sql}") private String formatSql;
        @Value("${hibernate.use_sql_comments}") private String sqlComments;

        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
            return new PropertySourcesPlaceholderConfigurer();
        }

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            return dataSource;
        }

        @Bean
        public EntityManagerFactory entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource());
            factoryBean.setPackagesToScan("com.hotel.wac.entity");
            factoryBean.setJpaProperties(getJpaProperties());
            factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            factoryBean.afterPropertiesSet();
            return factoryBean.getObject();
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new JpaTransactionManager(entityManagerFactory());
        }

        private Properties getJpaProperties() {
            Properties jpaProperties = new Properties();
            jpaProperties.setProperty("hibernate.show_sql", showSql);
            jpaProperties.setProperty("hibernate.format_sql", formatSql);
            jpaProperties.setProperty("hibernate.use_sql_comments", sqlComments);
            jpaProperties.setProperty("hibernate.dialect", dialect);
            jpaProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
            jpaProperties.setProperty("connection_pool_size", poolSize);
            jpaProperties.setProperty("hibernate.default_schema", defaultSchema);
            jpaProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", jdbcMetadataDefaults);
            return jpaProperties;
        }
    }

}
