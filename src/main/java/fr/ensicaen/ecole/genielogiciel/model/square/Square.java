package fr.ensicaen.ecole.genielogiciel.model.square;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.json.BoardSquareDeserializer;

import java.util.List;

@JsonDeserialize(using = BoardSquareDeserializer.class)
public interface Square {

    void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board);

    String getSquareName();
}