package com.dhkim.cote.config.exceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dhkim.cote.config.exception.CommonJsonException;
import com.dhkim.cote.config.model.ResponseModel;

@RestControllerAdvice
public class BadResponseHandler {
	@ExceptionHandler(CommonJsonException.class)
    public ResponseModel jsonException(CommonJsonException ex) {
        return ResponseModel.of(ex.getCode(), ex.getMessage());
    }
}
