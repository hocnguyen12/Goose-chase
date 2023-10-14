package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryDUT;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryPrepa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    List<AbstractFactoryStudent> players;

    @BeforeEach
    void setUp() {
        game = new Game();
        players = new ArrayList<>();

    }

    @AfterEach
    void tearDown() {
        game = null;
        players = null;
    }
    @Test
    void start() {
        List<String> l = new ArrayList<>();
        l.add("Licence");
        l.add("Prepa");
        Exception exception = assertThrows(InvalidPlayersCount.class, () -> {
            game.start(5, l);
        });

        l.add("DUT");
        l.add("Licence");
        l.add("Prepa");
        Exception exception1 = assertThrows(InvalidTypeListSize.class, () -> {
            game.start(4, l);
        });

        l.clear();
        l.add("Licence");
        l.add("Prepa");
        l.add("DUT");
        try {
            game.start(3, l);
        } catch (InvalidTypeListSize e) {
            throw new RuntimeException(e);
        } catch (InvalidPlayersCount e) {
            throw new RuntimeException(e);
        }
        assertTrue(game.getPlayers().get(0) instanceof ConcreteFactoryLicence);
        assertTrue(game.getPlayers().get(1) instanceof ConcreteFactoryPrepa);
        assertTrue(game.getPlayers().get(2) instanceof ConcreteFactoryDUT);
    }

    @Test
    void gameIsFinished() {
        List<String> l = new ArrayList<>();
        l.add("Licence");
        l.add("Prepa");

        try {
            game.start(2, l);
        } catch (InvalidPlayersCount e) {
            throw new RuntimeException(e);
        } catch (InvalidTypeListSize e) {
            throw new RuntimeException(e);
        }

        assertFalse(game.gameIsFinished());
        //licence.setSquareNumber(63);
        (game.getPlayers().get(0)).setSquareNumber(63);
        assertTrue(game.gameIsFinished());
        (game.getPlayers().get(0)).setSquareNumber(0);

        //prepa.setInformaticsProblem(true);
        (game.getPlayers().get(1)).setInformaticsProblem(true);
        assertFalse(game.gameIsFinished());
        //licence.setInformaticsProblem(true);
        (game.getPlayers().get(0)).setInformaticsProblem(true);
        assertTrue(game.gameIsFinished());
        //prepa.setBDE(true);
        (game.getPlayers().get(1)).setInformaticsProblem(false);
        (game.getPlayers().get(1)).setBDE(true);
        assertTrue(game.gameIsFinished());
        //licence.setBDE(true);
        (game.getPlayers().get(0)).setInformaticsProblem(false);
        (game.getPlayers().get(0)).setBDE(true);
        assertTrue(game.gameIsFinished());
        //prepa.setBDE(false);
        (game.getPlayers().get(1)).setBDE(false);
        assertFalse(game.gameIsFinished());
    }

    @Test
    void computeWages(){
        List<String> l2 = new ArrayList<>();
        l2.add("Prepa");
        l2.add("Licence");
        Game game = new Game();
        try {
            game.start(2,l2);
        } catch (InvalidPlayersCount e) {
            throw new RuntimeException(e);
        } catch (InvalidTypeListSize e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < l2.size(); i++) {
            game.getPlayers().get(i).increaseSkillLevel((i + 1) * 8);
        }
        List<String> salaire2 = game.computeWages();
        assertEquals("32083 €", salaire2.get(0));
        assertEquals("44917 €", salaire2.get(1));
    }
}