package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquarePrepaTeachingsTest {

    AbstractFactoryStudent dut;
    AbstractFactoryStudent licence;
    AbstractFactoryStudent prepa;
    SquarePrepaTeachings squarePrepaTeachings;
    List<Square> board;

    @BeforeEach
    void setUp() {
        dut= new ConcreteFactoryDUT();
        licence= new ConcreteFactoryLicence();
        prepa= new ConcreteFactoryPrepa();
        squarePrepaTeachings= new SquarePrepaTeachings();
        board = new ArrayList<>();
        for (int i = 0; i < 63; i++) {
            board.add(new SquareBasic());
        }
        board.add(5, squarePrepaTeachings);
    }

    @AfterEach
    void tearDown() {
        dut = null;
        licence = null;
        prepa = null;
        squarePrepaTeachings = null;
        board = null;
    }

    @Test
    void execute() {
        licence.increaseSkillLevel(4);
        licence.setSquareNumber(5);
        squarePrepaTeachings.execute(licence, 0, board);
        assertEquals(5, licence.getSkillLevel());
        assertEquals(4,licence.getSquareNumber());

        prepa.increaseSkillLevel(4);
        prepa.setSquareNumber(5);
        squarePrepaTeachings.execute(prepa, 0, board);
        assertEquals(5, prepa.getSkillLevel());
        assertEquals(6,prepa.getSquareNumber());

        dut.increaseSkillLevel(4);
        dut.setSquareNumber(5);
        squarePrepaTeachings.execute(dut, 0, board);
        assertEquals(5, dut.getSkillLevel());
        assertEquals(4,dut.getSquareNumber());
    }
}