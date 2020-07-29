package ronghaoxu.curd_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("ronghaoxu.curd_demo.mapper")
public class CurdDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurdDemoApplication.class, args);
    }

}
