package org.sanskar;

import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class csvReader {
    private static List<ipl> teamList = new ArrayList<>();
    public static List<ipl> readcsv(String filePath) throws IOException{

        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = CSVFormat.DEFAULT.parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get(0);
                String team = csvRecord.get(1);
                String role = csvRecord.get(2);
                String matches = csvRecord.get(3);
                String runs = csvRecord.get(4);
                String average = csvRecord.get(5);
                String sr = csvRecord.get(6);
                String wickets = csvRecord.get(7);

                ipl iplObj = new ipl(name, team, role, matches, runs, average, sr, wickets);
                teamList.add(iplObj);

            }
        }
        return teamList;
    }






}
