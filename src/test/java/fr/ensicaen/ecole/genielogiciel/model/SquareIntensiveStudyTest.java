package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareIntensiveStudyTest {
    AbstractFactoryStudent student;
    SquareIntensiveStudy squareIntensiveStudy;
    List<Square> board;

    @BeforeEach
    void setUp() {
        student= new ConcreteFactoryPrepa();
        squareIntensiveStudy= new SquareIntensiveStudy();
        board = new ArrayList<>();
        for (int i = 0; i < 63; i++) {
            board.add(new SquareBasic());
        }
        board.add(5, squareIntensiveStudy);
    }

    @AfterEach
    void tearDown() {
        student = null;
        squareIntensiveStudy = null;
        board = null;
    }

    @Test
    void execute() {
        student.increaseSkillLevel(5);
        student.setSquareNumber(5);
        squareIntensiveStudy.execute(student, 0, board);

        assertEquals(8, student.getSkillLevel());
        assertEquals(12,student.getSquareNumber());
    }
}