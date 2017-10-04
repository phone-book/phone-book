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
        this.fileName = Paths.get(directory, fileName);
    }

    private Path directory;
    private Path fileName;


    public void createDirectory () throws IOException {
        if (!Files.exists(this.fileName.getParent())) {
            Files.createDirectory(this.fileName.getParent());
        }
    }

    public void createFile () throws IOException {
        if (!Files.exists(this.fileName)) {
            Files.createFile(this.fileName);
        }
    }



}
