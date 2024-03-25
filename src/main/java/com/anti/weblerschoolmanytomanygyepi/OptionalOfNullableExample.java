package com.anti.weblerschoolmanytomanygyepi;

import java.util.Optional;

public class OptionalOfNullableExample {

    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        System.out.println("Optional1: " + optional1);

        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println("\n\nOptional2: " + optional2);
        System.out.println("Optional2.isPresent: " + optional2.isPresent());


        String nullableString = null;
        Optional<String> optionalString = Optional.ofNullable(nullableString);
        if (optionalString.isPresent()) {
            System.out.println("Value is present: " + optionalString.get());
        } else {
            System.out.println("Value is absent");
        }
    }
}
