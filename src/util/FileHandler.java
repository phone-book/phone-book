package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;

public class FileHandler {

    public FileHandler(String directory, String fileName) {
        this.directory = Paths.get(directory);
        this.fileName = Paths.get(directory, fileName).toAbsolutePath();
    }

    private Path directory;
    private Path fileName;

    public Path getFileContent() {
        return fileName;
    }

    public void createDirectory () throws IOException {
        if (!Files.exists(directory)) {
            Files.createDirectory(this.directory);
        }
    }

    public void createFile () throws IOException {
        if (!Files.exists(fileName)) {
            Files.createFile(this.fileName);
        }
        Path filePath = fileName.toAbsolutePath();
    }


    public void readFile (Path fileName) throws IOException {
        System.out.println(Files.readAllLines(fileName));
    }



}
