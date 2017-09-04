package pl.sda.javawwa.streamCwiczenia.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {

    public static List<String[]> readCsvFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            List<String[]> result = new ArrayList<>();
            String line = br.readLine();
            String delimiter = ",";

            while (line != null) {
                String row[] = line.split(delimiter);
                result.add(row);
                line = br.readLine();
            }
            return result;

        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.err.println("Błąd podczas otwierania pliku: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static List<String[]> readCsvFileByStream(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            List<String[]> result;

            String delimiter = ",";
            result = br.lines()
                    .map(s -> s.split(delimiter))
                    .collect(Collectors.toList());

            return result;

        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.err.println("Błąd podczas otwierania pliku: " + e.getMessage());
        }
        return new ArrayList<>();
    }


}
