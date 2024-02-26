package com.spcv;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import jakarta.validation.constraints.NotBlank;

import java.util.Map;

import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller 
class MainController {

    private final MessageService messageService;

    public MainController(MessageService messageService) { 
        this.messageService = messageService;
    }

    @View("index.html") 
    @Get(value = "/hello/{name}", produces = TEXT_HTML) 
    Map<String, String> index(@NonNull @NotBlank String name) { 
        return Map.of("message", messageService.sayHello(name));
    }
}