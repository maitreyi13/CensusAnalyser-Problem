package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public int loadIndianCensusData(String csvFilePath)  {
        int recordCount=0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
        {
            CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVStateCensus.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder
                    .build();
            Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
            while (censusCSVIterator.hasNext()) {
                System.out.print(recordCount+++"  ");
                CSVStateCensus censusCSV = censusCSVIterator.next();
                System.out.print("state:"+censusCSV.getState()+", ");
                System.out.print("population"+censusCSV.getPopulation()+", ");
                System.out.print("area"+censusCSV.getAreaInSqKm()+", ");
                System.out.print("density"+censusCSV.getDensityPerSqKm()+", ");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordCount;
    }

    public static void main(String[] args) {
        System.out.println("***** Indian States Census Analyser Problem *****");
    }
}