package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Example {
    public static void main(String[] args) throws Exception {
        Path src = Path.of("source.txt");
        Path dest = Path.of("destination.txt");

        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }
}
