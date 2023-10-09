package fr.ensicaen.ecole.genielogiciel.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = BoardSquareDeserializer.class)
public interface Square {
    void execute(AbstractFactoryStudent s);

    String get_squareName();
}


