package com.tarikyazici.todo_list_app.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	
	 @NotEmpty(message = "İsim alanı boş bırakılamaz")
	 private String name;
	 
	 @NotEmpty(message = "Kullanıcı adı boş bırakılamaz")
	 @Size(min = 3, message = "Kullanıcı adı en az 3 karakter olmalıdır")
	 private String username;
	 
	 @NotEmpty(message = "Email boş bırakılamaz")
	 @Email(message = "Email doğru formatta değil")
	 private String email;
	 
	 @NotEmpty(message = "Password boş bırakılamaz")
	 @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Geçersiz şifre! Lütfen en az bir büyük harf, bir küçük harf, bir rakam ve bir özel karakter içeren en az 8 karakterli bir şifre girin.")
	 private String password;

}
