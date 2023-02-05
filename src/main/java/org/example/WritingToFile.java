package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritingToFile {

    private final String outputFileName;

    public WritingToFile(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public <T> void writeToFile(List<T> list) {
        try (FileWriter writer = new FileWriter(outputFileName)) {
            for (T element :
                    list) {
                writer.write(element + "\n");
            }
        } catch (IOException e) {
            System.out.println("Output filepath selected not found! Please check filepath");
        }
    }
}
