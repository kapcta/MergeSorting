package org.example;

import java.io.BufferedReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, BufferedReader> READERS = CreatorOfReaders.createOfReaders(args);
        WritingToFile.write(FactoryOfSorting.sorting(ReadersOfConsoleArgs.read(args), READERS), args);
    }

}