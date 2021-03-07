package com.wt.stark.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 基础类
 *
 * @author 一贫
 * @date 2020/12/29 17:47
 */
@Configuration
public class CodeGenerator {

    @Bean(name = "generator")
    public AutoGenerator autoGenerator() {
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig());
        autoGenerator.setDataSource(dataSourceConfig());
        autoGenerator.setPackageInfo(packageConfig());
        autoGenerator.setStrategy(strategyConfig());
        autoGenerator.setTemplate(templateConfig());
        return autoGenerator;
    }

    @Bean(name = "globalConfig")
    @ConfigurationProperties(prefix = "stark.global")
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setServiceName("%sService");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setEntityName("%sDO");
        return globalConfig;
    }


    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "stark.datasource")
    public DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        return dataSourceConfig;
    }

    @Bean(name = "packageConfig")
    @ConfigurationProperties(prefix = "stark.package")
    public PackageConfig packageConfig() {
        return new PackageConfig();
    }

    @Bean(name = "strategyConfig")
    @ConfigurationProperties(prefix = "stark.strategy")
    public StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        return strategyConfig;
    }

    @Bean(name = "templateConfig")
    @ConfigurationProperties(prefix = "stark.template")
    public TemplateConfig templateConfig() {
        return new TemplateConfig();
    }
}
