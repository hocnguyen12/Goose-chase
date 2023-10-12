package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareExamTest {
    AbstractFactoryStudent student;
    SquareExam exam;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryLicence();
        exam= new SquareExam();
    }

    @AfterEach
    void tearDown() {
        student= null;
        exam= null;
    }

    @Test
    void execute() {
        student.increaseSkillLevel(10);
        student.setSquareNumber(10);
        exam.execute(student, 0, null);
        assertEquals(10, student.getSquareNumber());
        student.increaseSkillLevel(-4);
        exam.execute(student, 0, null);
        assertEquals(8, student.getSquareNumber());
        assertFalse(6 == student.getSquareNumber());


    }

    @Test
    void get_squareName() {
    }
}