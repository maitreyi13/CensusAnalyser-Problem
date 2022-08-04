//UC1 UC2
package com.bridgelabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private static final String STATE_CENSUS_DATA_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_STATE_CENSUS_DATA_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_TYPE_STATE_CENSUS_DATA_PATH = "./src/test/resources/IndiaStateCensusData.pdf";
    private static final String WRONG_DELIMITER_STATE_CENSUS_DATA_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_HEADER_STATE_CENSUS_DATA_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String INDIAN_STATE_CODE_INFORMATION_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_INDIAN_STATE_CODE_INFORMATION_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_TYPE_INDIAN_STATE_CODE_INFORMATION_PATH = "./src/test/resources/IndiaStateCode.pdf";
    private static final String WRONG_DELIMITER_CENSUS_DATA_PATH="./src/test/resources/DelimiterCensusData.csv";

    StateCensusAnalyser censusAnalyserProblem = new StateCensusAnalyser();
    CSVStates csvStates = new CSVStates();

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

    @Test
    void givenIndianCensusCsvFile_WhenImproperType_ShouldThrowException() {
        System.out.println("TC 1.3");
        try {
            int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(WRONG_TYPE_STATE_CENSUS_DATA_PATH);
            Assertions.assertEquals(29,numberOfRecord);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.NO_SUCH_TYPE_FOUND,e.type,"Wrong input type");
        }
    }

    @Test
    void  givenIndianCensusCsvFile_WhenImproperDelimiter_ShouldThrowException() {
        System.out.println("TC 1.4");
        try {
            int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(WRONG_DELIMITER_STATE_CENSUS_DATA_PATH);
            Assertions.assertEquals(29,numberOfRecord);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.WRONG_DELIMITER_OR_HEADER,e.type,"Wrong delimiters in file");
        }
    }

    @Test
    void givenIndianCensusCsvFile_WhenImproperHeader_ShouldThrowException() {
        System.out.println("TC 1.5");
        try {
            int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(WRONG_HEADER_STATE_CENSUS_DATA_PATH);
            Assertions.assertEquals(29,numberOfRecord);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.WRONG_DELIMITER_OR_HEADER,e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCsvFile_WhenProper_ShouldReturnCorrectRecordCount() throws StateCensusAnalyserException {
        System.out.println("TC 2.1");
        int numberOfRecord = csvStates.loadIndianStateCodeData(INDIAN_STATE_CODE_INFORMATION_PATH);
        Assertions.assertEquals(37, numberOfRecord);
    }

    @Test
    void givenIndianStateCodeCsvFile_WhenImproper_ShouldThrowException() {
        System.out.println("TC 2.2");
        try {
            int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(WRONG_INDIAN_STATE_CODE_INFORMATION_PATH);
            Assertions.assertEquals(37, numberOfRecord);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.NO_SUCH_FILE_FOUND, e.type,"Wrong input file");
        }
    }

    @Test
    void givenIndianStateCodeCsvFile_WhenImproperType_ShouldThrowException() {
        System.out.println("TC 2.3");
        try {
            int numberOfRecord = csvStates.loadIndianStateCodeData(WRONG_TYPE_INDIAN_STATE_CODE_INFORMATION_PATH);
            Assertions.assertEquals(37, numberOfRecord);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.NO_SUCH_TYPE_FOUND, e.type,"Wrong input type");
        }
    }

    @Test
    void givenIndianStateCodeCsvFile_WhenImproperDelimiter_ShouldThrowException() {
        try {
            int numberOfRecord = censusAnalyserProblem.loadIndianCensusData(WRONG_DELIMITER_CENSUS_DATA_PATH);
            Assertions.assertEquals(37, numberOfRecord);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserCustomExceptionType.WRONG_DELIMITER_OR_HEADER, e.type,"Wrong delimiter added");
        }
    }
}