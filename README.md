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

La aplicación utiliza MySQL para almacenar la información. El script SQL de la base de datos se incluirá en el repositorio para facilitar la creación de las tablas necesarias.

Antes de ejecutar el programa, verifico que MySQL esté funcionando y que la base de datos y las credenciales estén correctamente configuradas.

## 9. Repositorio

Código fuente del proyecto:

https://github.com/dvidcontreras-design/GestionTI

## 10. Estado del proyecto

El sistema se encuentra en desarrollo. Los módulos se implementan, prueban y mejoran progresivamente como parte del proceso de formación académica.
