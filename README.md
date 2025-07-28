# Password Policy Management API

Bu proje, kullanıcı şifre politikalarının ve bağlantı (link) bilgilerinin yönetilmesini sağlayan basit bir RESTful API sunar. Spring Boot ile geliştirilmiş olup, bir frontend uygulaması ile entegre edilmek üzere yapılandırılmıştır.

# Frontend uygulama linki

https://github.com/Pr1Tech/passgate-Proje-Frontend

## 🚀 Özellikler

- Tüm politikaları ve bağlantıları listeleme (`GET /api/policy/all`)
- Var olan politikaları ve bağlantıları güncelleme (`PUT /api/policy/change`)
- Yeni politika ve bağlantı verisi kaydetme (`POST /api/policy/save`)
- CORS desteği (Frontend: `http://localhost:5173/`)

## 🛠️ Teknolojiler

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok


