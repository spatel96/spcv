package com.spcv;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/info")
public class InfoController {

    @Inject
    private ApplicationContext applicationContext;

    @Get
    public String getInfo() {
        Environment environment = applicationContext.getEnvironment();

        String appName = environment.getProperty("micronaut.application.name", String.class, "N/A");
        String appVersion = environment.getProperty("micronaut.application.version", String.class, "N/A");
        String commitId = environment.getProperty("micronaut.application.commit-id", String.class, "N/A");

        return "Application Name: " + appName + "\n" +
                "Application Version: " + appVersion + "\n" +
                "Commit ID: " + commitId;
    }
}