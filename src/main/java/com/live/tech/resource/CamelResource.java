package com.live.tech.resource;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelResource extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer://sampleTimer?repeatCount=1")
                .log("Initiated first route")
                .delay(20000)
                .to("direct:secondRoute");

        from("direct:secondRoute")
                .log("Inside Second Route")
                .end();
    }
}
