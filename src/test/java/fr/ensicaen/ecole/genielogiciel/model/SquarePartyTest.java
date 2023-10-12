package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquarePartyTest {

    AbstractFactoryStudent student;
    SquareParty square_party;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryPrepa();
        square_party= new SquareParty();
    }

    @AfterEach
    void tearDown() {
        student= null;
        square_party= null;
    }

    @Test
    void execute() {
        student.increaseSkillLevel(6);

        assertEquals(6, student.getSkillLevel());
        assertNotEquals(5, student.getSkillLevel());

        square_party.execute(student, 0, null);

        assertEquals(5, student.getSkillLevel());
        assertNotEquals(6, student.getSkillLevel());

    }
}