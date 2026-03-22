# TP Desarrollo

## 1 - Enunciado

Se desarrollará una aplicación web cliente-servidor en Java que permitirá la gestión de jugadores y proyectos dentro del entorno BTE Cono Sur.

Build The Earth (BTE) es un proyecto global que busca recrear la Tierra en Minecraft en escala 1:1. Los equipos de Argentina, Chile, Perú, Bolivia, Paraguay y Uruguay comparten un único servidor denominado BTE Cono Sur.

El sistema web permitirá administrar jugadores y proyectos mediante operaciones de alta, baja, modificación y consulta. Además de dejar que los jugadores puedan gestionar las solicitudes de unión a un proyecto.

Un proyecto es una unidad de trabajo dentro del servidor BTE Cono Sur que representa la construcción o desarrollo de una zona específica del mundo en Minecraft. Cada proyecto agrupa a uno o más jugadores que colaboran en una misma área

La lógica de negocio y persistencia será gestionada por un servicio externo: el plugin **bteCSCore**, el cual forma parte del servidor de Minecraft y mantiene los datos tanto en base de datos como en memoria mediante un sistema de cache.

---

## 2 - Contexto del sistema

### BTE Cono Sur

BTE Cono Sur es el servidor que agrupa a los equipos de varios países de Sudamérica dentro del proyecto Build The Earth.

### bteCSCore

bteCSCore es el plugin central del servidor BTE Cono Sur. Provee:

- Gestión de proyectos
- Sistema de permisos
- Persistencia de datos

---

## 3 - Modelo de dominio

### Entidades

- Jugador
  - id
  - nombre
  - usuario de discord

- Proyecto
  - id
  - nombre
  - descripción

- Participación
  - id
  - jugador_id
  - proyecto_id

---

## 4 - Arquitectura
[ Browser ]
->
[ Servlets (Tomcat) ]
-> HTTP
[ Plugin bteCSCore (Minecraft) ]
->
[ DB ]

---

## 5 - Alcance Funcional

### 5.1 - Regularidad

#### ABMC simple
- ABMC de Jugador

#### ABMC dependiente
- ABMC de Proyecto (Depende de un Jugador)

#### Caso de Uso NO-ABMC
- Asignar jugador a proyecto validando que no esté repetido

#### Listado
- Listado simple de jugadores con sus proyectos

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
