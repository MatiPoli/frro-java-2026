# TP Desarrollo

Matías Marquez - 51419

## 1 - Enunciado

El sistema a desarrollar es una aplicación web cliente-servidor en Java destinada a la 
gestión de jugadores y proyectos dentro del servidor BTE Cono Sur. 

Build The Earth (BTE) es un proyecto global y colaborativo que busca recrear el planeta Tierra en Minecraft en 
escala 1:1. El servidor BTE Cono Sur agrupa a los equipos de Argentina, Chile, Perú, 
Bolivia, Paraguay y Uruguay.

La aplicación web permitirá administrar jugadores, proyectos y las solicitudes de unión a 
proyectos, actuando como interfaz gráfica para las operaciones que el plugin bteCSCore,
sistema central del servidor de Minecraft, expone a través de su API REST. Toda la lógica 
de negocio y la persistencia de datos (incluyendo la caché en memoria) son gestionadas por 
dicho plugin. El sistema web se limita a presentar la información y delegar las operaciones 
mediante llamadas HTTP.

Un proyecto es una región poligonal del mundo de Minecraft que representa la construcción 
de una zona específica. Puede tener un líder, miembros y distintos estados (En Creación, 
Completado, Abandonado, etc.). Los jugadores tienen tipos (Visitante, Postulante, 
Constructor) y roles (Usuario, Reviewer, Moderador, Admin), que determinan qué 
operaciones pueden realizar.

Se ingresa al sistema mediante cuenta de Discord. Por lo que el usuario tiene que haber ingresado 
al servidor y linkear la cuenta para utilizar la aplicación web.

## 2 - Modelo de dominio
<img width="751" height="901" alt="BD Cono Sur-TP_UTN drawio" src="https://github.com/user-attachments/assets/6595e626-6da6-4088-9a33-d9c6457c64ad" />

---

Las entidades principales del sistema son:
- Player: Representa un jugador del servidor.
-	Proyecto: Unidad de trabajo en el servidor.
-	Proyecto_Miembro: Relación entre jugadores y proyectos (participación).
-	Tipo_Usuario: Categorización del jugador según permisos de construcción (Visitante, Postulante, Constructor).
-	Rango_Usuario: Rol del jugador (Usuario, Reviewer, Moderador, Admin, etc).
-	Tipo_Proyecto: Categorización del proyecto según tamaño.
-	País: Determinado por una serie de regiones poligonales.
-	División: De un país. Determinado por una serie de regiones poligonales. Dependiendo del país recibe un nombre distinto (Provincia, Comuna, Barrio, etc).

## 4 - Arquitectura
La arquitectura sigue el esquema cliente-servidor en capas:
-	Capa de presentación: JSP/JSTL y HTML5/CSS3 (Bootstrap).
-	Capa de control: Servlets en Apache Tomcat, que reciben las peticiones del browser.
-	Capa de lógica / acceso a datos: los Servlets se comunican mediante HTTP con la API REST del plugin bteCSCore, que gestiona la base de datos y la caché del servidor de Minecraft.

[ Browser ]
->
[ Servlets (Tomcat) ]
-> HTTP
[ Plugin bteCSCore (Minecraft) ]
->
[ DB ]

## 5 - Alcance Funcional

### 5.1 - Regularidad

#### ABMC Simples

- *Tipo de Proyecto*: No depende de otras entidades.

---

#### ABMC Dependientes

- *Proyecto*: Depende de Tipo de Proyecto, País y Ciudad. Al ser una región poligonal, para la Alta o Modificación hace falta seleccionar un conjunto de lat,lon.

---

### 5.2 - Aprobación Directa

#### ABMC
- ABMC completo de:
  - Jugadores
  - Proyectos
  - Participaciones

#### Caso de Uso Complejo
- Gestión de participación en proyectos:
  - asignar jugador
  - modificar participación
  - eliminar participación

#### Listado complejo
- Listado de proyectos filtrado por nombre

#### Niveles de acceso
- Usuario: consulta
- Administrador: ABMC completo

#### Manejo de errores
- Uso de try-catch en operaciones
- Mensajes al usuario ante errores

---

## 6 - Requerimientos Técnicos

- Aplicación cliente-servidor
- Uso de Servlets
- Uso de JSP/JSTL
- HTML5 y CSS
- Ejecución en Apache Tomcat
- Comunicación HTTP con el plugin
- Conexión a base de datos a través del plugin
- Arquitectura en capas:
  - Servlet (controlador)
  - Plugin (lógica de negocio)
  - DB + Cache (persistencia)
- Control de acceso
- Manejo de errores

---

## 7 - Flujo de funcionamiento
