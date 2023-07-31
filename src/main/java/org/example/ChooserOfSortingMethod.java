package org.example;

import org.example.functions.SortingFunc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ChooserOfSortingMethod {

    private List<?> result;
    private final Map<Integer, BufferedReader> readers;
    private final SortingFunc sortingFunc;
    private final List<TypesOfSorting> types;

    public ChooserOfSortingMethod(List<?> result, SortingFunc sortingFunc, Map<Integer, BufferedReader> readers, List<TypesOfSorting> types) {
        this.result = result;
        this.sortingFunc = sortingFunc;
        this.readers = readers;
        this.types = types;
    }

    public void chooseSortingMethod() throws IOException {
        if (isDescending()) {
            result = sortingFunc.sort(readers);
            Collections.reverse(result);
        } else {
            result = sortingFunc.sort(readers);
        }
    }

    private boolean isDescending() {
        return types.contains(TypesOfSorting.DESCENDING);
    }

    public List<?> getResult() {
        return result;
    }
}
