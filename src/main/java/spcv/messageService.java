package com.spcv;

import io.micronaut.core.annotation.NonNull;
import jakarta.validation.constraints.NotBlank;

interface MessageService {

    String sayHello(@NonNull @NotBlank String name);
}