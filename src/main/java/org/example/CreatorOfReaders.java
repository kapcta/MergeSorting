package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CreatorOfReaders {
    private static final Map<Integer, BufferedReader> READERS = new HashMap<>();

    public static Map<Integer, BufferedReader> createOfReaders(String ...args) {
        Path dir = Paths.get("/Users/milovanov/IdeaProjects/MergeSorting/src/main/java/org/example/testingFiles/");
        int key = 0;
        for (String arg:
             args) {
            try {
                if (arg.endsWith(".txt") && !arg.contains("out.txt")) {

                    READERS.put(key, new BufferedReader(new FileReader(dir.resolve(arg).toFile())));
                    key +=1;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return READERS;
    }
}
