package com.yest.springcloudeurekademo.servlet;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ServerConfig class
 *
 * @author fwhui
 * @date 2020/5/11
 */
@Component
public class PortHelper implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

    public int getServerPort() {
        return serverPort;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        serverPort = webServerInitializedEvent.getWebServer().getPort();
    }
}
