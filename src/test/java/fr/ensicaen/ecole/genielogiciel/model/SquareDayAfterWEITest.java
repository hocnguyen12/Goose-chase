package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareDayAfterWEITest {
    Square day_after_wei;
    AbstractFactoryStudent student;
    @BeforeEach
    void setUp() {
        day_after_wei= new SquareDayAfterWEI();
        student= new ConcreteFactoryLicence();
    }

    @AfterEach
    void tearDown() {
        day_after_wei= null;
        student= null;
    }

    @Test
    void execute() {
        assertFalse(student.nextRoundSkipped());
        day_after_wei.execute(student, 0, null);
        assertTrue(student.nextRoundSkipped());
        assertFalse(false == student.nextRoundSkipped());
    }
}