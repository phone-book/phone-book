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


public class FileHandlerTest {
    public static void main(String[] args) throws IOException {

    FileHandler file1 = new FileHandler("resources", "contacts.txt");
    file1.createDirectory();

    }
}
