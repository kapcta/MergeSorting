package org.example.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SortingFunc {

    List<?> sort(Map<Integer, BufferedReader> map) throws IOException;
}
