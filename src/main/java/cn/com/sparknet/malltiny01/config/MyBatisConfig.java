package cn.com.sparknet.malltiny01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"cn.com.sparknet.malltiny01.mbg.mapper","cn.com.sparknet.malltiny01.dao"})
public class MyBatisConfig {
}
