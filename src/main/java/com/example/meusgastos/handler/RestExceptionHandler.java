package com.example.meusgastos.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.meusgastos.common.ConversorData;
import com.example.meusgastos.domain.exception.ResourceBadRequestException;
import com.example.meusgastos.domain.exception.ResourceNotFoundException;
import com.example.meusgastos.domain.model.ErrorReposta;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorReposta> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        
        String dataHora = ConversorData.converterDateParaDataEHora(new Date());

        ErrorReposta erro = new ErrorReposta(dataHora, HttpStatus.NOT_FOUND.value(), "Not Foud", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

       
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorReposta> handlerResourceBadRequestException(ResourceBadRequestException ex) {
        
        String dataHora = ConversorData.converterDateParaDataEHora(new Date());

        ErrorReposta erro = new ErrorReposta(dataHora, HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorReposta> handlerRequestException(Exception ex) {
        
        String dataHora = ConversorData.converterDateParaDataEHora(new Date());

        ErrorReposta erro = new ErrorReposta(dataHora, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Errort", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


 


