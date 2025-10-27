package cn.zzuli.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("cn.zzuli.mapper")
@Configuration
public class MybatisPlusConfiguration {
}
