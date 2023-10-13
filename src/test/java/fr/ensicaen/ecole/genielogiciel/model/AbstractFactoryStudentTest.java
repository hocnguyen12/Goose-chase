package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryDUT;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryStudentTest {
    AbstractFactoryStudent student;
    @BeforeEach
    void setUp() {
        student = new ConcreteFactoryDUT();
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

        assertNotEquals(49, student.getSquareNumber());
    }

    @Test
    void increaseSkillLevel() {
        assertEquals(0,student.getSkillLevel());

        student.increaseSkillLevel(5);
        assertEquals(5, student.getSkillLevel());

        student.increaseSkillLevel(-2);
        assertEquals(3, student.getSkillLevel());

        student.increaseSkillLevel(-4);
        assertEquals(0, student.getSkillLevel());
    }

    @Test
    void get_student() {
        assertNotNull(student.getStudent());
    }
}