package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareDropoutTest {
    AbstractFactoryStudent student;
    SquareDropout dropout;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryDUT();
        dropout= new SquareDropout();
    }

    @AfterEach
    void tearDown() {
        student= null;
        dropout= null;
    }

    @Test
    void execute() {
        student.move(5);
        assertEquals(5, student.getSquareNumber());
        dropout.execute(student, 0, null);
        assertEquals(0, student.getSquareNumber());
        assertFalse(5 == student.getSquareNumber());
    }
}