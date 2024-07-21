package com.example.webflux.controller;

import com.example.webflux.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/books")
    public Flux<Book> getBooks() {
        return Flux
                .just(
                        new Book("Thrawn: Alliances", "Timothy Zahn", 2018),
                        new Book("Ouroboros and Promotion Tests", "Ichiei Ishibumi ", 2012),
                        new Book("Heir to the Shadows", "Anne Bishop", 1999),
                        new Book("Horus Rising", "Dan Abnett", 2006)
                )
                .log();
    }

}
