package com.bridgelabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class StateCensusAnalyserTest {
    private static final String STATE_CENSUS_DATA_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    StateCensusAnalyser censusAnalyserProblem = new StateCensusAnalyser();
    @Test
    void givenIndianCensusCsvFile_WhenProper_ShouldReturnCorrectRecord() {
        System.out.println("TC1");
        int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(STATE_CENSUS_DATA_PATH);
        Assertions.assertEquals(29,numberOfRecord);
    }
}