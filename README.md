# ToDo List Uygulaması

Bu proje, Spring Boot kullanılarak geliştirilmiş bir To-Do List (Yapılacaklar Listesi) uygulamasıdır. Kullanıcıların görev ekleyebileceği, güncelleyebileceği, silebileceği ve listeleyebileceği bir RESTful API sunar. Proje, PostgreSQL veritabanı kullanır ve Docker ile container üzerinde çalıştırılabilir.

## Kullanılan Teknolojiler
- **Java 17**
- **Spring Boot 3.x**
- **Hibernate (JPA)**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Lombok**

---

## Dosyalar

### **1. Bean Dosyası:**
- **`bean`**
   - Bean tanımlamaları ve özel konfigürasyonlar için.

### **2. Business Katmanı (İş Kuralları ve Servisler)**
- **`business.abstracts`** 
   - `TodoService.java` – İş kuralları için arayüz.
   - `UserService.java` – İş kuralları için arayüz.
   - `CrudService.java` – Ortak CRUD operasyonları için generic servis arayüzü.

- **`business.concretes`**
   - `TodoManager.java` – `Todo` için iş kurallarının implementasyonu.
   - `UserManager.java` – `User` için iş kurallarının implementasyonu.

### **3. Controller Katmanı (API Katmanı)**
- **`controller.api.abstracts`**
   - `TodoController.java` – `Todo` için API arayüzü.
   - `UserController.java` – `User` için API arayüzü.
   - `CrudController.java` – Ortak CRUD operasyonları için generic controller arayüzü.

- **`controller.api.concretes`**
   - `TodoControllerImpl.java` – `Todo` için API implementasyonu.
   - `UserControllerImpl.java` – `User` için API implementasyonu.

### **4. Data Katmanı (Veri Transfer Nesneleri ve Varlıklar)**
- **`data.dto`** (Veri Transfer Nesneleri)
   - `BaseDto.java`  
   - `CreateTodoRequest.java`  
   - `CreateUserRequest.java`  
   - `TodoDto.java`  
   - `UpdateTodoRequest.java`  
   - `UpdateUserRequest.java`  
   - `UserDto.java`

- **`data.entity`** (Veritabanı Entity'leri)
   - `BaseEntity.java`  
   - `Todo.java`  
   - `User.java`

- **`data.mapper`** (Entity - DTO Dönüşüm Katmanı)
   - `TodoMapper.java`  
   - `UserMapper.java`

- **`data.repository`** (Veritabanı Erişim Katmanı)
   - `TodoRepository.java`  
   - `UserRepository.java`

### **5. Hata Yönetimi (Error Handling)**
- **`error`**
   - `ApiResult.java` – API sonuçlarını standartlaştırmak için.
   - `GlobalExceptionHandler.java` – Global hata yönetimi.

### **6. Güvenlik Dosyası (Security)**
- **`security`**
   - `SecurityConfig.java` – Spring Security yapılandırması.



---

## Kurulum ve Çalıştırma

### 1. **Docker Kullanarak Çalıştırma:**
```bash
# Docker container'larını başlat
docker-compose up --build
```

### 2. **Docker Olmadan Manuel Çalıştırma:**
1. `application.yml` dosyasındaki veritabanı bağlantı ayarlarını kontrol et.
2. Projeyi çalıştır:
```bash
mvn spring-boot:run
```

---

## 📊 API Kullanımı
### **User Endpoints:**
- **POST /api/users** : Kullanıcı oluştur.
- **GET /api/users** : Tüm kullanıcıları listele.
- **GET /api/users/{id}** : ID ile kullanıcı getir.
- **PUT /api/users/{id}** : Kullanıcı güncelle.
- **DELETE /api/users/{id}** : Kullanıcı sil.

### **Todo Endpoints:**
- **POST /api/todos** : Görev oluştur.
- **GET /api/todos** : Tüm görevleri listele.
- **GET /api/todos/{id}** : ID ile görev getir.
- **PUT /api/todos/{id}** : Görev güncelle.
- **PUT /api/todos/{id}/status** : Görev durumu güncelle.
- **DELETE /api/todos/{id}** : Görev sil.
- **GET /api/todos/user/{id}** : Kullanıcıya ait görevleri listele.
- **GET /api/todos/completed** : Tamamlanmış görevleri listele.
- **GET /api/todos/pending** : Bekleyen görevleri listele.

---

## Proje Geliştirme
- **Güvenlik:** Spring Security ile güvenlik eklenebilir.

---

## İletişim
- **Geliştirici:** Muhammed Tarık Yazıcı
- **E-posta:** m.tarikyazici44@gmail.com

---


