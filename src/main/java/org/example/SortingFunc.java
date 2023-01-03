package org.example;


import java.io.*;
import java.util.*;

public class SortingFunc {
    public static List<Integer> sort(Map<Integer, BufferedReader> map) throws IOException {
        int bufferSize = map.size();
        //List<Integer> buffer = new ArrayList<>(bufferSize);
        Map<Integer, Integer> buffer = new HashMap<>();
        List<Integer> result = new ArrayList<>();


        for (int k = 0; k < bufferSize; k++) {
            buffer.put(k, Integer.valueOf(map.get(k).readLine()));
        }

        do {

            int place = map.keySet().stream().min(Comparator.naturalOrder()).get();
            int target = buffer.get(place);
            for (int i = 0; i < buffer.size() - 1; i++) {
                if (target > buffer.get(i + 1)) {
                    target = buffer.get(i + 1);
                    place = i + 1;
                }
            }

            result.add(buffer.get(place));

            if (!map.get(place).ready()) {
                map.get(place).close();
                map.remove(place);
                buffer.remove(place);

            } else {
                buffer.put(place, Integer.valueOf(map.get(place).readLine()));
            }

        } while (!map.isEmpty());

        return result;
    }
}

