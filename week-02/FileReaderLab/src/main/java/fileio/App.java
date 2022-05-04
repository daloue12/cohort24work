package main.java.fileio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<String> lines = getTextFromFile("./data/README.txt");

        for (String line : lines) {
            if (line.startsWith("CREATE")){
                create(line);

            } else if (line.startsWith("APPEND")) {
                append(line);

            } else if (line.startsWith("DELETE")) {

            }else if (line.startsWith("COPY")) {

            }

        }


    }

    private static List<String> getTextFromFile(String fileName) {
        List<String> lines = new ArrayList<>();

            try (FileReader fileReader = new FileReader(fileName);
                 BufferedReader reader = new BufferedReader(fileReader)) {
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
    }

    static void create(String line) {
        String[] parts = line.split(" ");
        String fileName = parts[1];
        File file = new File(fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void append(String line) {
        String[] parts = line.split(" ");
        String fileName = parts[1];

        try (FileWriter fileWriter = new FileWriter("data/" + fileName, true);
        PrintWriter writer = new PrintWriter(fileWriter)) {
            for (int i = 2; i < parts.length; i ++) {
                writer.print(parts[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void delete(String line) {

    }

    static void copy(String line) {

    }


}
