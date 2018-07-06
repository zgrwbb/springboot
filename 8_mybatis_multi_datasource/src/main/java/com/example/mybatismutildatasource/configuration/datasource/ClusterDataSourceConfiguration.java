package com.example.mybatismutildatasource.configuration.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import static com.example.mybatismutildatasource.configuration.datasource.MasterDataSourceConfiguration.getDataSource;


/**
 * cluster 数据源
 * MapperScan 接口并容器管理
 * basePackages 精确到cluster 和其他数据源隔离
 *
 * @author wangbobo
 * @date 2018/7/6 14:52
 */
@Configuration
@MapperScan(basePackages = ClusterDataSourceConfiguration.CLUSTER_PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfiguration {
    static final String CLUSTER_PACKAGE = "com.example.mybatismutildatasource.dao.cluster";
    private static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

    @Value("${cluster.datasource.url}")
    private String url;
    @Value("${cluster.datasource.username}")
    private String username;
    @Value("${cluster.datasource.password}")
    private String password;
/// 新的驱动程序类是`com.mysql.cj.jdbc.Driver'。 驱动程序通过SPI自动注册，通常不需要手动加载驱动程序类。
//    @Value("${cluster.datasource.driver-class-name}")
//    private String driverClass;

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
        return getDataSource(url, username, password);
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier(value = "clusterDataSource") DataSource clusterDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(clusterDataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfiguration.MAPPER_LOCATION));
        return sqlSessionFactory.getObject();
    }
}
