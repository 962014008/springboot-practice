package cn.stackbox.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.stackbox.demo.mapper")
public class DbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbaApplication.class, args);
	}
}
