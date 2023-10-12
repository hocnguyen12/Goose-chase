package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareUniTeachingsTest {

    AbstractFactoryStudent dut;
    AbstractFactoryStudent licence;
    AbstractFactoryStudent prepa;
    SquareUniTeachings squareUniTeachings;
    @BeforeEach
    void setUp() {
        dut= new ConcreteFactoryDUT();
        licence= new ConcreteFactoryLicence();
        prepa= new ConcreteFactoryPrepa();
        squareUniTeachings= new SquareUniTeachings();
    }

    @AfterEach
    void tearDown() {
        dut= null;
        licence= null;
        prepa= null;
        squareUniTeachings= null;
    }

    @Test
    void execute() {
        licence.increaseSkillLevel(4);
        assertEquals(4, licence.getSkillLevel());
        assertFalse(5 == licence.getSkillLevel());
        licence.setSquareNumber(5);
        squareUniTeachings.execute(licence);
        assertEquals(5, licence.getSkillLevel());
        assertFalse(4 == licence.getSkillLevel());
        assertEquals(6,licence.getSquareNumber());
        assertFalse(5 == licence.getSquareNumber());

        prepa.increaseSkillLevel(4);
        assertEquals(4, prepa.getSkillLevel());
        assertFalse(5 == prepa.getSkillLevel());
        prepa.setSquareNumber(5);
        squareUniTeachings.execute(prepa);
        assertEquals(5, prepa.getSkillLevel());
        assertFalse(4 == prepa.getSkillLevel());
        assertEquals(4,prepa.getSquareNumber());
        assertFalse(5 == prepa.getSquareNumber());

        dut.increaseSkillLevel(4);
        assertEquals(4, dut.getSkillLevel());
        assertFalse(5 == dut.getSkillLevel());
        dut.setSquareNumber(5);
        squareUniTeachings.execute(dut);
        assertEquals(5, dut.getSkillLevel());
        assertFalse(4 == dut.getSkillLevel());
        assertEquals(4,dut.getSquareNumber());
        assertFalse(5 == dut.getSquareNumber());


    }
}