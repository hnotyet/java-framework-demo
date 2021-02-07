package com.yest.springcloudeurekaconsumerdemo.service;

import com.yest.springcloudeurekaconsumerdemo.service.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/10/22
 */
@FeignClient(name= "spring-cloud-eureka-producer",fallback = HelloServiceHystrix.class)
public interface HelloService {

  @RequestMapping(value = "/hello")
  public String hello(@RequestParam(value = "name") String name);
}
