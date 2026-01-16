🎵 Music API – Spring Boot

API REST desarrollada con **Spring Boot** para la gestión de usuarios, artistas, álbumes, canciones y playlists, inspirada en plataformas de streaming musical.
----------------0----------------------0-----------0-------------0--------------0----------------------------0---------------------0----------------0----------

🚀 Tecnologías utilizadas

- **Java 17+**
- **Spring Boot**
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Tokens)
- Hibernate
- Lombok
- Maven
- Base de datos relacional (MySQL / PostgreSQL / H2)
- Manejo de archivos (upload / download)

---0---0---0---0---0---0---0---0---0---0---0---0---0---0---0---0

📦 Funcionalidades principales

👤 Usuarios
- Crear usuarios
- Obtener usuario por ID
- Actualizar usuario
- Eliminar usuario (solo ADMIN)
- Listar usuarios (solo ADMIN)
- Roles (`ADMIN`, `USER`)
- Seguridad con Spring Security

🎤 Artistas
- Crear artista
- Buscar artista por nombre
- Actualizar artista
- Eliminar artista
- Listar artistas

 💿 Álbumes
- Crear álbum
- Actualizar álbum
- Buscar álbum por:
  - Género
  - Título
  - Año
- Eliminar álbum
- Listar todos los álbumes
- Actualizar imagen/tapa del álbum

 🎶 Canciones
- Subir canciones
- Obtener canciones por título
- Listar canciones
- Actualizar canción
- Eliminar canción
- Manejo de archivos (audio)

 📂 Playlists
- Crear playlist
- Buscar playlist por nombre
- Actualizar playlist
- Eliminar playlist
- Listar playlists
- Agregar canciones a playlists

 🗄️ Archivos
- Subida de archivos
- Descarga de archivos
- Almacenamiento en base de datos

---0---0---0---0---0---0---0---0---0---0

🔐 Seguridad

- Autenticación basada en **JWT**
- Autorización por roles:
  - `ROLE_ADMIN`
  - `ROLE_USER`
- Endpoints protegidos con `@PreAuthorize`

---0---0---0---0---0---0---0---0---0---0---0

🧱 Arquitectura

El proyecto sigue una arquitectura en capas:

- controller
- service
- service.impl
- repository
- entity
- dto
- mapper
- exception
- security
  
---0---0---0---0---0---0---0---0---0---0

🧪 Estado del proyecto

🚧 En desarrollo
Próximas mejoras:

- Relaciones JPA optimizadas
- Tests unitarios
- Documentación con Swagger / OpenAPI
- Integración con Cloudinary
- Streaming de audio
