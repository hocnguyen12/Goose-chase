package fr.ensicaen.ecole.genielogiciel.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BoardConfigReader {
    public BoardConfig readBoardConfig(String path) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);

        Path tempFile = Files.createTempFile("board_config", ".json");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(tempFile.toFile(), BoardConfig.class);
    }
}

