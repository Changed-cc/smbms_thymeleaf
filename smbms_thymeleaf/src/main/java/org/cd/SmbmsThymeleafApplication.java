package org.cd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("org.cd.dao")
@SpringBootApplication
public class SmbmsThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmbmsThymeleafApplication.class, args);
    }

}
