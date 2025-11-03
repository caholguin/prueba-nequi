# Proyecto API REST

## 📋 Descripción

Este proyecto es una API REST desarrollada con Spring Boot que incluye documentación interactiva con Swagger y está completamente dockerizada para facilitar su despliegue.

## 🚀 Despliegue en Producción

El proyecto está actualmente desplegado y disponible en:
- **API**: Render
- **Base de datos**: Railway

## 🛠️ Instalación y Configuración Local

### Prerrequisitos

- Git
- Docker y Docker Compose
- (Opcional) IDE de tu preferencia (IntelliJ IDEA, VS Code, Eclipse, etc.)
- (Opcional) Postman para probar los endpoints

### Pasos para ejecutar el proyecto

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/caholguin/prueba-nequi
   cd prueba-nequi
   ```

2. **Abrir el proyecto**
    - Abre el proyecto en tu IDE preferido, o
    - Continúa trabajando desde la consola/terminal

3. **Ejecutar con Docker**
   ```bash
   docker compose up
   ```

   Este comando construirá y levantará todos los contenedores necesarios para el proyecto.

## 📚 Documentación de la API

Una vez que el proyecto esté ejecutándose, puedes acceder a la documentación de la API de dos formas:

### Opción 1: Swagger UI

Accede a la interfaz interactiva de Swagger local en:

```
http://localhost:8080/api/swagger-ui/index.html
```

Accede a la interfaz interactiva de Swagger en linea en:

```
http://localhost:8080/api/swagger-ui/index.html
```

Desde aquí podrás explorar y probar todos los endpoints disponibles de manera visual e interactiva.

### Opción 2: Postman Collection

Si prefieres usar Postman:

1. Abre Postman
2. Importa el archivo `PRUEBA TECNICA.postman_collection.json` que se encuentra en la raíz del proyecto
3. En la colección importada encontrarás todos los endpoints organizados y listos para usar

## 🐳 Comandos Docker Útiles

```bash
# Levantar los contenedores
docker compose up

# Levantar en segundo plano
docker compose up -d

# Ver logs
docker compose logs -f

# Detener los contenedores
docker compose down

# Reconstruir las imágenes
docker compose build
```

## 🔧 Tecnologías Utilizadas

- Spring Boot
- Docker & Docker Compose
- Swagger/OpenAPI
- MySQL

## 📝 Notas Adicionales

- El puerto por defecto de la aplicación es `8080`
- Asegúrate de que el puerto 8080 esté disponible antes de ejecutar el proyecto
---

