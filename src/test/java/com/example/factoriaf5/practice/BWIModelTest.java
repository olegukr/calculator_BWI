package com.example.factoriaf5.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BWIModelTest {

     private BWIModel bwiModel;

    @BeforeEach
    public void setUp() {
        // Initialize with a sample Person object before each test
        Person person = new Person("Alice", 65.0, 1.7); // Weight: 65 kg, Height: 1.7 m
        bwiModel = new BWIModel(person);
    }

    @Test
    public void testCalculateBWI() {
        // Verify the calculated BWI value
        double expectedBWI = 65.0 / Math.pow(1.7, 2); // BWI formula
        double actualBWI = bwiModel.calculateBWI();
        assertEquals(expectedBWI, actualBWI, 0.01, "BWI calculation should match expected value");
    }

    @Test
    public void testGiveResultBWIStringSevereThinness() {
        // Test category: Severe thinness
        String classification = bwiModel.giveResultBWIString(15.5);
        assertEquals("Severe thinness", classification, "BWI < 16 should classify as Severe thinness");
    }

    @Test
    public void testGiveResultBWIStringModerateThinness() {
        // Test category: Moderate thinness
        String classification = bwiModel.giveResultBWIString(16.5);
        assertEquals("Moderate thinness", classification, "16 <= BWI < 17 should classify as Moderate thinness");
    }

    @Test
    public void testGiveResultBWIStringMildThinness() {
        // Test category: Mild thinness
        String classification = bwiModel.giveResultBWIString(17.5);
        assertEquals("Mild thinness", classification, "17 <= BWI < 18.5 should classify as Mild thinness");
    }

    @Test
    public void testGiveResultBWIStringNormalWeight() {
        // Test category: Normal weight
        String classification = bwiModel.giveResultBWIString(22.0);
        assertEquals("Normal weight", classification, "18.5 <= BWI < 25 should classify as Normal weight");
    }

    @Test
    public void testGiveResultBWIStringOverweight() {
        // Test category: Overweight
        String classification = bwiModel.giveResultBWIString(28.0);
        assertEquals("Overweight", classification, "25 <= BWI < 30 should classify as Overweight");
    }

    @Test
    public void testGiveResultBWIStringMildObesity() {
        // Test category: Mild obesity
        String classification = bwiModel.giveResultBWIString(32.0);
        assertEquals("Mild obesity", classification, "30 <= BWI < 35 should classify as Mild obesity");
    }

    @Test
    public void testGiveResultBWIStringModerateObesity() {
        // Test category: Moderate obesity
        String classification = bwiModel.giveResultBWIString(37.0);
        assertEquals("Moderate obesity", classification, "35 <= BWI < 40 should classify as Moderate obesity");
    }

    @Test
    public void testGiveResultBWIStringMorbidObesity() {
        // Test category: Morbid obesity
        String classification = bwiModel.giveResultBWIString(41.0);
        assertEquals("Morbid obesity", classification, "BWI >= 40 should classify as Morbid obesity");
    }

    @Test
    public void testGiveResultBWIStringUnableToClassify() {
        // Test category: Unable to classify
        String classification = bwiModel.giveResultBWIString(-5.0); // Invalid BWI
        assertEquals("Unable to classify this BWI", classification, "Invalid BWI values should return an appropriate message");
    }
}
