package de.interview.fizzbuzz.demo.controller;

import de.interview.fizzbuzz.demo.model.FizzBuzzInput;
import de.interview.fizzbuzz.demo.model.FizzBuzzOutput;
import de.interview.fizzbuzz.demo.model.WorldClock;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

@NoArgsConstructor
@RestController
@RequestMapping("/api")
public class FizzBuzzController {

    private final Logger log = LoggerFactory.getLogger(FizzBuzzController.class);
    private SortedMap<Integer, FizzBuzzOutput> fizzBuzzOutputsRepo = new TreeMap<Integer, FizzBuzzOutput>();

    @GetMapping("/allFizzBuzzItems")
    public Collection<FizzBuzzOutput> allFizzBuzzItems() {
        System.out.println(fizzBuzzOutputsRepo.values());
        return fizzBuzzOutputsRepo.values();
    }

    @PutMapping("/fizzbuzz")
    public void createFizzBuzzItem(@Valid @RequestBody @NonNull FizzBuzzInput fizzBuzzInput) {
        Integer input = Integer.parseInt(fizzBuzzInput.getValue());
        if (input <= 0) {
            return;
        }

        String value = BusinessLogic.fizzBuzzOf(Integer.parseInt(fizzBuzzInput.getValue()));

        String timestamp = getTimestampFrom("http://worldclockapi.com/api/json/cet/now");

        FizzBuzzOutput fizzBuzzOutput = new FizzBuzzOutput(input, value, timestamp);
        fizzBuzzOutputsRepo.put(input, fizzBuzzOutput);

    }

    // delete all
    @DeleteMapping("/fizzbuzz/all")
    public void deleteAllFizzBuzzItems() {
        fizzBuzzOutputsRepo.clear();
    }

    public String getTimestampFrom(String serviceURL) {
        RestTemplate restTemplate = new RestTemplate();
        WorldClock result = restTemplate.getForObject(serviceURL, WorldClock.class);
        return result.getCurrentDateTime();
    }
}