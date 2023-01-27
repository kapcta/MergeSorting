package org.example;

import org.example.functions.SortingFuncForIntegerValues;
import org.example.functions.SortingFuncForStringValues;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class SortingFactory {

    public static <T> List<T> getSortingFunc(@NotNull List<TypesOfSorting> types, Map<Integer, BufferedReader> map) {
        List<T> result = new ArrayList<>();
        try {
            for (TypesOfSorting type :
                    types) {
                if (type == TypesOfSorting.STRING) {
                    result = (List<T>) SortingFuncForStringValues.sort(map);
                } else if (type == TypesOfSorting.INTEGER) {
                    result = (List<T>) SortingFuncForIntegerValues.sort(map);
                }

                if (type == TypesOfSorting.DESCENDING) {
                    Collections.reverse(result);
                }
            }
        } catch (IOException e) {
            System.out.println("Issue has been occurred during file reading");
        }
        return result;
    }
}
