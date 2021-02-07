package com.yest.springcloudeurekademo.servlet;

import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/7
 */


@WebServlet(urlPatterns = "/*", loadOnStartup = 1)
public class KongDispatcherServlet extends DispatcherServlet {

  @Override
  protected void initStrategies(ApplicationContext context) {
    super.initStrategies(context);

    //TODO 服务注册
    //registerServicesToKong(services);

  }
}
