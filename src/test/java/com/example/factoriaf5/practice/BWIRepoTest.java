package com.example.factoriaf5.practice;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BWIRepoTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @AfterEach
    public void clearHistory() {
        // Reset the output stream and clear the calculation history after each test
        System.setOut(System.out);
        BWIRepo.getAllResults(); // Clear calculation history
    }

    @Test
    public void testGetAllResultsWhenEmpty() {
        // Redirect output to test the message when the history is empty
        System.setOut(new PrintStream(outputStream));
        BWIRepo.getAllResults();

        String expected = "No results to display.";
        assertEquals(expected.trim(), outputStream.toString().trim());
    }

    @Test
    public void testSaveResult() {
        Person person = new Person("Alice", 65.0, 1.7);
        double bwi = 22.49;
        String classification = "Normal weight";

        BWIRepo.saveResult(person, bwi, classification);

        // Simulate output redirection
        System.setOut(new PrintStream(outputStream));
        BWIRepo.getAllResults();

        String expected = "Calculation History:\nname: Alice; weight: 65.0; height: 1.7; BWI: 22.49; diagnosis: Normal weight\n";
        assertEquals(expected.trim(), outputStream.toString().trim());
    }
}

