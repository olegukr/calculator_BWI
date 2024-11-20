package com.example.factoriaf5.practice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
    
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
    public void testMainMethodSingleIteration() {
        // Simulate input for a single iteration
        provideInput(
                "Alice\n" +      // Name
                "70.0\n" +       // Weight
                "1.75\n" +       // Height
                "n\n" +          // Do you want to continue?
                "n\n"            // Do you want to view all results?
        );

        // Execute the main method
        App.main(new String[]{});

        // Capture the output
        String output = getOutput();

        // Verify expected output
        assertTrue(output.contains("Could input your name:"));
        assertTrue(output.contains("Enter your weight in kilograms:"));
        assertTrue(output.contains("Enter your height in meters:"));
        assertTrue(output.contains("BWI is:")); // BWI calculation result
        assertTrue(output.contains("Classification:")); // Classification result
    }

    @Test
    public void testMainMethodMultipleIterations() {
        // Simulate input for multiple iterations
        provideInput(
                "Alice\n" +      // Name
                "70.0\n" +       // Weight
                "1.75\n" +       // Height
                "y\n" +          // Do you want to continue?
                "Bob\n" +        // Name
                "80.0\n" +       // Weight
                "1.8\n" +        // Height
                "n\n" +          // Do you want to continue?
                "y\n"            // Do you want to view all results?
        );

        // Execute the main method
        App.main(new String[]{});

        // Capture the output
        String output = getOutput();

        // Verify results for both iterations
        assertTrue(output.contains("Could input your name:"));
        assertTrue(output.contains("Enter your weight in kilograms:"));
        assertTrue(output.contains("Enter your height in meters:"));
        assertTrue(output.contains("BWI is:")); // BWI calculation result
        assertTrue(output.contains("Classification:")); // Classification result
        assertTrue(output.contains("Calculation History:")); // All results printed
    }
}