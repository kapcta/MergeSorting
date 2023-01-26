package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatorOfReaders {
    private static final Map<Integer, BufferedReader> READERS = new HashMap<>();
    private static final List<String> inputFileNames = new ArrayList<>();

    public static Map<Integer, BufferedReader> createOfReaders(String... args) {
        int key = 0;
        for (String inputFileName :
                creationOfInputFileNames(args)) {
            try {
                READERS.put(key, new BufferedReader(new FileReader(inputFileName)));
                key += 1;
            } catch (FileNotFoundException e) {
                System.out.println("Input filepath selected not found! Please check filepath");
            }
        }
        return READERS;
    }

    private static List<String> creationOfInputFileNames(String... args) {
        Path dir = Paths.get("/Users/milovanov/IdeaProjects/MergeSorting/src/main/java/org/example/testingFiles/");
        for (String arg :
                args) {
            if (arg.endsWith(".txt") && !arg.contains("out.txt"))
                inputFileNames.add(dir.resolve(arg).toString());
        }
        return inputFileNames;
    }
}
