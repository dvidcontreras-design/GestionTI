# Sistema de Gestión TI

## 1. Descripción del proyecto

El Sistema de Gestión TI es una aplicación desarrollada en Java para administrar información relacionada con los servicios tecnológicos de una empresa. Su objetivo es facilitar el registro y la consulta de clientes, productos, servicios técnicos, licencias, instalaciones de infraestructura TI y ventas.

Este proyecto se desarrolla como parte del proceso de formación del programa de Análisis y Desarrollo de Software del SENA el cual estoy cursando actualmente.

## 2. Objetivo general

Desarrollar un sistema de software que permita organizar y gestionar información de una empresa de servicios tecnológicos mediante una aplicación conectada a una base de datos relacional.

## 3. Tecnologías utilizadas

- **Java:** lenguaje de programación.
- **Maven:** administración del proyecto y sus dependencias.
- **MySQL:** sistema gestor de bases de datos.
- **MySQL Connector/J:** conexión entre Java y MySQL.
- **Java Dotenv:** lectura de variables de configuración.
- **Visual Studio Code:** entorno de desarrollo.
- **Git y GitHub:** control de versiones y publicación del código fuente.

## 4. Módulos del sistema

- Gestión de clientes.
- Gestión de productos.
- Gestión de servicios técnicos.
- Gestión de licencias.
- Gestión de instalaciones TI.
- Gestión de ventas.

La disponibilidad de las operaciones de cada módulo depende de su implementación y de las pruebas realizadas durante el desarrollo.

## 5. Requisitos para ejecutar el proyecto

- Java JDK 21 o una versión compatible con la configuración del proyecto.
- Apache Maven.
- MySQL Server.
- Una base de datos llamada `gestion_ti`.
- El controlador MySQL configurado mediante Maven.
- Las credenciales de conexión configuradas localmente.

## 6. Configuración de la conexión

Archivo `.env` en la carpeta principal del proyecto, junto a `pom.xml`, con la siguiente estructura:

```env
DB_USER=root
DB_PASSWORD=TU_CONTRASEÑA_LOCAL
```

Reemplazo `TU_CONTRASEÑA_LOCAL` por la contraseña de tu usuario de MySQL.

**Importante:** no publico el archivo `.env` ni contraseñas reales en GitHub.

## 7. Ejecución del proyecto

Abro una terminal en la carpeta principal del proyecto y ejecuto:

```bash
mvn clean compile
```

Si la compilación termina correctamente, ejecuto:

```bash
mvn exec:java -Dexec.mainClass=Main
```

El programa mostrará el menú principal del Sistema de Gestión TI.

## 8. Base de datos

El sistema utiliza MySQL para almacenar la información de clientes, productos, servicios técnicos, licencias, instalaciones y ventas.

El archivo `database.sql`, ubicado en la raíz del proyecto, contiene el script SQL para crear las tablas y sus relaciones.

### Pasos para configurar la base de datos

1. Abrir MySQL Workbench y conectarse al servidor MySQL.
2. Abrir el archivo `database.sql`.
3. Revisar el contenido antes de ejecutarlo, ya que incluye instrucciones que eliminan y recrean tablas existentes.
4. Ejecutar el script para crear la estructura de la base de datos `gestion_ti`.
5. Configurar las variables de conexión en el archivo `.env`, según la configuración local.

**Importante:** no publicar contraseñas reales ni compartir el archivo `.env`.
