package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import fr.ensicaen.ecole.genielogiciel.model.square.Square;
import fr.ensicaen.ecole.genielogiciel.model.square.SquareBasic;
import fr.ensicaen.ecole.genielogiciel.model.square.SquareKangaroo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareKangarooTest {
    Square kangaroo;
    AbstractFactoryStudent student;
    List<Square> board;
    @BeforeEach
    void setUp() {
        kangaroo = new SquareKangaroo();
        student = new ConcreteFactoryLicence();
        board = new ArrayList<>();
        for (int i = 0; i < 63; i++) {
            board.add(new SquareBasic());
        }
        board.add(18, kangaroo);
    }

    @AfterEach
    void tearDown() {
        kangaroo = null;
        student = null;
        board = null;
    }

    @Test
    void execute() {
        kangaroo.execute(student, 0, board);
        assertEquals(0, student.getSquareNumber());

        student.move(18);
        kangaroo.execute(student, 18, board);
        assertEquals(36, student.getSquareNumber());
    }
}