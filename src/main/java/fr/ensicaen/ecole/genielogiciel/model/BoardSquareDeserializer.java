package fr.ensicaen.ecole.genielogiciel.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BoardSquareDeserializer extends JsonDeserializer<Square>{
    @Override
    public Square deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String type = node.get("type").asText();

        // Vous devez implémenter la logique pour créer une instance de Square
        // en fonction du type spécifié dans le fichier JSON
        if ("SquareStart".equals(type)) {
            return new SquareStart();
        } else if ("SquareBasic".equals(type)) {
            return new SquareBasic();
        } else if ("SquareExam".equals(type)) {
            return new SquareExam();
        } else if ("SquareParty".equals(type)) {
            return new SquareParty();
        } else if ("SquareEnd".equals(type)) {
            return new SquareEnd();
        } else {
            // Gérez les types de cases inconnus ou non pris en charge
            throw new IllegalArgumentException("Type de case inconnu : " + type);
        }
    }
}
