package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareIntensiveStudyTest {
    AbstractFactoryStudent student;
    SquareIntensiveStudy squareIntensiveStudy;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryPrepa();
        squareIntensiveStudy= new SquareIntensiveStudy();
    }

    @AfterEach
    void tearDown() {
        student= null;
        squareIntensiveStudy= null;
    }

    @Test
    void execute() {
        student.increaseSkillLevel(5);
        student.setSquareNumber(6);

        assertEquals(5, student.getSkillLevel());
        assertNotEquals(6, student.getSkillLevel());

        assertEquals(6,student.getSquareNumber());
        assertNotEquals(12, student.getSquareNumber());

        squareIntensiveStudy.execute(student, 0, null);

        assertEquals(6, student.getSkillLevel());
        assertNotEquals(5, student.getSkillLevel());

        assertEquals(12,student.getSquareNumber());
        assertNotEquals(6, student.getSquareNumber());


    }
}