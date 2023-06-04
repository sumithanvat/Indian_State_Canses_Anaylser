package com.indianstatescenus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyser {
    private List<String[]> records;

    public StateCensusAnalyser() {
        this.records = new ArrayList<>();
    }

    public void loadCSVData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            records.add(data);
        }
        reader.close();
    }

    public int getNumberOfRecords() {
        return records.size();
    }

    public Iterator<String[]> getDataIterator() {
        return records.iterator();
    }

    public static void main(String[] args) {
        String filePath = "path/to/state_census.csv";

        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            analyser.loadCSVData(filePath);
            int numberOfRecords = analyser.getNumberOfRecords();
            System.out.println("Number of records: " + numberOfRecords);

            // Example usage of iterator
            Iterator<String[]> iterator = analyser.getDataIterator();
            while (iterator.hasNext()) {
                String[] data = iterator.next();
                // Process each data record
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
