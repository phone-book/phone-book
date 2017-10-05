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

import util.Input;

public class FileHandler {
    Scanner input = new Scanner(System.in);
    List<String> contacts;
    List<String> ourList;
    Input utilities = new Input();

    public FileHandler(String directory, String fileName) {
        this.directory = Paths.get(directory);
        this.fileName = Paths.get(directory, fileName).toAbsolutePath();
        this.contacts = new ArrayList<>();
    }


    private Path directory;
    private Path fileName;

    public Path getFileContent() {
        return fileName;
    }

    public void createDirectory() throws IOException {
        if (!Files.exists(directory)) {
            Files.createDirectory(this.directory);
        }
    }


    ///// Create file.
    public void createFile() throws IOException {
        if (!Files.exists(fileName)) {
            Files.createFile(this.fileName);
        }
        Path filePath = fileName.toAbsolutePath();
    }


    ///////
    public List<String> readFile() throws IOException {
        ourList = Files.readAllLines(this.fileName);
        contacts = ourList;
        return ourList;
    }


    public void writeFile() throws IOException {
        Files.write(fileName, contacts);

    }

    public void deleteFile() throws IOException {

    }


}
