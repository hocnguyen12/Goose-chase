package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryDUT;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryPrepa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryStudentTest {
    AbstractFactoryStudent student_dut;
    AbstractFactoryStudent student_licence;
    AbstractFactoryStudent student_prepa;

    @BeforeEach
    void setUp() {
        student_dut = new ConcreteFactoryDUT();
        student_licence = new ConcreteFactoryLicence();
        student_prepa = new ConcreteFactoryPrepa();
    }

    @AfterEach
    void tearDown() {
        student_dut = null;
        student_licence = null;
        student_prepa = null;
    }

    @Test
    void move() {
        student_dut.move(2);
        assertEquals(2, student_dut.getSquareNumber());

        student_dut.move(5);
        assertEquals(7, student_dut.getSquareNumber());

        student_dut.move(70);
        assertEquals(49, student_dut.getSquareNumber());

        student_dut.move(-100);
        assertEquals(0, student_dut.getSquareNumber());

        assertNotEquals(49, student_dut.getSquareNumber());
    }

    @Test
    void positionList(){
        assertEquals(0, student_prepa.getRoundPositions().size());
        student_prepa.addRoundPositions(12);
        assertEquals(12, student_prepa.getRoundPositions().get(0));
        student_prepa.resetRoundPositions();
        assertEquals(0, student_prepa.getRoundPositions().size());
    }

    @Test
    void increaseSkillLevel() {
        assertEquals(0, student_dut.getSkillLevel());

        student_dut.increaseSkillLevel(5);
        assertEquals(5, student_dut.getSkillLevel());

        student_dut.increaseSkillLevel(-2);
        assertEquals(3, student_dut.getSkillLevel());

        student_dut.increaseSkillLevel(-4);
        assertEquals(0, student_dut.getSkillLevel());
    }

    @Test
    void setSquareNumber() {
        student_licence.setSquareNumber(0);
        assertEquals(0, student_licence.getSquareNumber());
        student_licence.setSquareNumber(-1);
        assertEquals(0, student_licence.getSquareNumber());
    }

    @Test
    void get_student() {
        assertNotNull(student_dut.getStudent());
    }
}