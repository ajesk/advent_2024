package io.acode.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger log = LogManager.getLogger();

    public static Stream<String> readFile(String fileName) {
        final var loader = Thread.currentThread().getContextClassLoader().getResource(fileName);

        try {
            final var uri = loader.getFile();
            return Files.lines(Paths.get(uri));
        } catch (IOException e) {
            log.error("unable to read file");
        } catch (NullPointerException npe) {
            log.error("file does not exist");
        }
        return Stream.empty();
    }

}
