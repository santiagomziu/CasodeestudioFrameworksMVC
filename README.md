# RollerSpeed 🛹

Aplicación web monolítica desarrollada para la escuela de patinaje **RollerSpeed** como producto mínimo viable (MVP), utilizando Spring Boot, Spring MVC y PostgreSQL.

## 🎯 Objetivo

Desarrollar un producto mínimo viable para la escuela de patinaje RollerSpeed, implementando un entorno de desarrollo basado en Java y Spring Boot, con una interfaz web que permita presentar información institucional y los principales servicios y eventos de la escuela.

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- PostgreSQL
- Maven
- Git
- GitHub
- Visual Studio Code

## 📌 Producto mínimo viable

El MVP de RollerSpeed cuenta con un menú principal que permite navegar entre las siguientes secciones:

- **Misión**
- **Visión**
- **Valores**
- **Servicios**
- **Eventos de la escuela**

Las opciones del menú utilizan navegación interna para dirigir al usuario hacia la sección correspondiente dentro de la página principal.

## 🏗️ Arquitectura MVC

La aplicación utiliza el patrón **MVC (Model-View-Controller)** mediante Spring Boot y Spring MVC.

### Controller

El controlador se encuentra en:

`src/main/java/com/iudigital/rollerSpeed/controllers/indexController.java`

Este componente gestiona las solicitudes HTTP y dirige al usuario hacia la vista principal de la aplicación.

La ruta configurada para acceder al controlador es:

`/home/index`

### View

La vista principal se encuentra en:

`src/main/resources/templates/index.html`

En esta vista se presenta la interfaz del producto mínimo viable, incluyendo el menú de navegación y las secciones informativas de RollerSpeed.

### Model

El proyecto cuenta con las dependencias necesarias para trabajar con Spring Data JPA y PostgreSQL, dejando preparado el entorno para la incorporación de modelos y persistencia de datos durante las siguientes etapas del desarrollo.

## 📂 Estructura del proyecto

```text
CasodeestudioFrameworksMVC/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/iudigital/rollerSpeed/
│   │   │       ├── RollerSpeedApplication.java
│   │   │       └── controllers/
│   │   │           └── indexController.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   └── patineta.png
│   │       └── templates/
│   │           └── index.html
│   │
│   └── test/
│       └── java/
│           └── com/iudigital/rollerSpeed/
│               └── RollerSpeedApplicationTests.java
│
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Requisitos

Para ejecutar el proyecto se requiere contar con:

- **JDK 17 o superior**
- **Maven**
- **PostgreSQL**
- **Visual Studio Code** u otro IDE compatible
- **Git**

## 🗄️ Base de datos

La aplicación utiliza PostgreSQL como sistema gestor de base de datos.

La configuración de conexión se encuentra en:

`src/main/resources/application.properties`

La aplicación está configurada para trabajar con una base de datos local denominada:

**rollerSpeed**

Los datos de conexión pueden variar dependiendo de la configuración local de cada integrante del equipo.

## 🔐 Configuración local

Para trabajar con la aplicación, cada integrante debe configurar su entorno local de acuerdo con la instalación de PostgreSQL disponible en su equipo.

La URL de conexión utilizada por la aplicación puede configurarse mediante la variable de entorno `DB_URL`.

Ejemplo:

```text
jdbc:postgresql://localhost:5432/rollerSpeed
```

El puerto puede variar dependiendo de la configuración local de PostgreSQL.

No se deben almacenar contraseñas ni otras credenciales sensibles en el repositorio.

## ▶️ Ejecución del proyecto

Desde la raíz del proyecto ejecutar:

```bash
./mvnw spring-boot:run
```

También se puede utilizar Maven instalado localmente:

```bash
mvn spring-boot:run
```

Una vez iniciada correctamente la aplicación, Spring Boot levanta el servidor web en el puerto configurado.

## 🌐 Acceso a la aplicación

Por configuración predeterminada, la aplicación puede visualizarse en:

`http://localhost:8080`

También es posible acceder directamente a la ruta del controlador:

`http://localhost:8080/home/index`

## 🧪 Pruebas

El proyecto incluye una prueba de contexto de Spring Boot ubicada en:

`src/test/java/com/iudigital/rollerSpeed/RollerSpeedApplicationTests.java`

Esta prueba permite verificar que el contexto de la aplicación Spring Boot pueda iniciarse correctamente.

Para ejecutar las pruebas:

```bash
./mvnw test
```

## 📦 Dependencias principales

El proyecto utiliza las siguientes dependencias principales:

- **spring-boot-starter-data-jpa** — integración con JPA y persistencia de datos.
- **spring-boot-starter-thymeleaf** — manejo de vistas.
- **spring-boot-starter-webmvc** — desarrollo web utilizando Spring MVC.
- **spring-boot-devtools** — herramientas para facilitar el desarrollo y la recarga automática.
- **postgresql** — controlador JDBC para la conexión con PostgreSQL.

## 🔄 Control de versiones

El código fuente del proyecto se gestiona mediante Git y se encuentra alojado en un repositorio colaborativo de GitHub.

El uso de control de versiones permite al equipo:

- Registrar los cambios realizados.
- Mantener un historial del desarrollo.
- Trabajar de manera colaborativa.
- Recuperar versiones anteriores del proyecto.
- Integrar los aportes de los diferentes integrantes.

## 👥 Equipo de trabajo

Proyecto desarrollado de manera colaborativa como parte de la asignatura Frameworks para MVC de IU Digital de Antioquia.

### Integrantes

- Carolina Álvarez
- Santiago Monsalve

## 📚 Contexto académico

Este proyecto corresponde a la evidencia de aprendizaje **EA1 - Instalación de herramientas y configuración del entorno de desarrollo**, cuyo propósito es aplicar diferentes herramientas para instalar y configurar un entorno destinado al desarrollo de una aplicación web.

El producto desarrollado corresponde al caso de estudio de la escuela de patinaje RollerSpeed.

---

## 🛼 RollerSpeed

**Pasión, velocidad y técnica sobre ruedas.**