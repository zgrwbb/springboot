package com.example.mybatismutildatasource.configuration.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * master 数据源
 *
 * @author wangbobo
 * @date 2018/7/6 14:52
 */
@Configuration
@MapperScan(basePackages = MasterDataSourceConfiguration.MASTER_PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfiguration {
    static final String MASTER_PACKAGE = "com.example.mybatismutildatasource.dao.master";
    private static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";
    @Value("${master.datasource.url}")
    private String url;
    @Value("${master.datasource.username}")
    private String username;
    @Value("${master.datasource.password}")
    private String password;
///    新的驱动程序类是`com.mysql.cj.jdbc.Driver'。 驱动程序通过SPI自动注册，通常不需要手动加载驱动程序类。
//    @Value("${master.datasource.driver-class-name}")
//    private String driverClass;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() {
        return getDataSource(url, username, password);
    }

    static DataSource getDataSource(String url, String username, String password) {
        DruidDataSource dataSource = new DruidDataSource();
///        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier(value = "masterDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(masterDataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfiguration.MAPPER_LOCATION));
        return sqlSessionFactory.getObject();
    }
}
