package org.example;

import org.example.functions.SortingFuncForIntegerValues;
import org.example.functions.SortingFuncForStringValues;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class FactoryOfSorting {

    public static <T> List<T> sorting(@NotNull List<TypesOfConsoleArguments> types, Map<Integer, BufferedReader> map) {
        List<T> result = new ArrayList<>();
        try {
            for (TypesOfConsoleArguments type :
                    types) {
                if (type == TypesOfConsoleArguments.STRING) {
                    result = (List<T>) SortingFuncForStringValues.sort(map);
                } else if (type == TypesOfConsoleArguments.INTEGER) {
                    result = (List<T>) SortingFuncForIntegerValues.sort(map);
                }

                if (type == TypesOfConsoleArguments.DESCENDING) {
                    Collections.reverse(result);
                }
            }
        } catch (IOException e) {
            System.out.println("Issue has been occurred during file reading");
        }
        return result;
    }
}
