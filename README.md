# 📓 Notebook Application

Notebook Application, kullanıcıların notlarını yönetebileceği ve kategorilere ayırabileceği bir Spring Boot tabanlı REST API uygulamasıdır.

---

## 🚀 Özellikler

- **CRUD İşlemleri:**
  - Notlar için: Oluştur, Oku, Güncelle, Sil.
  - Kategoriler için: Oluştur, Oku, Güncelle, Sil.
- **H2 In-Memory Veritabanı**: Hızlı ve kolay test için.
- **DTO Kullanımı**: Veri transferi için katmanlar arasında güvenli iletişim.
- **MapStruct Desteği**: Entity ve DTO dönüşümleri için.
- **Global Exception Handling**: Merkezi hata yönetimi.
- **Validation**: Giriş verilerinde `@Valid` ile doğrulama.
- **Logging**: Controller ve Exception Handler'da loglama.

---

## 🛠️ Teknolojiler

- **Java 17**
- **Spring Boot 3.x**
  - Spring Data JPA
  - Spring Web
  - Validation
- **H2 Database**
- **MapStruct**
- **Lombok**
- **Maven**

---

## 📂 Proje Yapısı

```plaintext
src/
├── main/
│   ├── java/com/hikmetsuicmez/notebookapp/
│   │   ├── controller/     → Rest API Controller'ları
│   │   ├── service/        → İş mantığı
│   │   ├── repository/     → JPA Repository'ler
│   │   ├── model/          → Entity sınıfları
│   │   ├── dto/            → Veri transfer nesneleri
│   │   ├── mapper/         → MapStruct mapper'ları
│   │   ├── common/         → Ortak sınıflar (ApiResponse vb.)
│   │   └── handler/        → Global Exception Handler
│   └── resources/
│       ├── application.properties  → Uygulama yapılandırma dosyası
│       └── data.sql                → Örnek veri
