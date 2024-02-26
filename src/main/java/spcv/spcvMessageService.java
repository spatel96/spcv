package com.spcv;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotBlank;

@Singleton 
class MyMessageService implements MessageService {

    @Override
    public String sayHello(@NonNull @NotBlank String name) {
        return "Hello %s!".formatted(name);
    }
}