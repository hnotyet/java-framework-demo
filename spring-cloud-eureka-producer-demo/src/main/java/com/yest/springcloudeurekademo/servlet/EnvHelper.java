/*
 * Copyright(c) 2020 taofen8.com. All rights reserved.
 *
 * This source code is licensed under Apache 2.0 License.
 */

package com.yest.springcloudeurekademo.servlet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvHelper {

  public static void main(String[] args) throws SocketException {
    getLocalIp("192.168.0.*");
  }

  public static String getLocalIp(String reg) throws SocketException {
    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
    Pattern pattern = Pattern.compile(reg);

    while (networkInterfaces.hasMoreElements()) {
      NetworkInterface networkInterface = networkInterfaces.nextElement();
      Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
      while (inetAddresses.hasMoreElements()) {
        InetAddress inetAddress = inetAddresses.nextElement();
        String hostAddress = inetAddress.getHostAddress();
        Matcher matcher = pattern.matcher(hostAddress);
        if (matcher != null && matcher.find()) {
          return hostAddress;
        }
      }
    }
    return null;
  }
}
