package com.nobug.qingxinjiajiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.nobug.qingxinjiajiao.mapper")
public class QingxinjiajiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QingxinjiajiaoApplication.class, args);
    }

}
