package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareInformaticsIssuesTest {
    AbstractFactoryStudent student_prepa;
    AbstractFactoryStudent student_licence;
    SquareInformaticsIssues squareInformaticsIssues;
    @BeforeEach
    void setUp() {
        student_prepa=  new ConcreteFactoryPrepa();
        student_licence= new ConcreteFactoryLicence();
        squareInformaticsIssues = new SquareInformaticsIssues();
    }

    @AfterEach
    void tearDown() {
        student_prepa= null;
        student_licence= null;
        squareInformaticsIssues= null;
    }

    @Test
    void execute() {
        assertFalse(student_licence.hasInformaticsProblem());
        assertFalse(student_prepa.hasInformaticsProblem());

        squareInformaticsIssues.execute(student_licence, 0, null);

        assertFalse(student_prepa.hasInformaticsProblem());
        assertTrue(student_licence.hasInformaticsProblem());
        assertFalse(student_prepa.equals(squareInformaticsIssues.getCharacterInSquare()));
        assertTrue(student_licence.equals(squareInformaticsIssues.getCharacterInSquare()));

        squareInformaticsIssues.execute(student_prepa, 0, null);

        assertFalse(student_prepa.equals(squareInformaticsIssues.getCharacterInSquare()));
        assertFalse(student_licence.equals(squareInformaticsIssues.getCharacterInSquare()));
        assertEquals(null, squareInformaticsIssues.getCharacterInSquare());
        assertFalse(student_prepa.hasInformaticsProblem());
        assertFalse(student_licence.hasInformaticsProblem());
    }
}