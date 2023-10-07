package fr.ensicaen.ecole.genielogiciel.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BoardConfigReader {
    public BoardConfig readBoardConfig() {
        try {
            // Create an ObjectMapper (from Jackson)
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file and convert it into an instance of BoardConfiguration
            BoardConfig boardConfig = objectMapper.readValue(
                    new File("board_config.json"), // Path to your JSON file
                    BoardConfig.class
            );

            // Access the board configuration data
            int size = boardConfig.getSize();
            //List<String> squares = boardConfig.getSquares();

            // Do something with this data...
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
