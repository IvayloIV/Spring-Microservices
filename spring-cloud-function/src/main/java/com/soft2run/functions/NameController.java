package com.soft2run.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class NameController {

    private final List<String> names = new ArrayList<>();

    public NameController() {
        names.add("Ivan");
        names.add("Martin");
        names.add("Gosho");
    }

    @Bean
    public Function<String, String> getName() {
        return name -> {
            if (names.contains(name)) {
                return "Hello, " + name;
            }
            return "User not found";
        };
    }

    @Bean
    public Supplier<List<String>> getNames() {
        return () -> names;
    }

    @Bean
    public Consumer<String> addName() {
        return names::add;
    }

    @Bean
    public Function<Mono<String>, Flux<String>> removeName() {
        return name -> {
            name.subscribe(names::remove);
            return Flux.fromIterable(names);
        };
    }
}
