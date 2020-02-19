package de.interview.fizzbuzz.demo.controller;

import de.interview.fizzbuzz.demo.model.FizzBuzzInput;
import de.interview.fizzbuzz.demo.model.FizzBuzzOutput;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class FizzBuzzControllerTest {

    final static String WORLD_CLOCK_URL = "http://worldclockapi.com/api/json/cet/now";
    final static String FIZZ = "Fizz";
    final static String BUZZ = "Buzz";
    final static String TIME_STAMP = "2020-02-02";

    FizzBuzzController controller;

    @BeforeEach
    public void init() {
        controller = Mockito.spy(new FizzBuzzController());
        when(controller.getTimestampFrom(WORLD_CLOCK_URL)).thenReturn(TIME_STAMP);
    }

    @Test
    public void output_for_non_fizzBuzzy_input() throws Exception {
        // arrange
        String input = "2";

        // act
        FizzBuzzInput fizzBuzzInput = new FizzBuzzInput(input);
        controller.createFizzBuzzItem(fizzBuzzInput);

        // assert
        Collection<FizzBuzzOutput> fizzBuzzOutputs = controller.allFizzBuzzItems();
        Iterator<FizzBuzzOutput> iterator = fizzBuzzOutputs.iterator();
        Assert.assertTrue(iterator.hasNext());
        FizzBuzzOutput output = iterator.next();
        Assert.assertEquals(Integer.parseInt(input), output.getInput());
        Assert.assertEquals(input, output.getValue());
        Assert.assertEquals(TIME_STAMP, output.getTimestamp());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void output_for_input_divisible_by_3_but_not_5() throws Exception {
        // arrange
        String input = "3";

        // act
        FizzBuzzInput fizzBuzzInput = new FizzBuzzInput(input);
        controller.createFizzBuzzItem(fizzBuzzInput);

        // assert
        Collection<FizzBuzzOutput> fizzBuzzOutputs = controller.allFizzBuzzItems();
        Iterator<FizzBuzzOutput> iterator = fizzBuzzOutputs.iterator();
        Assert.assertTrue(iterator.hasNext());
        FizzBuzzOutput output = iterator.next();
        Assert.assertEquals(Integer.parseInt(input), output.getInput());
        Assert.assertEquals(FIZZ, output.getValue());
        Assert.assertEquals(TIME_STAMP, output.getTimestamp());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void output_for_input_divisible_by_5_but_not_3() throws Exception {
        // arrange
        String input = "5";

        // act
        FizzBuzzInput fizzBuzzInput = new FizzBuzzInput(input);
        controller.createFizzBuzzItem(fizzBuzzInput);

        // assert
        Collection<FizzBuzzOutput> fizzBuzzOutputs = controller.allFizzBuzzItems();
        Iterator<FizzBuzzOutput> iterator = fizzBuzzOutputs.iterator();
        Assert.assertTrue(iterator.hasNext());
        FizzBuzzOutput output = iterator.next();
        Assert.assertEquals(Integer.parseInt(input), output.getInput());
        Assert.assertEquals(BUZZ, output.getValue());
        Assert.assertEquals(TIME_STAMP, output.getTimestamp());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void output_for_input_divisible_by_5_and_3() throws Exception {
        // arrange
        String input = "15";

        // act
        FizzBuzzInput fizzBuzzInput = new FizzBuzzInput(input);
        controller.createFizzBuzzItem(fizzBuzzInput);

        // assert
        Collection<FizzBuzzOutput> fizzBuzzOutputs = controller.allFizzBuzzItems();
        Iterator<FizzBuzzOutput> iterator = fizzBuzzOutputs.iterator();
        Assert.assertTrue(iterator.hasNext());
        FizzBuzzOutput output = iterator.next();
        Assert.assertEquals(Integer.parseInt(input), output.getInput());
        Assert.assertEquals(FIZZ + " " + BUZZ, output.getValue());
        Assert.assertEquals(TIME_STAMP, output.getTimestamp());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void ordered_output_for_random_input() throws Exception {
        // arrange
        List<Integer> inputList = Arrays.asList(123, 2, 15, 7, 11, -13, 3, 123, 0);
        List<Integer> outputOrderedList = new ArrayList<>(new HashSet<Integer>(inputList)).stream()
                .filter(i -> i > 0)
                .sorted()
                .collect(Collectors.toList());

        List<String> outputValueList = new ArrayList<>();
        for (Integer i : outputOrderedList) {
            String value = BusinessLogic.fizzBuzzOf(i);
            outputValueList.add(value);
        }

        // act
        inputList.forEach(i -> {
            FizzBuzzInput fizzBuzzInput = new FizzBuzzInput(String.valueOf(i));
            controller.createFizzBuzzItem(fizzBuzzInput);
        });

        // assert
        Collection<FizzBuzzOutput> fizzBuzzOutputs = controller.allFizzBuzzItems();
        Iterator<FizzBuzzOutput> iterator = fizzBuzzOutputs.iterator();

        int idx = 0;
        while (iterator.hasNext()) {
            FizzBuzzOutput output = iterator.next();

            Assert.assertEquals(outputOrderedList.get(idx).intValue(), output.getInput());
            Assert.assertEquals(outputValueList.get(idx), output.getValue());
            Assert.assertEquals(TIME_STAMP, output.getTimestamp());
            ++idx;
        }
    }

    @Test
    public void deleteAll_function_should_delete_all_items() throws Exception {
        // arrange
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);
        int size = inputList.size();

        // act
        inputList.forEach(i -> {
            FizzBuzzInput fizzBuzzInput = new FizzBuzzInput(String.valueOf(i));
            controller.createFizzBuzzItem(fizzBuzzInput);
        });

        // assert
        int sizeOfOutputBeforeDelete = getSizeOfOutput();
        Assert.assertEquals(size, sizeOfOutputBeforeDelete);

        controller.deleteAllFizzBuzzItems();

        int sizeOfOutputAfterDelete = getSizeOfOutput();
        Assert.assertEquals(0, sizeOfOutputAfterDelete);
    }

    private int getSizeOfOutput() {
        Collection<FizzBuzzOutput> fizzBuzzOutputs = controller.allFizzBuzzItems();
        return fizzBuzzOutputs.toArray().length;
    }
}
