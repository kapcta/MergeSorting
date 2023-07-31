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

    public void createInputFileNames() {
        Path dir = Paths.get("../MergeSorting/src/main/java/org/example/testingFiles/");

        for (String arg :
                args) {
            if (isInputFileNames(arg)) {
                inputFileNames.add(dir.resolve(arg).toString());
            }
        }
    }

    private boolean isInputFileNames(String arg) {
        return arg.endsWith(".txt") && !arg.contains("out.txt");
    }

    public void createOutputFileName() {
        Path dir = Paths.get("../MergeSorting/src/main/java/org/example/testingFiles/");

        for (String arg :
                args) {
            if (isOutputFile(arg)) {
                outputFileName = dir.resolve(arg).toString();
            }
        }
    }

    private boolean isOutputFile(String arg) {
        return arg.contains("out") && arg.endsWith(".txt");
    }

    public void createSortingMethodsList() {
        for (String arg :
                args) {
            if (isSortingParameter(arg)) {
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

    private boolean isSortingParameter(String arg) {
        return !arg.endsWith(".txt");
    }
}
