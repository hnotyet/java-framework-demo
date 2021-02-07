package com.yest.springcloudtaskdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudTaskDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudTaskDemoApplication.class, args);
  }


  @Bean
  public CommandLineRunner commandLineRunner() {
    return new HelloWorldCommandLineRunner();
  }

  public static class HelloWorldCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
      System.out.println("Hello, World!");
    }
  }
}
