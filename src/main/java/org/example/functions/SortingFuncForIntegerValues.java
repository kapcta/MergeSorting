package org.example.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class SortingFuncForIntegerValues {
    public static List<Integer> sort(Map<Integer, BufferedReader> map) throws IOException {
        int bufferSize = map.size();
        Map<Integer, Integer> buffer = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int k = 0; k < bufferSize; k++) {
            buffer.put(k, Integer.parseInt(map.get(k).readLine()));
        }

        do {
            int place = Collections.min(map.keySet());
            int target = buffer.get(place);
            for (Map.Entry<Integer, Integer> entry :
                    buffer.entrySet()) {
                if (target > entry.getValue()) {
                    target = entry.getValue();
                    place = entry.getKey();
                }
            }

            result.add(buffer.get(place));

            if (!map.get(place).ready()) {
                map.get(place).close();
                map.remove(place);
                buffer.remove(place);

            } else {
                buffer.put(place, Integer.parseInt(map.get(place).readLine()));
            }

        } while (!map.isEmpty());

        return result;
    }
}
