package com.example.factoriaf5.practice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BWIViewTest {

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private BWIView view;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture console output
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        Scanner scanner = new Scanner(testIn);
        view = new BWIView(scanner); // Initialize BWIView with the test Scanner
    }

    private String getOutput() {
        return testOut.toString().trim(); // Capture and return console output
    }

    @Test
    public void testAskWeightValidInput() {
        // Simulate valid user input
        provideInput("70.5\n");
        double weight = view.askWeight();

        // Verify the result and printed output
        assertEquals(70.5, weight, "The entered weight should be correctly parsed.");
        assertTrue(getOutput().contains("Enter your weight in kilograms:"));
    }

    @Test
    public void testAskHeightValidInput() {
        // Simulate valid user input
        provideInput("1.75\n");
        double height = view.askHeight();

        // Verify the result and printed output
        assertEquals(1.75, height, "The entered height should be correctly parsed.");
        assertTrue(getOutput().contains("Enter your height in meters:"));
    }

    @Test
    public void testAskName() {
        // Simulate valid user input
        provideInput("Alice\n");
        String name = view.askName();

        // Verify the result and printed output
        assertEquals("Alice", name, "The entered name should be correctly retrieved.");
        assertTrue(getOutput().contains("Could input your name:"));
    }

    @Test
    public void testAskToContinueYes() {
        // Simulate user entering 'y' for "yes"
        provideInput("y\n");
        boolean result = view.askToContinue();

        // Verify the result and printed output
        assertTrue(result, "The method should return true for 'y' input.");
        assertTrue(getOutput().contains("Do you want to continue?"));
    }

    @Test
    public void testAskToContinueNo() {
        // Simulate user entering 'n' for "no"
        provideInput("n\n");
        boolean result = view.askToContinue();

        // Verify the result and printed output
        assertFalse(result, "The method should return false for 'n' input.");
    }

    @Test
    public void testAskViewAllResultsYes() {
        // Simulate user entering 'y' for "yes"
        provideInput("y\n");
        boolean result = view.askViewAllResults();

        // Verify the result and printed output
        assertTrue(result, "The method should return true for 'y' input.");
        assertTrue(getOutput().contains("Do you want to view all results?"));
    }

    @Test
    public void testAskViewAllResultsNo() {
        // Simulate user entering 'n' for "no"
        provideInput("n\n");
        boolean result = view.askViewAllResults();

        // Verify the result and printed output
        assertFalse(result, "The method should return false for 'n' input.");
    }

    @Test
    public void testShowResult() {
        // Call showResult() with sample data
        view = new BWIView(new Scanner(System.in)); // Use default scanner for this test
        view.showResult(22.5, "Normal weight");

        // Verify the printed output
        String output = getOutput();
        assertTrue(output.contains("BWI is: 22.50"));
        assertTrue(output.contains("Classification: Normal weight"));
    }

    @Test
    public void testAskQuestionYNValidInput() {
        // Simulate valid 'y' input
        provideInput("y\n");
        boolean result = view.askQuestionYN("Is this a test?");

        // Verify the result and printed output
        assertTrue(result, "The method should return true for 'y' input.");
        assertTrue(getOutput().contains("Is this a test?"));
    }

    @Test
    public void testAskQuestionYNInvalidInput() {
        // Simulate invalid input followed by 'n'
        provideInput("invalid\nx\nn\n");
        boolean result = view.askQuestionYN("Is this a test?");

        // Verify the result and printed output
        assertFalse(result, "The method should return false for 'n' input.");
        String output = getOutput();
        assertTrue(output.contains("Is this a test?"));
        assertTrue(output.contains("For Continue press \"Y\" , for Exit press \"N\":"));
    }
}
