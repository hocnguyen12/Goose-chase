package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryStudentTest {
    AbstractFactoryStudent student;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryDUT();
    }

    @AfterEach
    void tearDown() {
        student = null;
    }

    @Test
    void move() {
        student.move(2);
        assertEquals(2, student.getSquareNumber());

        student.move(5);
        assertEquals(7, student.getSquareNumber());

        student.move(70);
        assertEquals(49, student.getSquareNumber());

        student.move(-100);
        assertEquals(0, student.getSquareNumber());

        assertFalse(student.getSquareNumber() == 49);
    }

    @Test
    void has_InformaticsProblem() {
        assertFalse(student.hasInformaticsProblem());
        student.setInformaticsProblem(true);
        assertTrue(student.hasInformaticsProblem());
    }

    @Test
    void get_squareNumber() {
        student.setSquareNumber(3);
        assertEquals(3, student.getSquareNumber());
    }

    @Test
    void set_squareNumber() {
        student.setSquareNumber(3);
        assertFalse(student.getSquareNumber() == 4);
        assertEquals(3,student.getSquareNumber());

        student.setSquareNumber(-3);
        assertFalse(student.getSquareNumber() == -3);
        assertEquals(0,student.getSquareNumber());
    }

    @Test
    void getSkillLevel() {
        assertEquals(0,student.getSkillLevel());
        student.increaseSkillLevel(5);
        assertEquals(5, student.getSkillLevel());
        student.increaseSkillLevel(-2);
        assertEquals(3, student.getSkillLevel());
        assertFalse(1 == student.getSkillLevel());
    }

    @Test
    void increaseSkillLevel() {
        assertEquals(0,student.getSkillLevel());

        student.increaseSkillLevel(5);
        assertEquals(5, student.getSkillLevel());

        student.increaseSkillLevel(-2);
        assertEquals(3, student.getSkillLevel());
        assertFalse(1 == student.getSkillLevel());

        student.increaseSkillLevel(-4);
        assertEquals(0, student.getSkillLevel());
        assertFalse(1 == student.getSkillLevel());

    }

    @Test
    void setSkipNextRoundWEI() {
        assertFalse(student.nextRoundSkipped());
        student.setSkipNextRoundWEI(true);
        assertTrue(student.nextRoundSkipped());

    }

    @Test
    void nextRoundSkipped() {
        assertFalse(student.nextRoundSkipped());
        student.setSkipNextRoundWEI(true);
        assertTrue(student.nextRoundSkipped());
    }

    @Test
    void get_student() {
        assertFalse(student.getStudent() == null);
    }
}