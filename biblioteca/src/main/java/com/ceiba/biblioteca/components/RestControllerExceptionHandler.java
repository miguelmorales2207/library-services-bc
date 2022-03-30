package com.ceiba.biblioteca.components;

import com.ceiba.biblioteca.dto.response.ResponseExeptionDTO;
import com.ceiba.biblioteca.exceptions.BusinessRuleException;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = BusinessRuleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleBusinessRuleException(BusinessRuleException ex) {
        ResponseExeptionDTO responseExeptionDTO = new ResponseExeptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(responseExeptionDTO);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException ex) {
        ResponseExeptionDTO responseExeptionDTO = new ResponseExeptionDTO(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(responseExeptionDTO);
    }

}
