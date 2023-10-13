package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryPrepa;
import fr.ensicaen.ecole.genielogiciel.model.square.SquareInternshipAbroad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareInternshipAbroadTest {
    AbstractFactoryStudent student;
    SquareInternshipAbroad squareInternshipAbroad;
    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryPrepa();
        squareInternshipAbroad= new SquareInternshipAbroad();
    }

    @AfterEach
    void tearDown() {
        student= null;
        squareInternshipAbroad= null;
    }

    @Test
    void execute() {
        student.increaseSkillLevel(6);
        squareInternshipAbroad.execute(student, 0, null);
        assertEquals(8, student.getSkillLevel());
    }
}