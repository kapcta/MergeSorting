package org.example;

import org.example.functions.SortingFunc;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, BufferedReader> READERS = CreatorOfReaders.createOfReaders(args);
        List<TypesOfSorting> consoleArgs = ReadersOfConsoleArgs.read(args);
        SortingFunc sortingFunc = SortingFactory.getSortingFunc(consoleArgs);
        List<?> result = ChooserOfSortingMethod.getResultChoseFromSortingMethod(consoleArgs, sortingFunc, READERS);
        WritingToFile.writeToFile(result, args);
    }

}