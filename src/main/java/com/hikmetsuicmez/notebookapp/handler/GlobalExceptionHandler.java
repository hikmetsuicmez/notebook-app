package com.hikmetsuicmez.notebookapp.handler;

import com.hikmetsuicmez.notebookapp.common.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


        @ExceptionHandler(EntityNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ApiResponse<Void> handleEntityNotFoundException(EntityNotFoundException ex) {
                log.error("Entity not found: {}", ex.getMessage());
                return ApiResponse.error(ex.getMessage());
        }


        // IllegalArgumentException gibi hatalar için
        @ExceptionHandler(IllegalArgumentException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ApiResponse<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
                log.error("Illegal argument: {}", ex.getMessage());
                return ApiResponse.error(ex.getMessage());
        }


        // Genel bir hata yakalayıcı (beklenmeyen durumlar için)
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public ApiResponse<Void> handleGenericException(Exception ex) {
                log.error("An unexpected error occurred: {}", ex.getMessage(), ex);
                return ApiResponse.error("An unexpected error occurred: " + ex.getMessage());
        }



}
