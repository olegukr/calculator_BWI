package com.example.factoriaf5.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
    public void testPersonInitialization() {
        Person person = new Person("Alice", 65.0, 1.7);
        assertEquals("Alice", person.getName());
        assertEquals(65.0, person.getWeight());
        assertEquals(1.7, person.getHeight());
    }

    @Test
    public void testPersonToString() {
        Person person = new Person("Bob", 70.0, 1.8);
        String expected = "Person{name='Bob', weight=70.0, height=1.8}";
        assertEquals(expected, person.toString());
    }

    @Test
    public void testSetters() {
        // Test setters
        Person person = new Person("Charlie", 75.0, 1.9);
        
        // Modify attributes
        person.setName("Dave");
        person.setWeight(80.0);
        person.setHeight(2.0);

        // Verify changes
        assertEquals("Dave", person.getName());
        assertEquals(80.0, person.getWeight());
        assertEquals(2.0, person.getHeight());
    }
}
