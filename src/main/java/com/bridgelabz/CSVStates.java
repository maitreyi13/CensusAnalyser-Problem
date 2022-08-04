//UC2
package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVStates {
    public int loadIndianStateCodeData(String csvFilePath) {
        int recordCount1 = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBean<IndianStateCode> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(IndianStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndianStateCode> statesCSVIterator = csvToBean.iterator();
            while (statesCSVIterator.hasNext()) {
                IndianStateCode censusCSV = statesCSVIterator.next();
                ++recordCount1;
                System.out.print("SrNo: " + censusCSV.getSrNo() + ", ");
                System.out.print("state: " + censusCSV.getState() + ", ");
                System.out.print("Name: " + censusCSV.getName() + ", ");
                System.out.print("TIN: " + censusCSV.getTin() + ", ");
                System.out.print("StateCode: " + censusCSV.getStateCode() + ", ");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordCount1;
    }
}