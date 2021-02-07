package com.yest.springcloudeurekaconsumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudEurekaConsumerDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEurekaConsumerDemoApplication.class, args);
  }

}
