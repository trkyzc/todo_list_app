package com.tarikyazici.todo_list_app.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice 
@RequiredArgsConstructor
public class GlobalExceptionHandler {
	
	@Autowired
	private final ErrorAttributes errorAttributes;
	
	// Api Result Field
    // sm pv
    private int status;
    private String message;
    private String path;
    private Map<String, Object> errors;
    
    // ApiResult
    private ApiResult apiResult;
	
    @ResponseStatus(HttpStatus.BAD_REQUEST) //Bu metod çalıştığında bad request döndür.
    @ExceptionHandler(MethodArgumentNotValidException.class)  //MethodArgumentNotValidException türünde hata olduğunda bu metodu çalıştır.(@Valid hatası)
    public ApiResult handleValidationExceptions(MethodArgumentNotValidException exception,WebRequest webRequest){  //exception doğrulama sırasında oluşan tüm hataları içerir
    	
    	 Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                 webRequest,
                 ErrorAttributeOptions.of(
                         ErrorAttributeOptions.Include.MESSAGE,
                         ErrorAttributeOptions.Include.BINDING_ERRORS
                 )); //end attributes

         // Spring'ten gelen hata verilerini almak
         status = HttpStatus.BAD_REQUEST.value();
         message = (String) attributes.get("message"); //attributes.get("message").toString();
         path = (String) attributes.get("path"); //attributes.get("path").toString();

         //  public ApiResult(String path, String message, int status)
         apiResult = new ApiResult(path, message, status);

         // attributes içinde hataları yani errorsları alacağım
         if (attributes.containsKey("errors")) {
             List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");

             // ValidationError Instance
             errors = new HashMap<>();
             for (FieldError fieldError : fieldErrors) {
                 errors.put(fieldError.getField(), fieldError.getDefaultMessage());
             }

             // apiResult Validation Set Yap
             apiResult.setErrors(errors);
         }

         //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResult);
         return apiResult;
    }
        
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
	public ApiResult handleEntityNotFoundException(EntityNotFoundException exception,
			WebRequest request) {
    	
    	status = HttpStatus.NOT_FOUND.value();
    	
        Map<String, Object> body = new HashMap<>();
    	body.put("message", exception.getMessage());
    	body.put("path", ((ServletWebRequest) request).getRequest().getRequestURI());
    	return new ApiResult(status,"EntityNotFound Hataları",body); 
		
		//return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})  //request parametrelerindeki type mismatch
    public ApiResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, WebRequest request) {
    	
    	status = HttpStatus.BAD_REQUEST.value();
    	
        Map<String, Object> body = new HashMap<>();
    	body.put("message", exception.getMessage());
    	body.put("path", ((ServletWebRequest) request).getRequest().getRequestURI());
    	return new ApiResult(status,"MethodArgumentTypeMismatch Hataları",body); 
    	//return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    	
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})  //ör: form içindeki typemismatch
    public ApiResult handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, WebRequest request){
    	
    	status = HttpStatus.BAD_REQUEST.value();
    	
        Map<String, Object> body = new HashMap<>();
    	body.put("message", exception.getMessage());
    	body.put("path", ((ServletWebRequest) request).getRequest().getRequestURI());
    	return new ApiResult(status,"HttpMessageNotReadableException Hataları",body); 
    	//return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
	public ApiResult handleAll(Exception exception, WebRequest request) {
    	
    	status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    	
        Map<String, Object> body = new HashMap<>();
    	body.put("message", exception.getMessage());
    	body.put("path", ((ServletWebRequest) request).getRequest().getRequestURI());
    	return new ApiResult(status,"Genel Hatalar",body);
		//return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}
