package com.infinxinc.ping;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@Value("${ping.template:Hello There , %s!}")
    private String template ;
	private static final String API_ROOT = "/api/ping";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(API_ROOT)
    public Ping greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
        return new Ping(counter.incrementAndGet(),
                            String.format(template, name));
    }
}