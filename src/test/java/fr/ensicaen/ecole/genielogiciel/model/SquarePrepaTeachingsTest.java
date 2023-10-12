package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquarePrepaTeachingsTest {

    AbstractFactoryStudent dut;
    AbstractFactoryStudent licence;
    AbstractFactoryStudent prepa;
    SquarePrepaTeachings squarePrepaTeachings;
    @BeforeEach
    void setUp() {
        dut= new ConcreteFactoryDUT();
        licence= new ConcreteFactoryLicence();
        prepa= new ConcreteFactoryPrepa();
        squarePrepaTeachings= new SquarePrepaTeachings();
    }

    @AfterEach
    void tearDown() {
        dut= null;
        licence= null;
        prepa= null;
        squarePrepaTeachings= null;
    }

    @Test
    void execute() {
        licence.increaseSkillLevel(4);
        licence.setSquareNumber(5);

        assertEquals(4, licence.getSkillLevel());
        assertFalse(5 == licence.getSkillLevel());

        squarePrepaTeachings.execute(licence);

        assertEquals(5, licence.getSkillLevel());
        assertFalse(4 == licence.getSkillLevel());

        assertEquals(4,licence.getSquareNumber());
        assertFalse(5 == licence.getSquareNumber());


        prepa.increaseSkillLevel(4);
        prepa.setSquareNumber(5);

        assertEquals(4, prepa.getSkillLevel());
        assertFalse(5 == prepa.getSkillLevel());

        squarePrepaTeachings.execute(prepa);

        assertEquals(5, prepa.getSkillLevel());
        assertFalse(4 == prepa.getSkillLevel());

        assertEquals(6,prepa.getSquareNumber());
        assertFalse(5 == prepa.getSquareNumber());


        dut.increaseSkillLevel(4);
        dut.setSquareNumber(5);

        assertEquals(4, dut.getSkillLevel());
        assertFalse(5 == dut.getSkillLevel());

        squarePrepaTeachings.execute(dut);

        assertEquals(5, dut.getSkillLevel());
        assertFalse(4 == dut.getSkillLevel());

        assertEquals(4,dut.getSquareNumber());
        assertFalse(5 == dut.getSquareNumber());


    }
}