package com.yest.springcloudeurekaconsumerdemo.service.hystrix;

import com.yest.springcloudeurekaconsumerdemo.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/10/23
 */
@Component
public class HelloServiceHystrix implements HelloService {

  @Override
  public String hello(String name) {
      return "hello" +name+", this messge send failed ";
  }
}
