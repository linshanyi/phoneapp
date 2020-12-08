package com.sal;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.sal")
@MapperScan(basePackages = "com.sal.**.dao")
@EnableApolloConfig
@EnableFeignClients(basePackages = "com.sal")

public class SalBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalBizApplication.class, args);
	}

}
