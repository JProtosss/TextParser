package by.epam.training.evgeniyprotasov.task2.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {
    private static final Logger logger = LogManager.getLogger();

    public String fileToString(String filePath){
        String textFromFile;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            textFromFile = new String(bytes);
        } catch (IOException e) {
            logger.fatal("Can't find file: " + filePath, e);
            throw new RuntimeException("Impossible to read file: " + filePath, e);
        }
        return textFromFile;
    }

    public String fileToString(File file){
        return fileToString(file.getAbsolutePath());
    }
}
