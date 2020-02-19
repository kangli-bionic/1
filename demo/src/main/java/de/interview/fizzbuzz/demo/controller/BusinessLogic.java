package de.interview.fizzbuzz.demo.controller;

final public class BusinessLogic {

    final static String FIZZ = "Fizz";
    final static String BUZZ = "Buzz";
    final static String ERROR = "ERROR";

    public static String fizzBuzzOf(Integer num) {
        if (num == null || num <= 0) {
            return ERROR;
        }
        if (num % 3 == 0 && num % 5 == 0) {
            return FIZZ + " " + BUZZ;
        }
        if (num % 3 == 0) {
            return FIZZ;
        }
        if (num % 5 == 0) {
            return BUZZ;
        }
        return String.valueOf(num);
    }
}
