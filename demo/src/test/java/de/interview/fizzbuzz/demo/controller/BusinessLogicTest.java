package de.interview.fizzbuzz.demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogicTest {
    // The game fizz buzz is described here:
    // https://en.wikipedia.org/wiki/Fizz_buzz
    // Sample Data provided by the wiki article:
    // Input -> Result
    // 1 -> 1,
    // 2 -> 2,
    // 3 -> Fizz,
    // 4 -> 4,
    // 5 -> Buzz,
    // 6 -> Fizz,
    // 7 -> 7,
    // 8 -> 8,
    // 9 -> Fizz,
    // 10 -> Buzz,
    // 11 -> 11,
    // 12 -> Fizz,
    // 13 -> 13,
    // 14 -> 14,
    // 15 -> Fizz Buzz,
    // 16 -> 16,
    // 17 -> 17,
    // 18 -> Fizz,
    // 19 -> 19,
    // 20 -> Buzz,
    // 21 -> Fizz,
    // 22 -> 22,
    // 23 -> 23,
    // 24 -> Fizz,
    // 25 -> Buzz,
    // 26 -> 26,
    // 27 -> Fizz,
    // 28 -> 28,
    // 29 -> 29,
    // 30 -> Fizz Buzz,
    // 31 -> 31,
    // 32 -> 32,
    // 33 -> Fizz,
    // 34 -> 34,
    // 35 -> Buzz,
    // 36 -> Fizz,
    // ...

    final static String FIZZ = "Fizz";
    final static String BUZZ = "Buzz";
    final static String ERROR = "ERROR";

    @Test
    void fizzBuzz_for_numbers_not_divisible_by_3_nor_by_5() {
        // arrange
        List<Integer> numbers_not_divisible_by_3_nor_by_5 = new ArrayList<>();
        numbers_not_divisible_by_3_nor_by_5.add(1);
        numbers_not_divisible_by_3_nor_by_5.add(7);
        numbers_not_divisible_by_3_nor_by_5.add(26);

        numbers_not_divisible_by_3_nor_by_5.forEach(n -> {
            // act
            String result = BusinessLogic.fizzBuzzOf(n);
            // assert
            Assertions.assertEquals(result, String.valueOf(n));
        });
    }

    @Test
    void fizzBuzz_for_numbers_divisible_by_3_but_not_5() {
        // arrange
        List<Integer> numbersDivisibleBy3ButNot5 = new ArrayList<>();
        numbersDivisibleBy3ButNot5.add(3);
        numbersDivisibleBy3ButNot5.add(18);
        numbersDivisibleBy3ButNot5.add(33);

        numbersDivisibleBy3ButNot5.forEach(n -> {
            // act
            String result = BusinessLogic.fizzBuzzOf(n);
            // assert
            Assertions.assertEquals(FIZZ, result);
        });
    }

    @Test
    void fizzBuzz_for_numbers_divisible_by_5_but_not_3() {
        // arrange
        List<Integer> numbersDivisibleBy5 = new ArrayList<>();
        numbersDivisibleBy5.add(5);
        numbersDivisibleBy5.add(25);
        numbersDivisibleBy5.add(35);

        numbersDivisibleBy5.forEach(n -> {
            // act
            String result = BusinessLogic.fizzBuzzOf(n);
            // assert
            Assertions.assertEquals(BUZZ, result);
        });
    }

    @Test
    void fizzBuzz_for_numbers_divisible_by_3_and_5() {
        // arrange
        List<Integer> numbersDivisibleBy5 = new ArrayList<>();
        numbersDivisibleBy5.add(15);
        numbersDivisibleBy5.add(30);

        numbersDivisibleBy5.forEach(n -> {
            // act
            String result = BusinessLogic.fizzBuzzOf(n);
            // assert
            Assertions.assertEquals((FIZZ + " " + BUZZ), result);
        });
    }

    @Test
    void fizzBuzz_for_erroneous_input() {
        // arrange
        List<Integer> erroneous_input = new ArrayList<>();
        erroneous_input.add(-15);
        erroneous_input.add(0);
        erroneous_input.add(null);

        erroneous_input.forEach(n -> {
            // act
            String result = BusinessLogic.fizzBuzzOf(n);
            // assert
            Assertions.assertEquals(ERROR, result);
        });
    }
}
