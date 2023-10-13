package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryPrepa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareToeicFailTest {

    AbstractFactoryStudent student;
    SquareToeicFail squareToeicFail_1;
    SquareToeicFail squareToeicFail_2;
    List<Square> board;
    @BeforeEach
    void setUp() {
        student = new ConcreteFactoryPrepa();
        squareToeicFail_1 = new SquareToeicFail();
        squareToeicFail_2 = new SquareToeicFail();
        board = new ArrayList<>();
        for (int i = 0; i < 62; i++) {
            board.add(new SquareBasic());
        }
        board.add(5, squareToeicFail_1);
        board.add(25, squareToeicFail_2);
    }

    @AfterEach
    void tearDown() {
        student = null;
        squareToeicFail_1 = null;
        squareToeicFail_2 = null;
        board = null;
    }

    @Test
    void execute() {
        student.setSquareNumber(25);

        assertEquals(25, student.getSquareNumber());
        squareToeicFail_2.execute(student, 0, board);
        assertEquals(13,student.getSquareNumber());

        student.setSquareNumber(5);
        assertEquals(5, student.getSquareNumber());
        squareToeicFail_1.execute(student, 0, board);
        assertEquals(0,student.getSquareNumber());
    }
}