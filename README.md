# Proyecto API REST

## 📋 Descripción

Este proyecto es una API REST desarrollada con Spring Boot que incluye documentación interactiva con Swagger y está completamente dockerizada para facilitar su despliegue.

## 🚀 Despliegue en Producción

El proyecto está actualmente desplegado y disponible en:
- **API**: [https://prueba-nequi.onrender.com/](https://prueba-nequi.onrender.com/)
- **Swagger**: [https://prueba-nequi.onrender.com/api/swagger-ui/index.html](https://prueba-nequi.onrender.com/api/swagger-ui/index.html)
- **Base de datos**: Railway

## 🛠️ Instalación y Configuración Local

### Prerrequisitos

- Git
- Docker y Docker Compose
- (Opcional) JDK 21+ si deseas ejecutar sin Docker
- (Opcional) IDE de tu preferencia (IntelliJ IDEA, VS Code, Eclipse, etc.)
- (Opcional) Postman para probar los endpoints

### Pasos para ejecutar el proyecto

1. **Clonar el repositorio**
```bash
   git clone https://github.com/caholguin/prueba-nequi
   cd prueba-nequi
```

2. **Configurar variables de entorno** (si es necesario)

   Verifica el archivo `application.properties` para asegurarte de que las configuraciones sean correctas para tu entorno local.

3. **Ejecutar con Docker**
```bash
   docker compose up
```

Este comando:
- Construirá la imagen de la aplicación
- Levantará el contenedor de la aplicación Spring Boot
- Expondrá la aplicación en el puerto 8080

4. **Verificar que la aplicación está funcionando**

   Abre tu navegador y accede a:
```
   http://localhost:8080/api/swagger-ui/index.html
```

Si ves la interfaz de Swagger, ¡la aplicación está lista! 🎉

## 📚 Documentación y Pruebas de la API

### Opción 1: Swagger UI 

La forma más fácil de explorar y probar la API es usando Swagger UI:

**Entorno Local:**
```
http://localhost:8080/api/swagger-ui/index.html
```

**Entorno de Producción:**
```
https://prueba-nequi.onrender.com/api/swagger-ui/index.html
```

Desde Swagger UI podrás:
- Ver todos los endpoints disponibles
- Conocer los parámetros requeridos
- Probar cada endpoint directamente desde el navegador
- Ver ejemplos de respuestas

### Opción 2: Postman Collection

Si prefieres usar Postman:

1. Abre Postman
2. Haz clic en "Import"
3. Selecciona el archivo `PRUEBA TECNICA.postman_collection.json` ubicado en la raíz del proyecto
4. La colección se importará con todos los endpoints preconfigurados
5. Selecciona el ambiente (local o producción) según corresponda

## 🐳 Comandos Docker Útiles
```bash
# Levantar los contenedores
docker compose up

# Levantar en segundo plano (modo detached)
docker compose up -d

# Ver logs en tiempo real
docker compose logs -f

# Ver logs de un servicio específico
docker compose logs -f app

# Detener los contenedores
docker compose down

# Detener y eliminar volúmenes (limpieza completa)
docker compose down -v

# Reconstruir las imágenes (útil después de cambios en el código)
docker compose build

# Reconstruir y levantar
docker compose up --build

# Ver estado de los contenedores
docker compose ps
```

## 🔧 Tecnologías Utilizadas

- **Backend**: Spring Boot 3.x
- **Base de Datos**: MySQL 8.x
- **Documentación**: Swagger/OpenAPI
- **Containerización**: Docker & Docker Compose
- **Despliegue**: Render (App) + Railway (DB)