package com.miguel.distibuteddatabases.Config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(/*basePackager = "com.miguel.dao" o "com.miguel.model*/entityManagerFactoryRef = "twoEntityManager")
//@EnableConfigurationProperties
public class DireccionConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "twoDataSource"/*, initMethod = "init", destroyMethod = "close"*/)
    public DataSource twoDataSource() {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("postgres");
        ds.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
        Properties p = new Properties();
        p.setProperty ( "user" , "postgres" );
        p.setProperty ( "password" , "qwerty" );
        p.setProperty ( "serverName" , "localhost" );
        p.setProperty ( "portNumber" , "5432" );
        p.setProperty ( "databaseName" , "two" );
        ds.setXaProperties ( p );
        return ds;
    }

    @Bean(name = "twoEntityManger")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean orderEntityManger() throws Throwable{

        HashMap<String,Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(twoDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);   //No deberia ser asi
        entityManager.setPackagesToScan("com.miguel.distibuteddatabases.Model");
        entityManager.setPersistenceUnitName("twoPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }
}
