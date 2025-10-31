package com.prueba.nequi.exception;

import com.prueba.nequi.dto.response.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        ObjectNotFoundException.class,
        MethodArgumentNotValidException.class,
    })

    public ResponseEntity<ApiError> handleAllException(Exception exception, HttpServletRequest request, HttpServletResponse response){

        ZoneId zoneId = ZoneId.of("America/Bogota");
        LocalDateTime timestamp = LocalDateTime.now(zoneId);

        if (exception instanceof ObjectNotFoundException objectNotFoundException) {
            return this.handleObjectNotFoundException(objectNotFoundException, request, response, timestamp);
        }

        if (exception instanceof MethodArgumentNotValidException methodArgumentNotValidException) {
            return this.handledMethodArgumentNotValidException(methodArgumentNotValidException, request, response, timestamp);
        }

        return this.handleException(exception, request, response, timestamp);
    }

    private ResponseEntity<ApiError> handleObjectNotFoundException(ObjectNotFoundException objectNotFoundException, HttpServletRequest request, HttpServletResponse response, LocalDateTime timestamp){
        int httpStatus = HttpStatus.NOT_FOUND.value();

        ApiError apiErrorDto = new ApiError();
        apiErrorDto.setHttpCode(httpStatus);
        apiErrorDto.setUrl(request.getRequestURL().toString());
        apiErrorDto.setHttpMethod(request.getMethod());
        apiErrorDto.setMessage("Lo sentimos, no se pudo encontrar la información solicitada.");
        apiErrorDto.setBackendMessage(objectNotFoundException.getMessage());
        apiErrorDto.setTimestamp(timestamp);
        apiErrorDto.setDetails(null);

        return ResponseEntity.status(httpStatus).body(apiErrorDto);
    }


    private ResponseEntity<ApiError> handleException(Exception exception, HttpServletRequest request, HttpServletResponse response, LocalDateTime timestamp){

        int httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();

        ApiError apiError = new ApiError();
        apiError.setHttpCode(httpStatus);
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setHttpMethod(request.getMethod());
        apiError.setMessage("Opps! Something went wrong on our server. Please try again later");
        apiError.setBackendMessage(exception.getMessage());
        apiError.setTimestamp(timestamp);
        apiError.setDetails(null);

        return ResponseEntity.status(httpStatus).body(apiError);
    }

    private ResponseEntity<ApiError> handledMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request, HttpServletResponse response, LocalDateTime timestamp){

        int httpStatus = HttpStatus.BAD_REQUEST.value();

        List<ObjectError> errors = methodArgumentNotValidException.getAllErrors();
        List<String> details = errors.stream().map(error -> {

            if (error instanceof FieldError fieldError) {
                return fieldError.getField() + ": " + fieldError.getDefaultMessage();
            }

            return error.getDefaultMessage();

        }).toList();

        ApiError apiError = new ApiError();
        apiError.setHttpCode(httpStatus);
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setHttpMethod(request.getMethod());
        apiError.setMessage("The request contains invalid or incomplete parameters. Please verify and provide the required information before trying again.");
        apiError.setBackendMessage(methodArgumentNotValidException.getMessage());
        apiError.setTimestamp(timestamp);
        apiError.setDetails(details);

        return ResponseEntity.status(httpStatus).body(apiError);
    }
}
