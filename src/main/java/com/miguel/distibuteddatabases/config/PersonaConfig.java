package com.miguel.distibuteddatabases.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(/*basePackager = "com.miguel.dao" o "com.miguel.model*/entityManagerFactoryRef = "oneEntityManager")
//@EnableConfigurationProperties
public class PersonaConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "oneDataSource" /*intiMethod,destroyMethod*/)
    public DataSource oneDataSource () throws SQLException{
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl("jdbc:mysql://localhost:3306/one");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword("qwerty");
        mysqlXADataSource.setUser("root");

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("xadsone");
        return xaDataSource;
    }

    @Bean(name = "oneEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean bd2Entitymanger() throws Throwable{
        HashMap<String,Object> properties = new HashMap<String,Object>();
        properties.put("hibernate.transaction.jta.platform",AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(oneDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);            //NO DEBERIA SER LA DEL MainClass
        entityManager.setPackagesToScan("com.miguel.distibuteddatabases.model");
        entityManager.setPersistenceUnitName("onePersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }
}