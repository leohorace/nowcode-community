package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

//配置类，配置第三方bean，装配到容器
@Configuration
public class AlphaConfig {
    @Bean
    //方法名就是bean的名字,这个方法返回的对象将被装配到容器里
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
