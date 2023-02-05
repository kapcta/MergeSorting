package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaders {

    private final Map<Integer, BufferedReader> readers;

    public FileReaders() {
        this.readers = new HashMap<>();
    }

    public Map<Integer, BufferedReader> getReaders() {
        return readers;
    }

    public void creationOfFileReaders(List<String> inputFileNames) {

        int key = 0;

        for (String inputFileName :
                inputFileNames) {
            try {
                readers.put(key, new BufferedReader(new FileReader(inputFileName)));
                key += 1;
            } catch (FileNotFoundException e) {
                System.out.println("Input filepath selected not found! Please check filepath");
            }
        }
    }
}
