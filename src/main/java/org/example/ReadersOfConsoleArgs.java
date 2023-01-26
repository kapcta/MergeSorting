package org.example;

import java.util.ArrayList;
import java.util.List;

public class ReadersOfConsoleArgs {

    public static List<TypesOfConsoleArguments> read(String... args) {
        List<TypesOfConsoleArguments> listOfTypes = new ArrayList<>();
        for (String arg :
                args) {
            if (!arg.endsWith(".txt")) {
                switch (arg) {
                    case "-s":
                        listOfTypes.add(TypesOfConsoleArguments.STRING);
                        break;
                    case "-i":
                        listOfTypes.add(TypesOfConsoleArguments.INTEGER);
                        break;
                    case "-d":
                        listOfTypes.add(TypesOfConsoleArguments.DESCENDING);
                        break;
                    case "-a":
                        listOfTypes.add(TypesOfConsoleArguments.ASCENDING);
                        break;
                }
            }
        }

        if (listOfTypes.size() == 1)
            listOfTypes.add(TypesOfConsoleArguments.ASCENDING);

        return listOfTypes;
    }
}
