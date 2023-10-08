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

        if ("SquareBasic".equals(type)) {
            return new SquareBasic();
        } else if ("SquareClass".equals(type)) {
            return new SquareClass();
        } else if ("SquareDayAfterWEI".equals(type)) {
            return new SquareDayAfterWEI();
        } else if ("SquareDropout".equals(type)) {
            return new SquareDropout();
        } else if ("SquareDUTTeachings".equals(type)) {
            return new SquareDUTTeachings();
        } else if ("SquareEnd".equals(type)) {
            return new SquareEnd();
        } else if ("SquareExam".equals(type)) {
            return new SquareExam();
        } else if ("SquareInternshipAbroad".equals(type)) {
            return new SquareEnd();
        } else if ("SquareParty".equals(type)) {
            return new SquareParty();
        } else if ("SquarePrepaTeachings".equals(type)) {
            return new SquarePrepaTeachings();
        } else if ("SquareStart".equals(type)) {
            return new SquareStart();
        } else if ("SquareToeicFail".equals(type)) {
            return new SquareToeicFail();
        }else if ("SquareUniTeachings".equals(type)) {
                return new SquareUniTeachings();
        } else {
            throw new IllegalArgumentException("Type de case inconnu : " + type);
        }
    }
}
