package org.example;

import org.example.functions.SortingFunc;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CommandLineParser parser = new CommandLineParser(args);
        parser.creationOfSortingMethodsList();
        parser.creationOfInputFileNames();
        parser.creationOfOutputFileName();

        FileReaders fileReaders = new FileReaders();
        fileReaders.creationOfFileReaders(parser.getInputFileNames());

        Map<Integer, BufferedReader> readers = fileReaders.getReaders();
        List<TypesOfSorting> typesOfSorting = parser.getListOfTypes();

        SortingFunc sortingFunc = SortingFactory.getSortingFunc(typesOfSorting);

        ChooserOfSortingMethod chooserOfSortingMethod = new ChooserOfSortingMethod(new ArrayList<>());
        chooserOfSortingMethod.sortingMethod(typesOfSorting, sortingFunc, readers);

        List<?> result = chooserOfSortingMethod.getResult();


        WritingToFile writingToFile = new WritingToFile(parser.getOutputFileName());
        writingToFile.writeToFile(result);

    }

}