package org.example;

import org.example.functions.SortingFunc;
import org.example.functions.SortingFuncForIntegerValues;
import org.example.functions.SortingFuncForStringValues;

import java.util.List;

public class SortingFactory {

    public static SortingFunc getSortingFunc(List<TypesOfSorting> types) {
        SortingFunc sortingFunc = null;
        switch (types.get(0)) {
            case STRING:
                sortingFunc = new SortingFuncForStringValues();
                break;
            case INTEGER:
                sortingFunc = new SortingFuncForIntegerValues();
                break;
        }
        return sortingFunc;
    }
}
