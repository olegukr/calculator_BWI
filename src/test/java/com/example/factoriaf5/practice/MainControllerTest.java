package com.example.factoriaf5.practice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainControllerTest {

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture console output
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn); // Redirect System.in to use the provided input
    }

    private String getOutput() {
        return testOut.toString().trim(); // Capture and return console output
    }

    @Test
    public void testMainControllerSingleIteration() {
        // Simulate user input for one iteration and exit
        provideInput(
                "John\n" +        // Name
                "75\n" +          // Weight
                "1.8\n" +         // Height
                "n\n" +           // Do you want to continue?
                "n\n"             // Do you want to view all results?
        );

        // Run MainController
        new MainController();

        // Verify console output contains expected results
        String output = getOutput();
        assertTrue(output.contains("Enter your weight in kilograms:"));
        assertTrue(output.contains("Enter your height in meters:"));
        assertTrue(output.contains("BWI is:")); // BWI result
        assertTrue(output.contains("Classification:")); // Classification result
    }

    @Test
    public void testMainControllerMultipleIterations() {
        // Simulate user input for two iterations and view all results
        provideInput(
                "John\n" +        // Name
                "75\n" +          // Weight
                "1.8\n" +         // Height
                "y\n" +           // Do you want to continue?
                "Jane\n" +        // Name
                "65\n" +          // Weight
                "1.6\n" +         // Height
                "n\n" +           // Do you want to continue?
                "y\n"             // Do you want to view all results?
        );

        // Run MainController
        new MainController();

        // Verify console output contains results for both iterations
        String output = getOutput();
        assertTrue(output.contains("Enter your weight in kilograms:"));
        assertTrue(output.contains("Enter your height in meters:"));
        assertTrue(output.contains("BWI is:")); // BWI result
        assertTrue(output.contains("Classification:")); // Classification result
        assertTrue(output.contains("Calculation History:")); // View all results
    }

    @Test
    public void testMainControllerViewAllResults() {
        // Simulate user input for one iteration and view results
        provideInput(
                "John\n" +        // Name
                "80\n" +          // Weight
                "1.9\n" +         // Height
                "n\n" +           // Do you want to continue?
                "y\n"             // Do you want to view all results?
        );

        // Run MainController
        new MainController();

        // Verify the results history is displayed
        String output = getOutput();
        assertTrue(output.contains("Calculation History:"));
    }
}
