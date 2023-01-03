package org.example;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, BufferedReader> READERS = CreatorOfReaders.createOfReaders(args);
        List<Integer> result = SortingFunc.sort(READERS);
        WritingToFile.write(result, args);
    }

}