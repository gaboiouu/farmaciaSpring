# Sistema de Gestión de Farmacia 💊
Un sistema integral de gestión para farmacias desarrollado con Spring Boot y asegurado con Spring Security. Este proyecto permite administrar eficientemente productos (inventario, precios, categorías, fechas de vencimiento), clientes, y el proceso de ventas. Incluye autenticación de usuarios basada en JWT con roles para controlar el acceso a las diferentes funcionalidades.

## ✨ Características Principales

- **Gestión de Productos:** 🛍️
  - CRUD completo (Crear, Leer, Actualizar, Eliminar) para productos.
  - Búsqueda de productos por nombre y categoría.
  - Manejo de información detallada: nombre, precio, cantidad en stock, fecha de vencimiento, descripción y categoría.
- **Gestión de Clientes:** 👥
  - CRUD completo para la información de los clientes (nombre, apellidos, email, teléfono).
- **Gestión de Ventas:** 🛒
  - Registro de ventas, asociando cliente y fecha.
  - Gestión de detalles de venta: productos vendidos, cantidades y precios.
  - Actualización automática del stock de productos después de cada venta.
- **Seguridad y Autenticación:** 🔐
  - Sistema de autenticación de usuarios (nombre de usuario y contraseña).
  - Generación y validación de JSON Web Tokens (JWT) para sesiones seguras.
  - Sistema de Roles (ej. `ADMIN`) para autorización y control de acceso.
  - Protección de APIs sensibles.
- **Gestión de Usuarios y Roles:** 🧑‍💼
  - Almacenamiento de información de usuarios (nombre de usuario, contraseña encriptada, nombre, apellido, email).
  - Asignación de roles a los usuarios.
- **Configuración API:** ⚙️
  - Configuración de CORS para permitir solicitudes de diferentes orígenes.

## 🚀 Cómo Empezar

Esta sección te guiará para poner en marcha el proyecto en tu entorno local.

### Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas:

- **Java Development Kit (JDK):** Se recomienda la versión 17 o superior (común para proyectos Spring Boot 3+). ☕
- **Apache Maven:** Se recomienda la versión 3.6 o superior. 🛠️
- **MySQL Server:** Versión 8.0 o compatible. 🐬
- **IDE (Opcional pero recomendado):** IntelliJ IDEA, Eclipse, VS Code con extensiones de Java. 💻

### Pasos de Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO_AQUI>
    ```
2.  **Navegar al directorio del proyecto:**
    ```bash
    cd nombre-del-directorio-del-proyecto
    ```
3.  **Configurar la base de datos:**
    *   Asegúrate de que tu servidor MySQL esté en ejecución.
    *   Crea una base de datos para el proyecto (ej. `farmacia_db`).
    *   Actualiza el archivo `src/main/resources/application.properties` con los detalles de tu conexión:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos
        spring.datasource.username=tu_usuario_mysql
        spring.datasource.password=tu_contraseña_mysql
        spring.jpa.hibernate.ddl-auto=update
        # Cambia a 'create' si quieres que Hibernate genere las tablas la primera vez (¡cuidado, puede borrar datos existentes!).
        # Usa 'validate' o 'none' para entornos de producción.
        ```
4.  **Construir el proyecto:**
    Desde la raíz del proyecto, ejecuta:
    ```bash
    mvn clean install
    ```
5.  **Ejecutar la aplicación:**
    Puedes ejecutar la aplicación de varias maneras:
    *   **Usando Maven:**
        ```bash
        mvn spring-boot:run
        ```
    *   **Ejecutando el archivo JAR:**
        (Después de construir, el JAR se encontrará en la carpeta `target/`)
        ```bash
        java -jar target/nombre-del-archivo.jar
        ```
        *(El nombre exacto del archivo JAR puede variar según la configuración en tu `pom.xml`.)*

## 💻 Tecnologías Utilizadas

- Java
- Spring Boot
- Maven
- MySQL


