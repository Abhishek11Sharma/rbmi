package com.rbmi.student.portal.rbmi.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rbmi.student.portal.rbmi.apiResponse.ApiResponse;
import com.rbmi.student.portal.rbmi.exceptions.exceptionClasses.DataNotSaveIntoDatabase;
import com.rbmi.student.portal.rbmi.exceptions.exceptionClasses.JwtTokenValidationExcepiton;
import com.rbmi.student.portal.rbmi.exceptions.exceptionClasses.ResourceNotFoudException;
import com.rbmi.student.portal.rbmi.payloads.ResultDto;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.security.SignatureException;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler({ DataNotSaveIntoDatabase.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleDataNotSaveIntoDatabase(DataNotSaveIntoDatabase exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ JwtTokenValidationExcepiton.class })
    public ResponseEntity<?> handleJwtTokenValidationExcepiton(JwtTokenValidationExcepiton exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<?> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ ResourceNotFoudException.class })
    public ResponseEntity<?> handleResourceNotFoudException(ResourceNotFoudException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<ResultDto> errorDtos = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            ResultDto errorDto = new ResultDto(error.getField(), error.getDefaultMessage());
            errorDtos.add(errorDto);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse("Method argument not valid", false, errorDtos));
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<?> handleAccessDeniedException(BadCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse("Wrong creditional !!", false, null));
    }

    @ExceptionHandler(DecodingException.class)
    public ResponseEntity<?> handleDecodingException(DecodingException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDataAccessException(DataAccessException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ SignatureException.class })
    public ResponseEntity<?> handleSignatureException(SignatureException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ MalformedJwtException.class })
    public ResponseEntity<?> handleMalformedJwtException(MalformedJwtException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ JsonParseException.class })
    public ResponseEntity<?> handleJsonParseException(JsonParseException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }

    @ExceptionHandler({ DeserializationException.class })
    public ResponseEntity<?> handleDeserializationException(DeserializationException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(exception.getMessage(), false, null));
    }
}