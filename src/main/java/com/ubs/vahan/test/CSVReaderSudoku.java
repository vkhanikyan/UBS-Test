package com.ubs.vahan.test;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * Used enum as it is comfortable to use it as util class.
 * As enum it by default supports that the class can't be extended and instantiated by the users
 */
public enum CSVReaderSudoku {
    ;

    public static String[][] read(String filePath) throws IOException {
        filePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8.toString());
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withSkipLines(0)
                .withCSVParser(parser)
                .build()) {
            List<String[]> rows = new LinkedList<>();

            String[] nextLine;
            //Read one line at a time
            while ((nextLine = reader.readNext()) != null) {
                rows.add(nextLine);
            }
            return rows.toArray(new String[][]{});
        }
    }

    public static int[][] readInts(String filePath) throws IOException {
        String[][] stringMatrix = read(filePath);
        if (stringMatrix.length == 0 || stringMatrix[0].length == 0) {
            return new int[0][0];
        }
        int[][] intMatrix = new int[stringMatrix.length][stringMatrix[0].length];
        for (int i = 0; i < stringMatrix.length; i++) {
            for (int j = 0; j < stringMatrix[i].length; j++) {
                intMatrix[i][j] = Integer.parseInt(stringMatrix[i][j].trim());
            }
        }
        return intMatrix;
    }
}
