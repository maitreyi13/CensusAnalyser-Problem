package com.bridgelabz;

public class StateCensusAnalyserException extends Exception {
    public enum CensusAnalyserCustomExceptionType{
        NO_SUCH_FILE_FOUND;
    }
    public CensusAnalyserCustomExceptionType type;

    public StateCensusAnalyserException(CensusAnalyserCustomExceptionType type, String message) {
        super(message);
        this.type = type;
    }
    public StateCensusAnalyserException(String message, CensusAnalyserCustomExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
