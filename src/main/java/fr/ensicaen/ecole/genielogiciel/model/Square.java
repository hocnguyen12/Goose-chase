package fr.ensicaen.ecole.genielogiciel.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = BoardSquareDeserializer.class)
public interface Square {

    void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board);

    String getSquareName();
}