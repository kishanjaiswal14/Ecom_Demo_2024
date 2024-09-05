package com.kishan.ecom_demo.Advices;

import com.kishan.ecom_demo.DTOs.ErrorDTO;
import com.kishan.ecom_demo.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> HandleNotFoundException(
            NotFoundException notFoundException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorMessage(notFoundException.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
