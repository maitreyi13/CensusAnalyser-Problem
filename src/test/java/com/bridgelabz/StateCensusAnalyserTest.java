package com.bridgelabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class StateCensusAnalyserTest {
    private static final String STATE_CENSUS_DATA_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_STATE_CENSUS_DATA_PATH = "./src/main/resources/IndiaStateCensusData.csv";

    StateCensusAnalyser censusAnalyserProblem = new StateCensusAnalyser();
    @Test
    void givenIndianCensusCsvFile_WhenProper_ShouldReturnCorrectRecord() throws StateCensusAnalyserException {
        System.out.println("TC1.1");
        int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(STATE_CENSUS_DATA_PATH) ;
        Assertions.assertEquals(29,numberOfRecord);
    }

    @Test
    void  givenIndianCensusCsvFile_WhenProper_ShouldReturnCorrectRecordWrong_ThrowCustomException() {
        System.out.println("TC 1.2");
        try {
            censusAnalyserProblem.loadIndianCensusData(WRONG_STATE_CENSUS_DATA_PATH);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.NO_SUCH_FILE_FOUND,e.type,"Wrong input file");
        }
    }
}