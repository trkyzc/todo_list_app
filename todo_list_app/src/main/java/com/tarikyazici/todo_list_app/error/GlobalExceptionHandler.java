package com.tarikyazici.todo_list_app.error;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice   
public class GlobalExceptionHandler {
	
    @ResponseStatus(HttpStatus.BAD_REQUEST) //Bu metod çalıştığında bad request döndür.
    @ExceptionHandler(MethodArgumentNotValidException.class)  //MethodArgumentNotValidException türünde hata olduğunda bu metodu çalıştır.(@Valid hatası)
    public ResponseEntity<ApiResult> handleValidationExceptions(MethodArgumentNotValidException exception){  //exception doğrulama sırasında oluşan tüm hataları içerir
        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError)error).getField();    // Her bir hata field error olarak değerlendirilir.
            String errorMessage=error.getDefaultMessage();      // Hatanın mesajını alır.
            errorMap.put(fieldName,errorMessage);               // Map'e ekler.
        });
        
        ApiResult apiResult = new ApiResult("Validation Error", LocalDate.now(), errorMap);
        return new ResponseEntity<ApiResult>(apiResult, HttpStatus.BAD_REQUEST);
    }
        
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception,
			WebRequest request) {
		
    	//ApiResult apiResult = new ApiResult(exception.getMessage(),LocalDateTime.now());
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})  //request parametrelerindeki type mismatch
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, WebRequest request) {
    	
    	return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    	
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})  //ör: form içindeki typemismatch
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, WebRequest request){
    	
    	return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
	public ResponseEntity<String> handleAll(Exception exception, WebRequest request) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}
