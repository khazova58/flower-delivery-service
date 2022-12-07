package com.khazova.flowerdeliveryservice.exception;

import com.khazova.flowerdeliveryservice.exception.part1.ApiError;
import com.khazova.flowerdeliveryservice.exception.part1.BusinessException;
import com.khazova.flowerdeliveryservice.exception.part1.EmailExistException;
import com.khazova.flowerdeliveryservice.exception.part2.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleResourceNotFound(BusinessException ex) {
        ApiError apiError = ApiError.builder()
                .errorCode(ex.getError())
                .description(ex.getDescription())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleEmailExist(EmailExistException ex) {
        ApiError apiError = ApiError.builder()
                .errorCode(ex.getError())
                .description(ex.getDescription())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleGlobalException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> errorList = bindingResult.getFieldErrors();
        List<String> messages = errorList.stream()
                .map(error -> "Поле " + error.getField() + " " + error.getDefaultMessage())
                .toList();
        ApiError apiError = ApiError.builder()
                .errorCode("Error:0102")
                .description("Ошибка валидации")
                .timeStamp(LocalDateTime.now())
                .errors(messages)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleServiceException(ServiceException ex) {
        ApiError error = ApiError.builder()
                .errorCode(ex.getError().getErrorCode())
                .description(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, ex.getError().getHttpStatus());
    }
}
