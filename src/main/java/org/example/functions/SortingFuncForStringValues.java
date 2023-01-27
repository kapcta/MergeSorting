package org.example.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class SortingFuncForStringValues implements SortingFunc {

    @Override
    public List<String> sort(Map<Integer, BufferedReader> map) throws IOException {
        int bufferSize = map.size();
        Map<Integer, String> buffer = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int k = 0; k < bufferSize; k++) {
            buffer.put(k, map.get(k).readLine());
        }

        do {
            int place = Collections.min(map.keySet());
            String target = buffer.get(place);
            for (Map.Entry<Integer, String> entry :
                    buffer.entrySet()) {
                if (target.compareTo(entry.getValue()) > 0) {
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
                buffer.put(place, map.get(place).readLine());
            }

        } while (!map.isEmpty());

        return result;
    }
}
