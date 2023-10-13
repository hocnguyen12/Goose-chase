package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryPrepa;
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

        assertTrue(student_licence.hasInformaticsProblem());
        assertEquals(student_licence, squareInformaticsIssues.getCharacterInSquare());

        squareInformaticsIssues.execute(student_prepa, 0, null);

        assertNull(squareInformaticsIssues.getCharacterInSquare());
        assertFalse(student_prepa.hasInformaticsProblem());
        assertFalse(student_licence.hasInformaticsProblem());
    }
}