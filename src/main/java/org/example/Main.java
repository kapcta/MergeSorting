package org.example;

import org.example.functions.SortingFunc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandLineParser parser = new CommandLineParser(args);
        parser.createSortingMethodsList();
        parser.createInputFileNames();
        parser.createOutputFileName();

        FileReaders fileReaders = new FileReaders();
        fileReaders.createFileReaders(parser.getInputFileNames());

        Map<Integer, BufferedReader> readers = fileReaders.getReaders();
        List<TypesOfSorting> typesOfSorting = parser.getListOfTypes();

        SortingFunc sortingFunc = SortingFactory.getSortingFunc(typesOfSorting);

        ChooserOfSortingMethod chooserOfSortingMethod = new ChooserOfSortingMethod(new ArrayList<>(), sortingFunc, readers, typesOfSorting);
        chooserOfSortingMethod.chooseSortingMethod();

        List<?> result = chooserOfSortingMethod.getResult();


        WritingToFile writingToFile = new WritingToFile(parser.getOutputFileName());
        writingToFile.writeToFile(result);

    }

}