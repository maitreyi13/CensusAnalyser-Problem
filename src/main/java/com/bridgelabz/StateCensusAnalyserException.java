package com.bridgelabz;

public class StateCensusAnalyserException extends Exception {
    public enum CensusAnalyserCustomExceptionType{
        NO_SUCH_FILE_FOUND, NO_SUCH_TYPE_FOUND, WRONG_DELIMITER_OR_HEADER
    }
    public CensusAnalyserCustomExceptionType type;

    public StateCensusAnalyserException(CensusAnalyserCustomExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
