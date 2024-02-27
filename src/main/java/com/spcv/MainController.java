package com.spcv;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import java.util.Map;

import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller 
class MainController {

    @View("index.html")
    @Get(value = "/index.html", produces = TEXT_HTML)
    Map<String, String> index( String name) {
        return Map.of("message", "hello");
    }

    @Get("/spcv")
    @View("index.html") // Points to the Thymeleaf template name without the file extension
    public HttpResponse<Object> indexSpcv() {
        return HttpResponse.ok();
    }

    @Get("/")
    @View("index.html") // Points to the Thymeleaf template name without the file extension
    public HttpResponse<Object> indexRoot() {
        return HttpResponse.ok();
    }

}