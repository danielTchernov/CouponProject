package com.daniel.server.exceptions;
import com.daniel.server.enums.ErrorType;

public class ServerException extends Exception{
    private ErrorType errorType;

    public ServerException(ErrorType errorType , String message){
        super(message);
        this.errorType = errorType;
    }
    public ServerException(ErrorType errorType, String message , Exception e){
        super(message, e);
        this.errorType = errorType;
    }
    public ErrorType getErrorType(){
        return errorType;
    }

}
