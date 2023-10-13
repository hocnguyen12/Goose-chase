package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import fr.ensicaen.ecole.genielogiciel.model.square.Square;
import fr.ensicaen.ecole.genielogiciel.model.square.SquareClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareClassTest {
    Square regularClass;
    AbstractFactoryStudent student;
    @BeforeEach
    void setUp() {
        regularClass = new SquareClass();
        student = new ConcreteFactoryLicence();
    }

    @AfterEach
    void tearDown() {
        regularClass= null;
        student= null;
    }

    @Test
    void execute() {
        regularClass.execute(student, 0, null);
        assertEquals(1, student.getSkillLevel());

        student.increaseSkillLevel(100);
        regularClass.execute(student, 0, null);
        assertEquals(102, student.getSkillLevel());
    }
}