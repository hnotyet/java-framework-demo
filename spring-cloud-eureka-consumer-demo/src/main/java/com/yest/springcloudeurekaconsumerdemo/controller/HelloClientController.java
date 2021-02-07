package com.yest.springcloudeurekaconsumerdemo.controller;

import com.yest.springcloudeurekaconsumerdemo.service.HelloService;
import javax.annotation.Resource;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/10/22
 */
@RestController
public class HelloClientController {


  @Resource
  private HelloService helloService;

  @RequestMapping("/hello/{name}")
  public String index(@PathVariable("name") String name) {
    return helloService.hello(name);
  }

  @RequestMapping("/hello2/{name}")
  public String index2(@PathVariable("name") String name) {
    RestTemplate restTemplate = new RestTemplate();
    //restTemplate.getForObject("");



    return null;
  }

  public static void main(String[] args) {
    Protocol protocol= ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
    System.out.println(protocol);
  }
}
