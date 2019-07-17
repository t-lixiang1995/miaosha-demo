package com.pcitc.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.pcitc"})//开启注解扫描
@MapperScan("com.pcitc.seckill.dao")
@EnableCaching
public class SeckillApplication {


	public static void main(String[] args) {
		SpringApplication.run(SeckillApplication.class, args);
	}
}
