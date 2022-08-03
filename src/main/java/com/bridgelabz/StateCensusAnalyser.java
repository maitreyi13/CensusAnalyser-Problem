package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Objects;

public class StateCensusAnalyser {
    public int loadIndianCensusData(String csvFilePath) throws StateCensusAnalyserException {
        int recordCount = 0;
        if (!Objects.equals(getFileExtension(csvFilePath), ".csv"))
            throw new StateCensusAnalyserException(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.NO_SUCH_TYPE_FOUND,"Wrong input type");
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVStateCensus.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder
                    .build();
            Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
            while (censusCSVIterator.hasNext()) {
                System.out.print(recordCount++ +"  ");
                CSVStateCensus censusCSV = censusCSVIterator.next();
                System.out.print("state: " +censusCSV.getState()+", ");
                System.out.print("population: " +censusCSV.getPopulation()+", ");
                System.out.print("area: " +censusCSV.getAreaInSqKm()+", ");
                System.out.print("density: " +censusCSV.getDensityPerSqKm()+", ");
                System.out.println();
            }
        } catch (IOException e) {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.NO_SUCH_FILE_FOUND,
                    e.getMessage());
        }catch (RuntimeException e) {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.WRONG_DELIMITER, "File not found");
        }
        return recordCount;
    }
    private static String getFileExtension(String file) {
        String extension = "";
        try {
            if (file != null) {
                extension = file.substring(file.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }
        return extension;
    }

    public static void main(String[] args) {
        System.out.println("***** Indian States Census Analyser Problem *****");
    }
}