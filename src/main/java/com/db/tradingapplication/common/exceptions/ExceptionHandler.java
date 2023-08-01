package com.db.tradingapplication.common.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> allExceptionHandler(Exception exception){
        logger.info(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( exception.getMessage());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = NoSuchBeanDefinitionException.class)
    public ResponseEntity<?> noSuchBeanDefinitionException(NoSuchBeanDefinitionException exception){

        logger.info(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage());
    }


}
