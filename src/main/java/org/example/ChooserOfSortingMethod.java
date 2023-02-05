package org.example;

import org.example.functions.SortingFunc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ChooserOfSortingMethod {

    private List<?> result;

    public ChooserOfSortingMethod(List<?> result) {
        this.result = result;
    }

    public List<?> getResult() {
        return result;
    }

    public void sortingMethod(List<TypesOfSorting> types, SortingFunc sortingFunc, Map<Integer, BufferedReader> map) {
        try {
            if (types.get(1) == TypesOfSorting.DESCENDING) {
                result = sortingFunc.sort(map);
                Collections.reverse(result);
            } else {
                result = sortingFunc.sort(map);
            }
        } catch (IOException e) {
            System.out.println("Issue has been occur during file reading! Please check types of reading parameters");
        }
    }
}
