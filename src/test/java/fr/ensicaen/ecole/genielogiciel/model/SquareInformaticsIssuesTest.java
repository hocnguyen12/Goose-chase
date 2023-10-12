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

        squareInformaticsIssues.execute(student_licence);

        assertFalse(student_prepa.hasInformaticsProblem());
        assertTrue(student_licence.hasInformaticsProblem());
        assertFalse(student_prepa.equals(squareInformaticsIssues.getStudent()));
        assertTrue(student_licence.equals(squareInformaticsIssues.getStudent()));

        squareInformaticsIssues.execute(student_prepa);

        assertTrue(student_prepa.equals(squareInformaticsIssues.getStudent()));
        assertFalse(student_licence.equals(squareInformaticsIssues.getStudent()));
        assertTrue(student_prepa.hasInformaticsProblem());
        assertFalse(student_licence.hasInformaticsProblem());

    }
}