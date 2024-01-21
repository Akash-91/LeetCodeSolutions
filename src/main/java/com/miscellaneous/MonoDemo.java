package com.miscellaneous;

import reactor.core.publisher.Mono;

public class MonoDemo {


    public static void main(String[] args) {

        Mono<String> monoString = Mono.just("Hello, World!");

        monoString.subscribe(value -> System.out.println(value));
    }
}
