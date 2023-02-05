package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {

    private final String[] args;
    private final List<TypesOfSorting> listOfTypes;
    private final List<String> inputFileNames;
    private String outputFileName;

    public CommandLineParser(String[] args) {
        this.args = args;
        this.listOfTypes = new ArrayList<>();
        this.inputFileNames = new ArrayList<>();
    }

    public List<TypesOfSorting> getListOfTypes() {
        return listOfTypes;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public List<String> getInputFileNames() {
        return inputFileNames;
    }

    public void creationOfInputFileNames() {
        Path dir = Paths.get("/Users/milovanov/IdeaProjects/MergeSorting/src/main/java/org/example/testingFiles/");

        for (String arg :
                args) {
            if (arg.endsWith(".txt") && !arg.contains("out.txt"))
                inputFileNames.add(dir.resolve(arg).toString());
        }
    }

    public void creationOfOutputFileName() {
        Path dir = Paths.get("/Users/milovanov/IdeaProjects/MergeSorting/src/main/java/org/example/testingFiles/");
        for (String arg :
                args) {
            if (arg.contains("out") && arg.endsWith(".txt")) {
                outputFileName = dir.resolve(arg).toString();
            }
        }
    }

    public void creationOfSortingMethodsList() {
        for (String arg :
                args) {
            if (!arg.endsWith(".txt")) {
                switch (arg) {
                    case "-s":
                        listOfTypes.add(TypesOfSorting.STRING);
                        break;
                    case "-i":
                        listOfTypes.add(TypesOfSorting.INTEGER);
                        break;
                    case "-d":
                        listOfTypes.add(TypesOfSorting.DESCENDING);
                        break;
                    case "-a":
                        listOfTypes.add(TypesOfSorting.ASCENDING);
                        break;
                }
            }
        }

        if (listOfTypes.size() == 1)
            listOfTypes.add(TypesOfSorting.ASCENDING);
    }
}
