package com.infinxinc.ping;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomContainer implements
  WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
 
	@Value("${server.http.port}")
	private int httpPort;
	
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
    	Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        
        factory.addAdditionalTomcatConnectors(connector);
    }
}