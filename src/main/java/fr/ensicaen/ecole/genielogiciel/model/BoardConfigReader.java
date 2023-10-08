package fr.ensicaen.ecole.genielogiciel.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BoardConfigReader {
    public BoardConfig readBoardConfig() throws IOException {
        // Récupérez le chemin du fichier JSON depuis les ressources
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("fr/ensicaen/ecole/genielogiciel/board_config.json");

        // Copiez le contenu du fichier JSON dans un fichier temporaire
        Path tempFile = Files.createTempFile("board_config", ".json");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        // Créez un objet ObjectMapper (de Jackson)
        ObjectMapper objectMapper = new ObjectMapper();

        // Lisez le fichier JSON temporaire et convertissez-le en instance de BoardConfiguration
        return objectMapper.readValue(tempFile.toFile(), BoardConfig.class);
    }
}

