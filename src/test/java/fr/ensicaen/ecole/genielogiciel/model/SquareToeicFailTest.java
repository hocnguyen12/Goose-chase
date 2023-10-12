package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareToeicFailTest {

    AbstractFactoryStudent student;
    SquareToeicFail squareToeicFail;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryPrepa();
        squareToeicFail= new SquareToeicFail();
    }

    @AfterEach
    void tearDown() {
        student= null;
        squareToeicFail= null;
    }

    @Test
    void execute() {
        student.setSquareNumber(14);

        assertEquals(14, student.getSquareNumber());
        assertNotEquals(8, student.getSquareNumber());

        squareToeicFail.execute(student);

        assertEquals(2,student.getSquareNumber());
        assertNotEquals(14,student.getSquareNumber());

    }
}