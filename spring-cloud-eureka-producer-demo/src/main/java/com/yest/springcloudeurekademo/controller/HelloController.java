package com.yest.springcloudeurekademo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/10/22
 */
@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String index(@RequestParam String name) {
    return "hello "+name+"，this is first messge";
  }

}
