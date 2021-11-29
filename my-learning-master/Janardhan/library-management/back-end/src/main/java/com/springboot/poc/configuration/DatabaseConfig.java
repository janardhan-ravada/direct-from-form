package com.springboot.poc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application-sql.properties")
@PropertySource("classpath:application-postgres.properties")
@PropertySource("classpath:application-h2.properties")
public class DatabaseConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Configuration
    @Profile("sql")
    public static class SQLDataSourceConfiguration {
        @Value("${sql.db.driver}")
        private String DB_DRIVER;

        @Value("${sql.db.password}")
        private String DB_PASSWORD;

        @Value("${sql.db.url}")
        private String DB_URL;

        @Value("${sql.db.username}")
        private String DB_USERNAME;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(DB_DRIVER);
            dataSource.setUrl(DB_URL);
            dataSource.setUsername(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);
            return dataSource;
        }
    }

    @Configuration
    @Profile("postgres")
    public static class PostGresDataSourceConfiguration {
        @Value("${postgres.db.driver}")
        private String DB_DRIVER;

        @Value("${postgres.db.password}")
        private String DB_PASSWORD;

        @Value("${postgres.db.url}")
        private String DB_URL;

        @Value("${postgres.db.username}")
        private String DB_USERNAME;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(DB_DRIVER);
            dataSource.setUrl(DB_URL);
            dataSource.setUsername(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);
            return dataSource;
        }
    }

    @Configuration
    @Profile("h2")
    public static class H2DataSourceConfiguration {
        @Value("${h2.db.datasourceClassName}")
        private String DB_DRIVER;

        @Value("${h2.db.password}")
        private String DB_PASSWORD;

        @Value("${h2.db.url}")
        private String DB_URL;

        @Value("${h2.db.user}")
        private String DB_USERNAME;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(DB_DRIVER);
            dataSource.setUrl(DB_URL);
            dataSource.setUsername(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);
            return dataSource;

        }
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect",
                "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto",
                HIBERNATE_HBM2DDL_AUTO);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
