package com.jg.backend.exception.handler;

import com.jg.backend.domain.dto.ErrorResponse;
import com.jg.backend.exception.JgBadRequestException;
import com.jg.backend.exception.JgConflictException;
import com.jg.backend.exception.JgNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ErrorResponse handleGenericException(Exception ex) {
    return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
  }

  @ExceptionHandler(value = JgNotFoundException.class)
  public ErrorResponse handleException(JgNotFoundException ex) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }

  @ExceptionHandler(value = JgConflictException.class)
  public ErrorResponse handleException(JgConflictException ex) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
  }

  @ExceptionHandler(value = JgBadRequestException.class)
  public ErrorResponse handleException(JgBadRequestException ex) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
  }

}
