package com.tarikyazici.todo_list_app.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.Map;

// LOMBOK
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder

// Spring Framuworkun Error mekanizması yerine bizim yazdığımız hata yakalama mekanizmasıdır
// Jackson: Objeyi , Json'a çevirmek
// @JsonInclude(JsonInclude.Include.NON_NULL): Eğer ApiResultta null değer varsa backent'te gönder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // sem pvc
    private int status;
    private String error;
    private String message;
    private String path;
    private Map<String,String> validationErrors;
    private LocalDate createdDate;

    // Constructor Parametresiz
    public ApiResult() {
    }

    // Constructor (Parametreli)  pmes
    public ApiResult(String path, String message, String error, int status) {
        this.path = path;
        this.message = message;
        this.error = error;
        this.status = status;
    }

    // Constructor (Parametreli)  pms
    public ApiResult(String path, String message, int status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }
    
    public ApiResult(String message, LocalDate createdDate, Map<String, String> validationErrors) {
		this.message = message;
		this.createdDate = createdDate;
		this.validationErrors = validationErrors;
    }
    
    
    
    

} //end Class ApiResult
