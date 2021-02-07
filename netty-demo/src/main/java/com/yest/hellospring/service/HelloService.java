package com.yest.hellospring.service;

import static org.apache.zookeeper.ZooDefs.OpCode.getData;

import java.io.IOException;
import java.util.List;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.rpc.Protocol;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/25
 */
public class HelloService {


  public void sayHello(){

  }

  public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

    ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
    Protocol adaptiveExtension = extensionLoader.getAdaptiveExtension();
    System.out.println(adaptiveExtension);

    ZooKeeper zk = new ZooKeeper("",1000,null);

    List<String> l = zk.getChildren("/",true);




  }

}
