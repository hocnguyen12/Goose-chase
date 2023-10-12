package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareUniTeachingsTest {

    AbstractFactoryStudent dut;
    AbstractFactoryStudent licence;
    AbstractFactoryStudent prepa;
    SquareUniTeachings squareUniTeachings;
    List<Square> board;
    @BeforeEach
    void setUp() {
        dut= new ConcreteFactoryDUT();
        licence= new ConcreteFactoryLicence();
        prepa= new ConcreteFactoryPrepa();
        squareUniTeachings= new SquareUniTeachings();
        board = new ArrayList<>();
        for (int i = 0; i < 63; i++) {
            board.add(new SquareBasic());
        }
        board.add(5, squareUniTeachings);
    }

    @AfterEach
    void tearDown() {
        dut= null;
        licence= null;
        prepa= null;
        squareUniTeachings= null;
        board = null;
    }

    @Test
    void execute() {
        licence.increaseSkillLevel(4);
        licence.setSquareNumber(5);
        squareUniTeachings.execute(licence, 0, board);
        assertEquals(5, licence.getSkillLevel());
        assertEquals(6,licence.getSquareNumber());

        prepa.increaseSkillLevel(4);
        prepa.setSquareNumber(5);
        squareUniTeachings.execute(prepa, 0, board);
        assertEquals(5, prepa.getSkillLevel());
        assertEquals(4,prepa.getSquareNumber());

        dut.increaseSkillLevel(4);
        dut.setSquareNumber(5);
        squareUniTeachings.execute(dut, 0, board);
        assertEquals(5, dut.getSkillLevel());
        assertEquals(4,dut.getSquareNumber());
    }
}