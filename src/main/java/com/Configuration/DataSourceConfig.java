package com.Configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {
    /**
     * configured as connection pool
     * @return
     */
    @Profile("dev")
    @Bean
    public BasicDataSource basicDataSourceDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://127.0.0.1:5432/Blog");
        ds.setUsername("Blog");
        ds.setPassword("Blog");
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        return ds;
    }

//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//        emfb.setPersistenceUnitName("WebServicePU");
//        return emfb;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
//        emfb.setDataSource(dataSource);
//        emfb.setJpaVendorAdapter(jpaVendorAdapter);
//        return emfb;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.POSTGRESQL);
//        adapter.setShowSql(true);
//        adapter.setGenerateDdl(false);
//        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
//        return adapter;
//    }


}
