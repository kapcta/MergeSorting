package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WritingToFile {

    private static String outputFileName;

    public static void write(List<Integer> list, String ...args) {
        try(FileWriter writer = new FileWriter(creationOfFileName(args))) {
            for (Integer element:
                 list) {
                writer.write(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String creationOfFileName(String @NotNull ...args) {
        Path dir = Paths.get("/Users/milovanov/IdeaProjects/MergeSorting/src/main/java/org/example/testingFiles/");
        for (String arg:
             args) {
            if(arg.contains("out") && arg.endsWith(".txt")) {
                outputFileName = dir.resolve(arg).toString();
            }
        }
        return outputFileName;
    }

}
