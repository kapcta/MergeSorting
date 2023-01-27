package org.example;

import java.util.ArrayList;
import java.util.List;

public class ReadersOfConsoleArgs {

    public static List<TypesOfSorting> read(String... args) {
        List<TypesOfSorting> listOfTypes = new ArrayList<>();
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

        return listOfTypes;
    }
}
