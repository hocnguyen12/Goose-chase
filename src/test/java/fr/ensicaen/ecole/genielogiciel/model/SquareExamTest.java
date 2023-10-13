package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareExamTest {
    AbstractFactoryStudent student;
    SquareExam exam;
    List<Square> board;

    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryLicence();
        exam= new SquareExam();
        board = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            board.add(new SquareBasic());
        }
        board.add(5, new SquareDUTTeachings());
    }

    @AfterEach
    void tearDown() {
        student= null;
        exam= null;
        board = null;
    }

    @Test
    void execute() {
        student.increaseSkillLevel(10);
        student.setSquareNumber(5);
        exam.execute(student, 0, board);
        assertEquals(5, student.getSquareNumber());

        student.increaseSkillLevel(-4); // 6
        assertEquals(6, student.getSkillLevel());
        exam.execute(student, 0, board);
        assertEquals(3, student.getSquareNumber());

        student.increaseSkillLevel(-4);
        exam.execute(student, 0, board);
        assertEquals(0, student.getSquareNumber());
    }

    @Test
    void get_squareName() {
    }
}