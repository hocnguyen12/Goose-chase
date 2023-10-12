package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareBDETest {

    AbstractFactoryStudent student_prepa;
    AbstractFactoryStudent student_licence;
    SquareBDE squareBDE;
    @BeforeEach
    void setUp() {
        student_prepa=  new ConcreteFactoryPrepa();
        student_licence= new ConcreteFactoryLicence();
        squareBDE = new SquareBDE();
    }

    @AfterEach
    void tearDown() {
        student_prepa= null;
        student_licence= null;
        squareBDE= null;
    }

    @Test
    void execute() {
        assertFalse(student_licence.isBDE());
        assertFalse(student_prepa.isBDE());

        squareBDE.execute(student_licence);

        assertFalse(student_prepa.isBDE());
        assertTrue(student_licence.isBDE());
        assertFalse(student_prepa.equals(squareBDE.getStudent()));
        assertTrue(student_licence.equals(squareBDE.getStudent()));

        squareBDE.execute(student_prepa);

        assertTrue(student_prepa.equals(squareBDE.getStudent()));
        assertFalse(student_licence.equals(squareBDE.getStudent()));
        assertTrue(student_prepa.isBDE());
        assertFalse(student_licence.isBDE());

    }

}