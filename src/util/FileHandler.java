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
    Scanner input = new Scanner(System.in);

    public FileHandler(String directory, String fileName) {
        this.directory = Paths.get(directory);
        this.fileName = Paths.get(directory, fileName).toAbsolutePath();
    }

    List<String> contacts = new ArrayList<String>();

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


    ///// Create file.
    public void createFile () throws IOException {
        if (!Files.exists(fileName)) {
            Files.createFile(this.fileName);
        }
        Path filePath = fileName.toAbsolutePath();
    }


    ///////
    public void readFile (Path fileName) throws IOException {
        System.out.println(Files.readAllLines(fileName));
    }


    public void writeFile() throws IOException {
        System.out.println("What is the name of your new contact?");
        String userInput = input.nextLine();
        System.out.println("Please enter phone number as follows: (xxx)xxx-xxxx");
        String userNum = input.nextLine();
        contacts.add(userInput + ", " + userNum);
        Files.write(fileName, contacts, StandardOpenOption.APPEND);
    }



}
