package stopwords;

import java.io.*;
import java.util.*;

public class CuentaPalabras_NoStopwords {

    public static void main(String[] args) {
        List<String> f1 = Reader("divina_comedia.txt");
        List<String> StopWords = Reader("stopwords-es.txt");

        String delimitadores = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*|\\d+";

        List<String> archivo = new ArrayList<>();
        for (String line : f1) {
            String[] words = line.split(delimitadores);
            for (String palabra : words) {
                archivo.add(palabra);
            }
        }

        archivo.removeAll(StopWords);

        Set<String> Unique = new TreeSet<>(archivo);

        for (String palabra : Unique)
            System.out.println(palabra);

        System.out.println("\npalabras diferentes = " + Unique.size());

    }
private static List<String> Reader(String FileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader scanner = new BufferedReader(new FileReader(FileName))) {
            String line;
            while ((line = scanner.readLine()) != null) {
                lines.add(line.toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

}